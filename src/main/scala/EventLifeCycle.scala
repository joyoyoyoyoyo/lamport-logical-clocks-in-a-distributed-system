import java.io.{DataInputStream, DataOutputStream}
import java.util.concurrent.LinkedBlockingQueue

import Server.serverSocket

object EventLifeCycle extends App {
  val queue = new LinkedBlockingQueue[String]()

  val producer = new Producer[String]("sampleP1.txt", queue)
  new Thread(producer).start()


  // collect sampleP[0-9]+.txt for each process
  for (arg <- args) {

    // construct producers on unique threads for each sample input

  }

  def matchTest(x: Int): String = {
    x match {
      case 1 => "one"
      case 2 => "two"
      case y: Int => "scala.Int"
    }
  }
}
