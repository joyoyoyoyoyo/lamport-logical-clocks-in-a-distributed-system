package lamport

import java.util.concurrent.{BlockingQueue, LinkedBlockingQueue}


class Person extends Thread {
  setDaemon(true)
  val queue = new LinkedBlockingQueue[String]

  def recv(): Unit = {
    while(true) {
      val msg = queue.take() match {
        case msg: String => process(msg)
        case _ => println("error")
      }
    }
  }

  def process(event: String): Unit = {
    println(event)
  }

  override def run(): Unit = {
    while (true) {
      var x = "receive"
      x match {
        case "test" => println("Hello")
        case "receive" => recv()
      }
    }
  }
}