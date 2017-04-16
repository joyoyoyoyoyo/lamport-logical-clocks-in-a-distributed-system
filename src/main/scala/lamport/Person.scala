package lamport

import java.util.concurrent.{BlockingQueue}

import helper.InvalidUsageException

import scala.util.Try


class Person(queue: BlockingQueue[String], server: Server, clock: LamportClock.type) extends Thread {
  setDaemon(true)
  val simple_call_regex = raw"call\s+((?:[\d]{3}\.[\d].[\d].[\d])|[a-zA-Z.]+)\s+([\d]{4})".r

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
      case simple_call_regex(domain, port) =>
        if (Try(port.toInt).isSuccess) {
          server.call(domain, port.toInt)
          println(event + s" ${clock.time}")
        }
        else
          throw InvalidUsageException("Port is not an Int type")
      case "receive call" => {
          clock.takeMax(queue.take.toInt)
          println("receive call" + s" ${clock.time}" )
      }
//      case event if event.startsWith("call") =>
      case _: String => println(event + s" ${clock.tick()}" )
    }
  }


}
