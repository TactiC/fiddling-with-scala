package nl.ronalddehaan

import scala.collection.mutable

trait Persister[T] {
  self: Database[T] =>
    def persist(data: T): Unit = {
      println("Persisting stuff")
      save(data)
    }
}

trait Database[T] {
  def save(data: T)
}

trait InMemoryDb[T] extends Database[T] {
  val db: mutable.MutableList[T] = mutable.MutableList.empty

  override def save(data: T): Unit = {
    println("Saving to memory")
    db += data
  }
}

class InMemoryPersister[T] extends Persister[T] with InMemoryDb[T]

object SelfTypes extends App {
  val memoryPersister = new InMemoryPersister[String]
  memoryPersister.persist("ronald")
}
