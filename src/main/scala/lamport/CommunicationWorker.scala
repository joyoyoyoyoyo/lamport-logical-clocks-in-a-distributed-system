package lamport

import java.io.PrintStream
import java.net.Socket
import java.util.concurrent.{BlockingQueue, LinkedBlockingQueue}

import lamport.Client.socket

class CommunicationWorker(person: Person, messages: BlockingQueue[String]) extends Thread {
//  setDaemon(true)
  var x = 1
  val msgReceived = false

//  override def run(): Unit = {
//    while (true) {
//      Thread.sleep(1000)
//      if (x %3 == 0)
//        messages.put("receive")
//      else
//        messages.put("nope")
//      x = x+1
//    }
//  }

  def recv(msg: String): Unit = {
    messages.put(msg)
  }

}
