package fr.mferreira


import fr.mferreira.model.{Mower, Print, RectangularLawn}
import fr.mferreira.parser.Parser

import scala.util.{Failure, Success}


object Main extends App{
  Parser.getLinesFromFile("\\test1.txt") match {
    case Success(lines) => {
      Parser.lineToLawn(lines(0)) match {
        case Success(lawn) =>
          lines match {
            case h :: d => recLine(lawn, d)
          }
      }
    }
    case Failure(f) => println(f)
  }

  def recLine(lawn: RectangularLawn, lines: List[String]): Unit = {
    lines match {
      case m :: c :: d =>
        println(Print.print(oneMower(lawn, m, c)))
        recLine(lawn, d)
      case Nil => ()
    }
  }
  def oneMower(lawn: RectangularLawn, mower: String, command: String): Mower = {
    Parser.lineToMower(mower) match {
      case Success(mower) => lawn.simulate(mower, Parser.lineToCommand(command))
    }
  }

}