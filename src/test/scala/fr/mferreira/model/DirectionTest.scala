package fr.mferreira.model

import org.scalatest._
import Matchers._

class DirectionTest extends FlatSpec{

    "Direction Left" should "direction when turn left" in {
        Direction.returnNewDirection(Command.G, Direction.W) should be(Direction.S)
        Direction.returnNewDirection(Command.G, Direction.E) should be(Direction.N)
        Direction.returnNewDirection(Command.G, Direction.N) should be(Direction.W)
        Direction.returnNewDirection(Command.G, Direction.S) should be(Direction.E)
    }

    "Direction Right" should "direction when turn right" in {
        Direction.returnNewDirection(Command.D, Direction.W) should be(Direction.N)
        Direction.returnNewDirection(Command.D, Direction.E) should be(Direction.S)
        Direction.returnNewDirection(Command.D, Direction.N) should be(Direction.E)
        Direction.returnNewDirection(Command.D, Direction.S) should be(Direction.W)
    }

    "String to direction " should "return the direction coresponding of string" in {
        Direction.stringToDirection("S") should be(Direction.W)
        Direction.stringToDirection("E") should be(Direction.E)
        Direction.stringToDirection("N") should be(Direction.N)
        Direction.stringToDirection("S") should be(Direction.S)
    }

}