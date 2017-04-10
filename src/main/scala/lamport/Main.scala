package lamport

import scala.io.Source
/**
  * Created by AngelOrtega on 4/10/2017.
  */
object Main extends App {


  val file = args(1)
  val port = args(0)
  val events =  Source.fromFile(file).getLines().toStream
  for (event <- events) println(event)
  val x = (event: String) => { new Event(event) }
//  val tick = (event: Event[String]) => {event.clock = _ + 1}
//  val events = args.toStream
//  println(events)

}
