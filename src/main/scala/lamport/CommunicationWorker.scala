package lamport

import java.util.concurrent.{BlockingQueue, LinkedBlockingQueue}

class CommunicationWorker(person: Person, messages: BlockingQueue[String]) extends Thread {
  setDaemon(true)
  var x = 1
  override def run(): Unit = {
    while (true) {
      Thread.sleep(1000)
      if (x %3 == 0)
        messages.put("receive")
      else
        messages.put("nope")
      x = x+1
    }
  }

}
