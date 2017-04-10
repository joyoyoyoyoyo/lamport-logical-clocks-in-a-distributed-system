import java.util.concurrent.BlockingQueue

import producerconsumer.Consumer

class CommunicationConsumer(queue: BlockingQueue[Int]) extends Consumer[Int](queue) with MessageMaker {
  override def consume(clockValue: Int): Unit = {
    queue.take()
  }
}
