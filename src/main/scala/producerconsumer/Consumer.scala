package producerconsumer

import java.util.concurrent.BlockingQueue

abstract class Consumer[Int](queue: BlockingQueue[Int]) extends Runnable {

  override def run(): Unit = {
    while (true) {
      val clockValue = queue.take()
      consume(clockValue) // where is this retrieved?
    }
  }

  def consume(clockValue: Int): Unit
}
