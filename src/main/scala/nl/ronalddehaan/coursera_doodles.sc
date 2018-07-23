
val foo = List(1,2,3,4,5,6,7,8,9,0)

def removeAt(n: Int, xs: List[Int]) =
  xs.take(n) ::: xs.drop(n + 1)


foo.take(3)
foo.drop(3 + 1)
removeAt(1, foo)


def msort(xs: List[Int]): List[Int] = {
  val n = xs.length / 2
  if (n == 0) xs
  else {
    def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
      case (xs, Nil) => xs
      case (Nil, ys) => ys
      case (x :: xs1, y :: ys1) =>
        if (x < y) x :: merge(xs1, ys)
        else y :: merge(xs, ys1)
    }
    val (fst, snd) = xs.splitAt(n)
    merge(msort(fst), msort(snd))
  }
}

val ulist = List(-4,3,1,77,35,2,1,-565)
msort(ulist)


//def squareList(xs: List[Int]): List[Int] = {
//  xs match {
//    case Nil => xs
//    case y :: ys => squareList(ys) :: List[Int(y * 2)
//  }
//}
//squareList(List(1,2,3,4))

def isPrime(n: Int) = (2 until n) forall(p => n % p != 0)
isPrime(5)

val s = "Ronald de Haan"

s.groupBy(e => e.toLower).map(m => (m._1, m._2.length)).toList.sorted

type Apple = String
type Pear = String

def eatApple(a: Apple) = println("yummie")
val apple: Pear = "Golden delicious"
eatApple(apple)
