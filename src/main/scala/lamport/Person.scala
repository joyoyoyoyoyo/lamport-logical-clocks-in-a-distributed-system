package lamport

import java.util.concurrent.{BlockingQueue, LinkedBlockingQueue}


class Person(queue: BlockingQueue[String], server: Server) extends Thread {
  setDaemon(true)

  override def run(): Unit = {
    while(true) {
      val msg = queue.take() match {
        case msg: String => process(msg)
        case _ => println("error")
      }
    }
  }

  def process(event: String): Unit = {
    event match {
      case "receive call" => println(queue.take())
      case event if event.startsWith("call") => server.call()
      case _: String => println(event)
    }
  }

}
