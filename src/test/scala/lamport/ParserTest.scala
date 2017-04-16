package lamport

import org.scalatest._

class ParserTest extends FlatSpec {
  val simple_call_regex = raw"call\s+((?:[\d]{3}\.[\d].[\d].[\d])|[a-zA-Z.]+)\s+([\d]{4})".r
  val ipAddressRegex = raw"(?:(?:[0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\.){3}(?:[0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])".r
  val validDNSHostnameRegex = raw"(?:(?:[a-zA-Z0-9]|[a-zA-Z0-9][a-zA-Z0-9\-]*[a-zA-Z0-9])\.)*(?:[A-Za-z0-9]|[A-Za-z0-9][A-Za-z0-9\-]*[A-Za-z0-9])".r
  val validPort = raw"(?:[0-9]{1,4}|[1-5][0-9]{4}|6[0-4][0-9]{3}|65[0-4][0-9]{2}|655[0-2][0-9]|6553[0-5])".r
//  val call = rawcall\w+(${ipAddressRegex.regex}|${validDNSHostnameRegex.regex})\w+[0-9]""".r
  val testOk = raw"call\w(${validDNSHostnameRegex.regex}|${ipAddressRegex.regex})\w(${validPort.regex})".r

  "A domain" should "extract from the program argument" in {
    val sampleInput = "call    h.com    5002"
    sampleInput match {
      case simple_call_regex(domain, port) => {
        println(s"Domain: $domain\tPort: ${port}")
        assert(true)
      }
      case _ => assert(false)
    }
  }

  it should "throw NoSuchElementException if an empty stack is popped" in {
    val emptyStack = List[String]()
    assertThrows[NoSuchElementException] {
      emptyStack.head
    }
  }
}
