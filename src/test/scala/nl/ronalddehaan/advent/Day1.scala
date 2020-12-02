package nl.ronalddehaan.advent

import scala.io.Source

object Day1 extends App {

  val isTwentyTwenty: (Int, Int) => Boolean = (a,b) => a + b == 2020

  val (fourDigits, threeDigits) = {
    val source = Source.fromFile("numbers.txt")
    val (a, b) = source.getLines().toList.partition(_.length > 3)
    source.close()
    (a.map(_.toInt), b.map(_.toInt))
  }

  val result = fourDigits.flatMap { three =>
    threeDigits.collect {
      case four if isTwentyTwenty(four, three) => four * three
    }
  }

  val part2 = {
    val source = Source.fromFile("numbers.txt")
    val numbers = source.getLines().toList.map(_.toInt)
    source.close()
    for (a <- numbers; b <- numbers; c <- numbers if a + b + c == 2020) yield (a * b * c)
  }

  println(s"Solution of day 1 is ${result.head}")
  println(s"Solution of day 1 part II is ${part2.head}")
}
