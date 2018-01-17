package nl.ronalddehaan

import scala.annotation.tailrec

object Recursion extends App {

  /**
    * Count all the items in a given list
    */
  def count[T](xs: List[T]): Int = {
    if (xs.isEmpty) 0
    else 1 + count(xs.tail)
  }

  /**
    * Same thing as count, but using tail recursion
    */
  def count2[T](xs: List[T]): Int = {
    @tailrec
    def recur(xs: List[T], acc: Int): Int = {
      xs match {
        case Nil       => acc
        case _ :: tail => recur(tail, acc + 1)
      }
    }
    recur(xs, 0)
  }

  def fibonacci(n: Int) = {
    @tailrec
    def fibo(n: Int, a: Int, b: Int): Int = {
      n match {
        case 0 => b
        case _ => fibo(n-1, a+b, a)
      }
    }
    fibo(n, 1, 0)
  }
}

