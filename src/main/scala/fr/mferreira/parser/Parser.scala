package fr.mferreira.parser
import fr.mferreira.model._

import scala.io.Source
import scala.util.Try

object Parser{

  def getLinesFromFile(name: String) : Try[List[String]] ={
    Try(Source.fromResource(name).getLines.toList)
  }

  def lineToMower(line: String): Try[Mower] = {
    Try{
      val array = line.split(" ")
      val x = array(0).toInt
      val y = array(1).toInt

      Mower(Position(x, y), Direction.toDirection(array(2)))
  }
  }

  def lineToLawn(line: String): Try[RectangularLawn] = {
    Try{
      val array = line.split(" ")
      val x = array(0).toInt
      val y = array(1).toInt
      RectangularLawn(x, y)
    }
  }

  def lineToCommand(line: String): List[Command] = {
    line.flatMap(x => Command.toCommand(x)).toList
  }

}