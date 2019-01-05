package fr.mferreira.model

import org.scalatest._
import Matchers._
import fr.mferreira.model.Command.{A, D}

class LawnTest extends FlatSpec {

    "RectangularLawn negative " should "throw IllegalArgumentException" in {
        assertThrows[IllegalArgumentException]{
            RectangularLawn(-5, 5)
        }
    }

    "Negative position " should "is not inside" in {
        RectangularLawn(5, 5).inside(Position(-2, -5)) should be(false)
    }

    "Position at the edge " should "is inside" in {
        val lawn = RectangularLawn(5, 5)
        lawn.inside(Position(0, 0)) should be(true)
        lawn.inside(Position(5, 5)) should be(true)
    }

    "Position overflow " should "is not inside" in {
       RectangularLawn(5, 5).inside(Position(6, 4)) should be(false)
    }

    "Mower simulate " should "correctly when a mower move" in {
        val lawn = RectangularLawn(2, 2)
        val initialMower = Mower(Position(1, 1), Direction.S)
        val commands = List(A, A, D, A, D, A, D, A, D)

        val mowersWithCommands = List((initialMower, commands))

        lawn.simulate(mowersWithCommands) should contain only initialMower
    }
}
