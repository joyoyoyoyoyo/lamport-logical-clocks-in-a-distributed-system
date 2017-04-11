package executable

import java.util.concurrent._

import scala.io.Source
import lamport.LamportClock

/**
  * Created by AngelOrtega on 4/10/2017.
  */
object Main extends App {

  val port = args(0)
  val file = args(1)
  val events = Source.fromFile(file).getLines().toStream
  val clock = LamportClock

  private val queue:BlockingQueue[String] = new ArrayBlockingQueue[String](1024)

  
//  val messageProducer = new Thread {
//    setDaemon(true)
//    override def run() = {
//      while (true) queue.take() match {
//        case msg: String => println(msg)
//        case _ => println("Error")
//      }
//    }
//  }

//  queue.put("2")


//  val test = new Thread {
//    override def run(): Unit = {
//      while (queue.isEmpty)
//      queue take() match {
//        case msg: String => 1 //consumer.recv()
//        case _ => // exception
//      }
//    }
//  }



//  val personLifeCycle = new PersonLifecycle(events)


  //  for (event <- events) println(event)
  //  val x = (event: String) => { new Event(event) }
  //  val tick = (event: Event[String]) => {event.clock = _ + 1}
  //  val events = args.toStream
  //  println(events)

}
