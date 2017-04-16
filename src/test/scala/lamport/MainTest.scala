package lamport


import org.scalatest._

class MainTest extends FlatSpec{

  "A Stack" should "pop values in last-in-first-out order" in {
    val stack = 1:: 2:: List[Int]()
    assert(stack.tail.head === 2)
    assert(stack.tail.head === 2)
  }

  it should "throw NoSuchElementException if an empty stack is popped" in {
    val emptyStack = List[String]()
    assertThrows[NoSuchElementException] {
      emptyStack.head
    }
  }
}
