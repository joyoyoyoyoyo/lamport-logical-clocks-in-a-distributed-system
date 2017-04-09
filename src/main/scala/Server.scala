import java.net.ServerSocket

class Server(host: String = "localhost", port: Int) extends Runnable {
  val server = new ServerSocket(port)

  override def run(): Unit = {
    while(true) {
      val client = server.accept()
    }
  }
}
