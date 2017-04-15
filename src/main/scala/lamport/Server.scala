package lamport

import java.io.PrintStream
import java.net.{InetAddress, InetSocketAddress, ServerSocket, Socket}
import java.util.concurrent.BlockingQueue


//import scala.sys.process.processInternal.{InputStream, OutputStream}
// maybe do case class?
class Server(queue: BlockingQueue[String], socket_port: Int) extends Thread {
  this.setDaemon(true)
  val port: Int = socket_port

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
    val socket = new Socket("localhost", port) //TODO: Handle connection refused
    val outgoingCall = new PrintStream(socket.getOutputStream)
    outgoingCall.print("i called myself")
    println("call")
    //  socket.getOutputStream.write("Hello World2".getBytes)
    socket.close()
    // shutdown server
  }




}
