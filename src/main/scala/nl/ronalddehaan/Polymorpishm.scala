package nl.ronalddehaan

trait Adder[T] {
  def sum(a: T, b: T): T
}

object Adder {
  def sum[T:Adder](a: T, b: T): T = implicitly[Adder[T]].sum(a, b)
  implicit val int2Adder: Adder[Int] = (a: Int, b: Int) => a + b
  implicit val string2Adder: Adder[String] = (a: String, b: String) => a + b
}

object Polymorpishm extends App {
  import Adder._

  println(s"The sum of 1 and 2 is ${sum(1, 2)}")
  println(s"Adding foo and bar gives ${sum("foo", "bar")}")
}
