package lamport

import java.util.concurrent.{BlockingQueue, LinkedBlockingQueue}

class CommunicationWorker(person: Person, messages: BlockingQueue[String]) extends Thread {
  setDaemon(true)
  var x = 1
  override def run(): Unit = {
    while (true) {
      Thread.sleep(1000)
      messages.put("receive")
      x = x+1
    }
  }

}
