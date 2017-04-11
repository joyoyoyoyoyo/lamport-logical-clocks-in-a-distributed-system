//import java.util.concurrent.LinkedBlockingQueue
//
//import producerconsumer.Producer
//
//object EventLifeCycle extends App {
//  val queue = new LinkedBlockingQueue[String]()
//
//  val producer = new Producer[String]("sampleP1.txt", queue)
//  val consumer = new CommunicationConsumer(queue)
//
//
//  val life = new Thread(producer)
//  life.start()
//  val communication = new Thread(consumer)
//  communication.start()
//
//}
