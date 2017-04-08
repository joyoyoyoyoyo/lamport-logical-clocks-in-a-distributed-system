import scala.collection.mutable.Queue

//type Tasks = collection.mutable.Queue[() => Unit]
object SynchronizedLifeEventPool extends App {
  private val lifeEvents = collection.mutable.Queue[ () => Unit ]()

  object CommunicationThread extends Thread {
    setDaemon(true)

    def poll(): () => Unit = lifeEvents.synchronized {
      while (lifeEvents.isEmpty) lifeEvents.wait()
      lifeEvents.dequeue()
    }

    override def run(): Unit = {
      super.run()
      while (true) {
        val lifeEvent = poll()
        lifeEvent()
      }
    }
  }

//  CommunicationThread.

  CommunicationThread.start()

  def asynchronousEventHappen(body: => Unit): Unit = lifeEvents.synchronized {
    lifeEvents.enqueue(() => body)
    lifeEvents.notify()
  }
  asynchronousEventHappen( println(s"${Thread.currentThread().getId}: Hello"))
  asynchronousEventHappen( println(s"${Thread.currentThread().getId}: World!"))
  Thread.sleep(500)

}