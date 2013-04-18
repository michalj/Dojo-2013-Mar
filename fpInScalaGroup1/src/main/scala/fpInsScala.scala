
import scala.annotation.tailrec

object chapter3 extends App {

  // Exercise 2
  def tail[T](l : List[T]) = l match {
    case Nil => Nil
    case _ :: tail => tail
  }

  // Exercise 3
  def drop[T](l: List[T], n: Int): List[T] = 
    (n, l) match {
      case (_, Nil) => Nil
      case (1, l) => tail(l)
      case (n, l) => drop(tail(l), n-1) 
    }

  // Exercise 4
  def dropWhile[T](l : List[T])(pred : T => Boolean) : List[T] = {
    l match {
      case Nil => Nil
      case x::xs => if(pred(x)) dropWhile(xs)(pred) else l
    }
  }
  
  // Exercise 5
  def setHead[T](l: List[T], newHead: T) = {
    newHead :: tail(l)
  }
  
  // Exercise 6  
  def init[A](l: List[A]) : List[A] = l match {
      case Nil => Nil
      case _ :: Nil => Nil
      case x :: xs => x::init(xs)
  }                                               //> init: [A](l: List[A])List[A]

  // Exercise 10
  def length[A](l: List[A]): Int = l.foldRight(0)((_, c) => c + 1)

  val dropWhileForThisList = dropWhile( List(33345,4,5,3)) _

  println(dropWhileForThisList( _  > 4))

  println(tail(List(1,2, 3)))
  println(tail(List()))

  println(drop(List(), 2))
  println(drop(List(1,2, 3), 2))
  println(drop(List(1,2, 3), 4))


  println(dropWhile(List(1,2,3,4,5)) ((x: Int) => x < 3))

  def lessThanThree(n : Int) = n < 3
  
  // Exercise 11
  @tailrec
  def foldLeft[A,B] (l: List[A], z: B)(f: (B,A) => B): B = {
    l match {
      case Nil => z
      case x :: xs => foldLeft( xs, f(z, x))(f)
    }
  }
  
  // Exercise 13
  def reverse[T](l: List[T]): List[T] = {
    foldLeft(l, Nil : List[T])( (acc, x) => x :: acc)
  }
  
  // Exercise 14
  def foldLeft2[A,B](l: List[A], z:B)(f: (B,A) =>B): B = {
    def ident(x: B): B = x
    val g = l.foldRight(ident _)((e, a) => x => a(f(x, e)))
    g(z)
  }
  
        

}
