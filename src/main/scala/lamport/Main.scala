package lamport

import java.util.concurrent.{BlockingQueue, LinkedBlockingQueue}
import scala.io.Source

/**
  * Created by AngelOrtega on 4/10/2017.
  */
object Main extends App {

  // read in the file arguments
  //TODO: Print out error usage cases
  if (args.length < 2)
    sys.exit()
  val file = args(1) //TODO: test parse correctly
  val port = args(0).toInt //TODO: test parse correctly
  val events = Source.fromFile(file).getLines().toStream

  // initialize the queue and clock
  val queue = new LinkedBlockingQueue[String]()
  val clock = LamportClock

  // Create the communication thread
  val server = new Server(queue, port)
  server.start()

  Thread.sleep(1000)

  // Create the Processing Thread
  val person = new Person(queue,server)

  for(event<- events)
    person.process(event)

  person.start()

  while (true)
    1

  //TODO: Handle "Process finished with exit code 130 (interrupted by signal 2: SIGINT)"

  //  for (event <- events) println(event)
//  val x = (event: String) => { new Event(event) }
//  val tick = (event: Event[String]) => {event.clock = _ + 1}
//  val events = args.toStream
//  println(events)

}