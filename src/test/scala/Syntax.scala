package syntax

import chisel3._
import chisel3.util._
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}

class NullUnitTester(mm: Null) extends PeekPokeTester(mm) {

  poke(mm.io.a, 2)
  poke(mm.io.b, 1)
  step(1)
  expect(mm.io.c, 3)

  poke(mm.io.a, 2)
  poke(mm.io.b, 2)
  step(1)
  expect(mm.io.c, 0)
}

class NullTester extends ChiselFlatSpec {
  println ("hello world")

  println(System.getProperty("java.version"))
  println(System.getProperty("java.runtime.version"))

  import scala.collection.JavaConversions._
  val properties = System.getProperties()
  for ((k,v) <- properties) println(s"key: $k, value: $v")

  "Basic test using Driver.execute" should "be used as an alternative way to run specification" in {
    iotesters.Driver.execute(Array(), () => new Null) {
      c => new NullUnitTester(c)
    } should be (true)
  }
//  assert(0)
//  assert(false)
}
