//import lamport.Main.{file, port}
import java.util.concurrent.BlockingQueue

import scala.io.Source
import scala.util.Try

case class InvalidUsageException(message: String) extends Exception(message)
case class ConnectionSchedulingException(message: String) extends Exception(message)

object EventLifeCycle {
//  val date = raw"(\d{4})-(\d{2})-(\d{2})".r
//  val port = s"""call\w+(${ipAddressRegex.regex}|${validDNSHostnameRegex.regex})\w+[0-9]""".r
//  val ipAddressRegex = """(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])"""".r
//  val validDNSHostnameRegex = """([a-zA-Z0-9]|[a-zA-Z0-9][a-zA-Z0-9\-]*[a-zA-Z0-9])\.)*([A-Za-z0-9]|[A-Za-z0-9][A-Za-z0-9\-]*[A-Za-z0-9])""".r
  var isRunning = true

  def start(args: Array[String], queue: BlockingQueue[String], clock: LamportClock.type): EventLifeCycle.type = {
    args match {
      case Array(port :String, filename: String) =>
        if (Try(port.toInt).isSuccess) {
          val events = Source.fromFile(filename).getLines().toList
          val server = new Server(port.toInt, queue)
          server.start()
          Thread.sleep(1000)
          val person = new Person(queue, server,clock)
          events.foreach(person.process)
          person.start()
          isRunning = false
          this
//          (port.toInt, events)
        }
        else {
          throw InvalidUsageException("Port is not an Int type")
        }
      case Array(_) => throw InvalidUsageException("Missing options")
      case _ => throw InvalidUsageException("Invalid Usage: args [port] [filename]")
    }
  }


}
