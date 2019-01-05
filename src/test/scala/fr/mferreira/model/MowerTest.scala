package fr.mferreira.model

import org.scalatest._
import Matchers._

class MowerTest extends FlatSpec{

    "Advance west " should "correctly when mowee advance to the west" in {
        Mower(Position(0, 0), Direction.W).execute(Command.A) should be (Mower(Position(-1, 0), Direction.W))
    }

    "Advance east " should "correctly when mowee advance to the east" in {
        Mower(Position(0, 0), Direction.E).execute(Command.A) should be (Mower(Position(1, 0), Direction.E))
    }

    "Advance north " should "correctly when mowee advance to the north" in {
        Mower(Position(0, 0), Direction.N).execute(Command.A) should be (Mower(Position(0, 1), Direction.N))
    }

    "Advance south " should "correctly when mowee advance to the south" in {
        Mower(Position(0, 0), Direction.S).execute(Command.A) should be (Mower(Position(0, -1), Direction.S))
    }



}
