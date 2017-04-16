package lamport

/**
  * Created by AngelOrtega on 4/10/2017.
  */
//object LamportClock extends Thread {
object LamportClock {
  var time: Int = 0

  def tick(): Int = {
    time += 1
    time
  }
//  override def toString = s"Thread ID: ${Thread.currentThread().getId}\t\tCurrent time: $time"
  override def toString = s"$time"

  def takeMax(rcvdTime: Int): Unit = {
    if (rcvdTime > time) time = rcvdTime + 1
    else time = time+1
  }
}