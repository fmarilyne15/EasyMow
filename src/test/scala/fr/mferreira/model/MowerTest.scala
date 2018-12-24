package fr.mferreira.model

import org.scalatest._
import Matchers._

class MowerTest extends FlatSpec{

  "Advence west " should "x+1" in {
    Mower(Position(0, 0), Direction.W).execute(Command.A) should be (Mower(Position(-1, 0), Direction.W))
  }


  "Advence east " should "y+1" in {
    Mower(Position(0, 0), Direction.E).execute(Command.A) should be (Mower(Position(1, 0), Direction.E))
  }

  "Advence north " should "y+1" in {
    Mower(Position(0, 0), Direction.N).execute(Command.A) should be (Mower(Position(0, 1), Direction.N))
  }

  "Advence south " should "y-1" in {
    Mower(Position(0, 0), Direction.S).execute(Command.A) should be (Mower(Position(0, -1), Direction.S))
  }

  "toString mower " should "correctly when toString is use" in {
    "5 4 S" should be (Mower(Position(5, 4), Direction.S).toString)
  }
}
