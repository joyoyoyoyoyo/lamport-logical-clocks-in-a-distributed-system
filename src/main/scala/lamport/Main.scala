package lamport

import java.util.concurrent.{BlockingQueue, LinkedBlockingQueue}
import scala.io.Source

/**
  * Created by AngelOrtega on 4/10/2017.
  */
object Main extends App {



  val file = args(1)
  val port = args(0)

  // Create the communication thread


  val events = Source.fromFile(file).getLines().toStream
  val clock = LamportClock

//  val queue = new LinkedBlockingQueue[String]()
//  val personLifeCycle = new PersonLifecycle(events)

  val person = new Person()
  val communicationWorker = new CommunicationWorker(person,person.queue)
  person.start()
  communicationWorker.start()

  while (true)
    1
//  for (event <- events) println(event)
//  val x = (event: String) => { new Event(event) }
//  val tick = (event: Event[String]) => {event.clock = _ + 1}
//  val events = args.toStream
//  println(events)

}