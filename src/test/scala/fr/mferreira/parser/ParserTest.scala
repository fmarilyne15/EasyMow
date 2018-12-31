package fr.mferreira.parser
import org.scalatest._
import Matchers._
import fr.mferreira.model._

import scala.util.{Failure, Success}

class ParserTest extends FlatSpec {

    "new lawn " should "correctly when parse a new lawn" in {
        Parser.lineToLawn("3 3")  should be (Success(RectangularLawn(3, 3)))
    }

    "new negative lawn " should "throw IllegalArgumentException" in {
        Parser.lineToLawn("-3 3") should be (Failure(new IllegalArgumentException("lawn must be positive.")))
    }

    "new mower " should "correctly when parse a new mower" in {
        Parser.lineToMower("5 5 N") should be (Success(Mower(Position(5, 5), Direction.N)))
    }

    "new line command " should "return a list of command" in {
        Parser.lineToCommand("ADAG") should be (List(Command.A, Command.D, Command.A, Command.G))
    }

    "new line command with some space " should "return a list of command" in {
        Parser.lineToCommand("A D AG") should be (List(Command.A, Command.D, Command.A, Command.G))
    }
}
