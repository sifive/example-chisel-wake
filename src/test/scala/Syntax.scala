package syntax

import chisel3._
import chisel3.util._
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}

class NullUnitTester(mm: Null) extends PeekPokeTester(mm) {

  poke(mm.a, 2)
  poke(mm.b, 1)
  step(1)
  printf(p"result: ${mm.c}\n")
  expect(mm.c, 3)

  poke(mm.a, 2)
  poke(mm.b, 2)
  step(1)
  printf(p"result: ${mm.c}\n")
  expect(mm.c, 0)
}

class NullTester extends ChiselFlatSpec {
  "Basic test using Driver.execute" should "be used as an alternative way to run specification" in {
    iotesters.Driver.execute(Array(), () => new Null) {
      c => new NullUnitTester(c)
    } should be (true)
  }
//  assert(0)
//  assert(false)
}
