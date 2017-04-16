import java.io.PrintStream
import java.net.{ConnectException, _}
import java.util.concurrent.BlockingQueue


case class ServerCouldNotStartException(message: String) extends Exception(message)


//import scala.sys.process.processInternal.{InputStream, OutputStream}
class Server(listeningPort: Int, queue: BlockingQueue[String]) extends Thread {
  this.setDaemon(true)
//  val queue: BlockingQueue[String] = new LinkedBlockingQueue[String]()
  val port: Int = listeningPort

  // spawn server
  lazy val server = new ServerSocket(port)
  var connectAttempts = 0
  val MAX_CONNECT_ATTEMPTS = 5

  override def run(): Unit = {
    try {
//      println(s"Listening on port: $port...")
      while (true) {
        val client = server.accept()
        //      println(s"Connection accepted from: ${client.getRemoteSocketAddress}")
        val stream_in = scala.io.Source.fromInputStream(client.getInputStream)
        for (line <- stream_in.getLines())
          queue.put(line)
        client.close()
        //      println("Connection Closed")

      }
    }
    catch {
      case e: SocketException =>
        throw ServerCouldNotStartException(s"Could not start server: ${server.getInetAddress}:${server.getLocalPort}")
    } finally {
      server.close()
    }
  }

  def call(domain: String, port: Int): Unit = {
    try {

      val socket = new Socket(domain, port)
      val outgoingCall = new PrintStream(socket.getOutputStream)
//      val outgoingB = new DataOutputStream(socket.getOutputStream)
      val x = LamportClock.time.toString
      socket.getOutputStream.write(x.getBytes)
//      outgoingB.write(x.getBytes)
//      outgoingCall.print(s"i called $domain:$port")

      socket.close()


    }
    catch {
      case  e: ConnectException => {
        connectAttempts = connectAttempts + 1
        if (connectAttempts < MAX_CONNECT_ATTEMPTS) {
          Thread.sleep(2000) // wait 2 seconds
          call(domain, port)
        }
        else {
          val msg = s"Connect to $domain:$port refused after $connectAttempts attempts made.\nShutting down program."
          throw ConnectionSchedulingException(msg)
        }
      }
    }
  }




}
