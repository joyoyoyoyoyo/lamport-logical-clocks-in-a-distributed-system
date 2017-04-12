package lamport

import java.net.{InetAddress, InetSocketAddress, Socket}

object Client extends App {
  val host: InetAddress = InetAddress.getByName("localhost")
  val port = 9999

  val socket =  new Socket(host, port)
  socket.getOutputStream.write("Hello World".getBytes)
  socket.getOutputStream.close()
}
