package syntax

import chisel3._
import chisel3.util._

class Null extends Module {
  val io = IO ( new Bundle {
    val a = Input(UInt(16.W))
    val b = Input(UInt(16.W))
    val c = Output(UInt(16.W))
  })

  val d = Wire(UInt(16.W))
  d := io.a + io.b
  val e = io.a - io.b
  val cc = RegNext(d * e)
  io.c := cc
  printf(p"io.c = ${io.c}\n")
}
