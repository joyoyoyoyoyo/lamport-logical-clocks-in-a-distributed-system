import java.net.BindException
import java.util.concurrent.LinkedBlockingQueue



/**
  * Created by AngelOrtega on 4/10/2017.
  */
object Asg extends App {
  val queue = new LinkedBlockingQueue[String]()
  val clock = LamportClock

  // read in the file arguments
  try {
    val server = EventLifeCycle.start(args, queue, clock)
    while (server.isRunning )
      1
  } catch {
    case x: BindException => println("could not bind to socket")
  }
  //TODO: Handle "Process finished with exit code 130 (interrupted by signal 2: SIGINT)"


}

