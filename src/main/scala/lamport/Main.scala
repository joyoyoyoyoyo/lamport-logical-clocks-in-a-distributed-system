package lamport

import java.util.concurrent.{BlockingQueue, LinkedBlockingQueue}
import scala.io.Source

/**
  * Created by AngelOrtega on 4/10/2017.
  */
object Main extends App {

  // read in the file arguments
  val file = args(1)
  val port = args(0)
  val events = Source.fromFile(file).getLines().toStream

  // initialize the queue and clock
  val queue = new LinkedBlockingQueue[String]()
  val clock = LamportClock

  // Create the communication thread
  val server = new Server(queue)
  server.start()

  Thread.sleep(1000)

  // Create the Processing Thread
  val person = new Person(queue,server)

  for(event<- events)
    person.process(event)

  person.start()

  while (true)
    1
//  for (event <- events) println(event)
//  val x = (event: String) => { new Event(event) }
//  val tick = (event: Event[String]) => {event.clock = _ + 1}
//  val events = args.toStream
//  println(events)

}