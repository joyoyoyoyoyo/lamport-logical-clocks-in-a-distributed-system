package lamport

import java.util.concurrent.BlockingQueue

import scala.io.Source
/**
  * Created by AngelOrtega on 4/10/2017.
  */
object Main extends App {


  val file = args(1)
  val port = args(0)
  val events = Source.fromFile(file).getLines().toStream
  val clock = LamportClock

  val queue = new BlockingQueue[String]()
  val personLifeCycle = new PersonLifecycle(events)


//  for (event <- events) println(event)
//  val x = (event: String) => { new Event(event) }
//  val tick = (event: Event[String]) => {event.clock = _ + 1}
//  val events = args.toStream
//  println(events)

}
package lamport

/**
  * Created by AngelOrtega on 4/10/2017.
  */
class PersonLifecycle(events: Stream[String]) extends Runnable {
  override def run(): Unit = {

  }
}
package lamport

/**
  * Created by AngelOrtega on 4/10/2017.
  */
class Event(x: String) {
  val name: String = x
  val clock: Int = 0
}
package lamport

/**
  * Created by AngelOrtega on 4/10/2017.
  */
object LamportClock extends Thread {
  private var time = 0

  def tick(): Int = {
    time += 1
    time
  }

  override def toString = s"Thread ID: ${Thread.currentThread().getId}\t\tCurrent time: $time"
}