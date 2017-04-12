package lamport

import java.net.{InetAddress, InetSocketAddress, ServerSocket, Socket}
import java.util.concurrent.BlockingQueue


//import scala.sys.process.processInternal.{InputStream, OutputStream}

class Server(queue: BlockingQueue[String]) extends Thread {
//  this.setDaemon(true)
  val port = 9999

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

      //      handleConnection(client)
        //      Thread.sleep(10000)
    }
  }




}
