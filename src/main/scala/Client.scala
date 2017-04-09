import java.net.Socket

class Client(host: String = "localhost", port: Int) {
  val client = new Socket(host, port)
}
