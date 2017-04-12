import java.io.PrintStream
import java.net.{InetAddress, InetSocketAddress, ServerSocket, Socket}
import java.util.concurrent.{BlockingQueue, LinkedBlockingQueue}

object ServerTwo extends Thread {

  this.setDaemon(true)


  //import scala.sys.process.processInternal.{InputStream, OutputStream}

    val port = 9998
    val queue = new LinkedBlockingQueue[String]()
    // spawn server
    val server = new ServerSocket(port)

    override def run(): Unit = {
      println(s"Listening on port: $port...")
      while(true) {
        val client = server.accept()
        println(s"Connection accepted from: ${client.getRemoteSocketAddress}")
        val stream_in = scala.io.Source.fromInputStream(client.getInputStream)
        for (line <- stream_in.getLines())
          queue.put(line)
        client.close()
        println("Connection Closed")

      }
    }

    def call(): Unit = {
      val socket = new Socket("localhost", 9999)
      val outgoingCall = new PrintStream(socket.getOutputStream)
      outgoingCall.print("i called myself")
      //  socket.getOutputStream.write("Hello World2".getBytes)
      socket.close()
    }





}
