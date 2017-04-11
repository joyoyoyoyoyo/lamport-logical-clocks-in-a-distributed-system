//import java.util.concurrent.{BlockingQueue, LinkedBlockingQueue}
//
////type Tasks = collection.mutable.Queue[() => Unit]
//object SynchronizedLifeEventPool extends App {
//  private val lifeEvents: BlockingQueue[() => Unit] = new LinkedBlockingQueue[ () => Unit ]()
//
//  class CommunicationWorker extends Thread {
//    setDaemon(true)
//    def poll(): () => Unit = lifeEvents.synchronized {
//      while (lifeEvents.isEmpty) lifeEvents.wait()
//      lifeEvents.take()
//    }
//
//    override def run(): Unit = {
//      super.run()
//      while (true) {
//        val lifeEvent = poll()
//        lifeEvent()
//      }
//    }
//    def asynchronousEventHappen(body: => Unit): Unit = lifeEvents.synchronized {
//      lifeEvents.put(() => body)
//      lifeEvents.notify()
//    }
//
//
//  }
//
////  CommunicationThread.
//
//  val communicationThread = new CommunicationThread
//  communicationThread.start()
//  val communicationThread2 = new CommunicationThread
//  communicationThread2.start()
//  val communicationThread3 = new CommunicationThread
//  communicationThread3.start()
//
//  communicationThread.asynchronousEventHappen( println(s"${communicationThread.getId}: Hello"))
//  communicationThread.asynchronousEventHappen( println(s"${communicationThread.getId}: World!"))
//  communicationThread3.asynchronousEventHappen( println(s"${communicationThread3.getId}: Hello"))
//  communicationThread3.asynchronousEventHappen( println(s"${communicationThread3.getId}: World!"))
//  communicationThread2.asynchronousEventHappen( println(s"${communicationThread2.getId}: Hello"))
//  communicationThread2.asynchronousEventHappen( println(s"${communicationThread2.getId}: World!"))
//  communicationThread.asynchronousEventHappen( println(s"${communicationThread.getId}: Hello"))
//  communicationThread.asynchronousEventHappen( println(s"${communicationThread.getId}: World!"))
//  Thread.sleep(500)
//
//}