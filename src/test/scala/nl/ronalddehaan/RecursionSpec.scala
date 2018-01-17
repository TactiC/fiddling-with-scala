package nl.ronalddehaan

import org.scalatest.{FlatSpec, Matchers}
import Recursion._

class RecursionSpec extends FlatSpec with Matchers {

  "count" should "count all items in a given list" in {
    val xs = List(1,2,3,4,5,6)
    val text = "hello world".toList

    assert(count(xs) == 6)
    assert(count(text) == 11)
  }

  "count2" should "yield the same results" in {
    val xs = List(1,2,3,4,5,6)
    val text = "hello world".toList

    assert(count2(xs) == 6)
    assert(count2(text) == 11)
  }

  "The tail recursion in count2" should "prevent it from blowing up" in {
    val tenMillion = 10000000
    val xs = List.range(0, tenMillion)
    assert(count2(xs) == tenMillion)
  }

  //0,1,1,2,3,5,8,13,21,34,55
  "Fibonacci" should "return correct values" in {
    assert(fibonacci(0) == 0)
    assert(fibonacci(1) == 1)
    assert(fibonacci(5) == 5)
    assert(fibonacci(6) == 8)
    assert(fibonacci(8) == 21)
  }
}
