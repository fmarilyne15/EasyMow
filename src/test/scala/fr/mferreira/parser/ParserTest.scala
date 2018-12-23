package fr.mferreira.parser
import org.scalatest._
import Matchers._
import fr.mferreira.model.{Direction, Mower, Position}

import scala.util.{Failure, Success}

class ParserTest extends FlatSpec {

  val parser = new Parser()
  "fileGetPosition" should "5 5 N" in{
    parser.getLinesFromFile("\\test1.txt") match {
      case Success(lines) => lines should equal (List("5 5 N"))
    }
  }

  "new mower " should "correctly when parse a new mower" in {
    parser.lineToMower("5 5 N") should be (Mower(Position(5, 5), Direction.N))
  }
}
