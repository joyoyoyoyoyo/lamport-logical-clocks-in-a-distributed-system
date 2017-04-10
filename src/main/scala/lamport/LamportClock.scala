package lamport

/**
  * Created by AngelOrtega on 4/10/2017.
  */
object LamportClock extends App {
  private var time = 0

  def tick(): Int = {
    time += 1
    time
  }

//  def apply(): Int = time + 1

  println(LamportClock.time)
  println(LamportClock.tick)
  println(LamportClock.time)
  println(LamportClock.tick)
}