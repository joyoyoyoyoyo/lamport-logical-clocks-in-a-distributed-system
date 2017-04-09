import java.util.concurrent.LinkedBlockingQueue

import producerconsumer.Producer

object EventLifeCycle extends App {
  val queue = new LinkedBlockingQueue[String]()

  val producer = new Producer[String]("sampleP1.txt", queue)
  val consumer = new CommunicationConsumer(queue)


  val life = new Thread(producer)
//  life.setDaemon(true)
  life.start()
  val communication = new Thread(consumer)
//  communication.setDaemon(true)
  communication.start()
//  queue.put("Test")

  //  new Thread(consumer).start()
//  producer.run()
//  consumer.consume("Test1")

//  consumer.consume("Test2")
//  consumer.consume("Test3")
//  consumer.consume("Test4")
//  consumer.makeMessage("test1")


  // collect sampleP[0-9]+.txt for each process
//  for (arg <- args) {

    // construct producers on unique threads for each sample input

//  }
}
