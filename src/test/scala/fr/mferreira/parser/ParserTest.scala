package fr.mferreira.parser
import org.scalatest._
import Matchers._
import fr.mferreira.model.{Command, Direction, Mower, Position}

import scala.util.{Failure, Success}

class ParserTest extends FlatSpec {

  "fileGetPosition" should "5 5 N" in{
    Parser.getLinesFromFile("\\test1.txt") match {
      case Success(lines) => lines should equal (List("5 5 N"))
    }
  }

  "new mower " should "correctly when parse a new mower" in {
    Parser.lineToMower("5 5 N") should be (Mower(Position(5, 5), Direction.N))
  }

  "new line command " should "return a list of command" in {
    Parser.lineToCommand("ADAG") should be (List(Command.A, Command.D, Command.A, Command.G))
  }

  "new line command with some space " should "return a list of command" in {
    Parser.lineToCommand("A D AG") should be (List(Command.A, Command.D, Command.A, Command.G))
  }
}
