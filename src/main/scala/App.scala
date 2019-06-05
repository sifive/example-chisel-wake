
import scala.math.pow

object MainApp extends App
{
  println("Hello World!")
  val a = List("a", "b", "c")

  val b = for (i <- a) yield {
    println(i)
    i
  }
  println(b)


  a.zipWithIndex.reverse.map {
    case (x, i) => println(x, pow(2,i).intValue)
  }


    val name="HelloName"
    val numb=10
    println(f"$name%20s, $numb%2.5f")

}
