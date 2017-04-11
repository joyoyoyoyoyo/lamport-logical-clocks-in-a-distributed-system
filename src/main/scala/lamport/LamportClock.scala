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
