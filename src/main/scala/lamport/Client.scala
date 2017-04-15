package lamport

import java.io.{BufferedOutputStream, PrintStream}
import java.net.{InetAddress, InetSocketAddress, Socket}

object Client extends App {
  val host: InetAddress = InetAddress.getByName("localhost")
  val port = 5001

  val socket =  new Socket(host, port)
  val out = new PrintStream(socket.getOutputStream)
  out.print("HI")

  //  socket.getOutputStream.write("Hello World2".getBytes)
  socket.close()
}
