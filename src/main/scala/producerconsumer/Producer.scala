package producerconsumer

import java.util.concurrent.BlockingQueue

class Producer[T](event: T, queue: BlockingQueue[T]) extends Runnable {

  override def run(): Unit = {
    queue.put(event)
  }
}
