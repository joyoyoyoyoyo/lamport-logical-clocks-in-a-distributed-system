package lamport

import java.net.{InetAddress, InetSocketAddress, ServerSocket, Socket}


//import scala.sys.process.processInternal.{InputStream, OutputStream}

class Server(communicationWorker: CommunicationWorker) {
  val port = 9999

  // spawn server
  val server = new ServerSocket(port)
  while(true) {
    println(s"Listening on port: $port...")
    val client = server.accept()
    println(s"Connection accepted from: ${client.getRemoteSocketAddress}")
    handleConnection(client)
  }

  def handleConnection(socket: Socket): Unit = {
    val msg = scala.io.Source.fromInputStream(socket.getInputStream).mkString
    send(msg)
//    val input: InputStream = socket.getInputStream
//    val output: OutputStream = socket.getOutputStream


  }

  def send(msg: String) = {
    communicationWorker.recv(msg)
  }
}
