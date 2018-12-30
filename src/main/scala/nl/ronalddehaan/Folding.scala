package nl.ronalddehaan

object Folding extends App {

  class Foo(val name: String, val age: Int, val sex: Symbol)

  object Foo {
    def apply(name: String, age: Int, sex: Symbol) = new Foo(name, age, sex)
  }

  val fooList = Foo("Hugh Jass", 25, 'male) ::
    Foo("Biggus Dickus", 43, 'male) ::
    Foo("Incontinentia Buttocks", 37, 'female) ::
    Nil

  val stringList = fooList.foldLeft(List[String]()) { (z, f) =>
    val title = f.sex match {
      case 'male => "Mr."
      case 'female => "Ms."
    }
    z :+ s"$title ${f.name}, ${f.age}"
  }

  val mapped = fooList.map(x => {
    val prefix = x.sex match {
      case 'male => "Mr."
      case 'female => "Ms."
    }
    s"$prefix ${x.name}, ${x.age}"
  })

  val num = Seq(1,2,3,4,5,6)
  val sum = num.foldLeft(0)(_ + _)

  println(sum)
  println(stringList(0))
  println(mapped(0))
}
