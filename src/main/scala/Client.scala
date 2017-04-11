import java.net.Socket


object Client {
  type LamportClock = Int
  val host = "localhost"
  val port = 6666
  val socket = new Socket(host, port)

  def getLocalProcessNumber(): Unit = {
    val pid = 1010
    pid
  }



  def send(msg: String, dest: String, lamportClock: LamportClock): Unit = {
//    socket.send
  }
}
