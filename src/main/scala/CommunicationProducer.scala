import java.util.concurrent.BlockingQueue

/**
  * Created by AngelOrtega on 4/9/2017.
  */
class CommunicationProducer[Int](clockCount: Int, queue: BlockingQueue[Int]) extends Runnable {
  override def run(): Unit = {
    // triggered by a call event
    queue.put(clockCount)
  }
}
