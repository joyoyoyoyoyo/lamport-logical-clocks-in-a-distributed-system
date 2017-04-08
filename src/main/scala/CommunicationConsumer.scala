import java.io.{DataInputStream, DataOutputStream}
import java.net.ServerSocket
import java.util.concurrent.BlockingQueue

import Server.serverSocket
import SynchronizedLifeEventPool.CommunicationThread.setDaemon
import SynchronizedLifeEventPool.lifeEvents

class CommunicationConsumer(message: String, queue: BlockingQueue[String]) extends Consumer[String](queue) with MessageMaker {
  override def consume(message: String): Unit = {
    println(s"Thread ID: ${Thread.currentThread().getId}" +
      s"\tMessage: ${message}")
  }
  setDaemon (true)
  def spawnServer(): Unit = {
    val port = 6666
    val serverSocket = new ServerSocket(port)
  }



//  def recv(buffer: Any, queue: Any): Unit = {
//    val clientSocket = serverSocket.accept()
//    val msg = new DataInputStream(clientSocket.getInputStream)
//    val response = new DataOutputStream(clientSocket.getOutputStream)
//  }
//  def poll(): () => Unit = lifeEvents.synchronized {
//    while (lifeEvents.isEmpty) lifeEvents.wait()
//    lifeEvents.dequeue()
//  }
//
//  override def run(): Unit = {
//    super.run()
//    while (true) {
//      val lifeEvent = poll()
//      lifeEvent()
//    }
}
