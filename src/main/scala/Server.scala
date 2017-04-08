import java.net.ServerSocket
import java.net._
import java.io.{DataInputStream, DataOutputStream}

//import java.nio.Buffer


object Server extends App {
  type LamportClock = Int

  if (args.isEmpty) {
    println("Usage: [socket] [input-file-path]") // Example: ./asg1 5001 p1.txt
    sys.exit()
  }
  // allow for the local machine to become a server with an open port
  val port = 6666
  val serverSocket = new ServerSocket(port)

  // pass in any condition or code block using by-name arguments
  def run(block : => Unit, signal : => Boolean) : Unit = {
    if (!signal) {
      block
      run(block, signal)
    }
  }

  def recv(buffer: Any, queue: Any): Unit = {
    val clientSocket = serverSocket.accept()
    val msg = new DataInputStream(clientSocket.getInputStream)
    val response = new DataOutputStream(clientSocket.getOutputStream)
  }

  def updateClockOnRecv(lamportClock: LamportClock) : Unit = {

  }

  val communicationThread = new Thread {

  }
  communicationThread.setName("Communication Thread")
  communicationThread.setDaemon(true)
  communicationThread.start()

}
