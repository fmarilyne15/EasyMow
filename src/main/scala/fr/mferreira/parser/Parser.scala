package fr.mferreira.parser
import fr.mferreira.model._
import scala.io.Source
import scala.util.Try
import scala.util.{Failure, Success}

object Parser{

    type MowersWithCommands = (Mower, List[Command])

    def getLinesFromFile(name: String) : Try[List[String]] ={
        Try(Source.fromResource(name).getLines.toList)
    }

    def lineToLawn(line: String): Try[RectangularLawn] = {
        Try{
            val array = line.split(" ")
            val x = array(0).toInt
            val y = array(1).toInt
            RectangularLawn(x, y)
        }
    }

    def parseMowersWithCommands(lines: List[String]): Either[List[MowersWithCommands], String] = {
        lines match {
            case m :: c :: res =>
                parseMowersWithCommands(res) match {
                    case Left(p)  => lineToMower(m) match {
                        case Success(mower) => Left(List((mower, lineToCommand(c)))++ p)
                        case Failure(_) => if(p.isEmpty) Left(p) else Right("Failed parse first mower")
                    }
                    case Right(s) => Right(s)
                }
            case _ =>
                Left(Nil)
        }
    }

    def lineToMower(line: String): Try[Mower] = {
        Try{
            val array = line.split(" ")
            val x = array(0).toInt
            val y = array(1).toInt
            if(x < 1 || y < 1)
                throw new IllegalArgumentException("Position must be positive.")
            val direction = Direction.stringToDirection(array(2))
            direction match {
                case Some(value) => Mower(Position(x, y), value)
                case None => throw new IllegalArgumentException("Direction must be A, G or D.")
            }
        }
    }

    def lineToCommand(line: String): List[Command] = {
        line.flatMap(x => Command.toCommand(x)).toList
    }

}