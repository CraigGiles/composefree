package composefree.example

import composefree.ComposeFree
import composefree.example.console._
import composefree.example.dsl._
import composefree.example.numbers._
import composefree.puredsl._
import scalaz.Id.Id

object Example {
  import examplecompose._

  val prog = for {
    init <- pure(2)
    _ <- set(init)
    a <- add(3)
    b <- minus(2)
    _ <- print(b.toString)
    c <- add(10)
    r <- get()
  } yield a + b + c + r

  def main(args: Array[String]): Unit = {
    println(prog.runWith(interp))
  }
}