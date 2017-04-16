package lamport

import java.util.concurrent.BlockingQueue

import helper.{EventLifeCycle, InvalidUsageException}

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
          clock.tick()
          server.call(domain, port.toInt)
          print(s"${clock.time} ")
          //          println(event + s" ${clock.time}")
//          print(s"${clock.time} ")

        }
        else
          throw InvalidUsageException("Port is not an Int type")
      case "receive call" => {
          clock.takeMax(queue.take.toInt)
          print(s"${clock.time} ")
        //          println("receive call" + s" ${clock.time}" )
      }
      case _: String => {
        // default
        clock.tick()
        print(s"${clock.time} ")
        //        println(event + s" ${clock.tick()}")
      }
//      case _ => EventLifeCycle.isRunning = false
    }
  }


}
