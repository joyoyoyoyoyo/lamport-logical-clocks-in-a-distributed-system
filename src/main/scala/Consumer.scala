import java.util.concurrent.BlockingQueue

abstract class Consumer[T](queue: BlockingQueue[T]) extends Runnable {

  override def run(): Unit = {
    while (true) {
      val localEvent = queue.take()
      consume(localEvent)
    }
  }

  def consume(x: T): Unit
}
