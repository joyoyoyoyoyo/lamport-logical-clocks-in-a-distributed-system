import scala.collection.parallel.mutable.ParArray

object Main extends App {

  // opening servers and binding on ports
  val s1 = new Server("localhost", 5001)
  val s2 = new Server("localhost", 5002)
  val s3 = new Server("localhost", 5003)
  val servers = List(s1, s2, s3).par
//  val servers = new collection.parallel.immutable.ParVector[Server](s1,s2,s3)
//  servers ++ Seq(s1, s2, s3)
//  servers.foreach[Server]((server: Server) => server.start())
  servers.foreach(_.start())
//  servers.map((server: Server) => server.start)
  println("Done")
//  servers.apply(x: Server => )
//  s1.start()
//  s2.start()
//  s3.start()
//  val c1 = new Client("localhost", 4000)
//  val c2 = new Client("localhost", 4000)
//  val c3 = new Client
}
