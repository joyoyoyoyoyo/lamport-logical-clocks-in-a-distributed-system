import java.net.ServerSocket

class Server(host: String = "localhost", port: Int){
  val server = new ServerSocket(port)

  def start(): Unit = {
    while(true) {
      val client = server.accept
    }
  }
}
