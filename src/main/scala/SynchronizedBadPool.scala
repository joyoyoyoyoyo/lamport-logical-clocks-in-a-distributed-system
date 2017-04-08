//import scala.collection.parallel.
import scala.collection._

object SynchronizedBadPool extends App {
  private val tasks = mutable.Queue[() => Unit]()
}