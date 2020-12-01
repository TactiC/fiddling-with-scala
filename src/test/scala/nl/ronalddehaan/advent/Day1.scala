package nl.ronalddehaan.advent

import scala.io.Source

object Day1 extends App {

  val isTwentyTwenty: (Int, Int) => Boolean = (a,b) => a + b == 2020

  val source = Source.fromFile("numbers.txt")
  val numbers = source.getLines().toList
  val (threeDigits, fourDigits) = numbers.partition(p => p.length > 3)

  val foo = threeDigits.flatMap { three =>
    fourDigits.collect {
      case four if (isTwentyTwenty(four.toInt, three.toInt)) => four.toInt * three.toInt
    }
  }
  println(s"Solution of day 1 is ${foo.head}")
  source.close()
}
