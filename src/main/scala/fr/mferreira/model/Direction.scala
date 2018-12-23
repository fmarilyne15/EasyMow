package fr.mferreira.model

import fr.mferreira.model.Direction._

sealed trait Direction{
  def left : Direction
  def right : Direction
  def toString: String

}
object Direction {

  def toDirection(string: String) : Direction = {
    string match {
      case "W" => W
      case "E" => E
      case "N" => N
      case "S" => S
    }
  }
  case object W extends Direction {
    override def left: Direction = S
    override def right: Direction = N

    override def toString: String = "W"
  }

  case object E extends Direction {
    override def left: Direction = N
    override def right: Direction = S
  }

  case object N extends Direction {
    override def left: Direction = W
    override def right: Direction = E
  }

  case object S extends Direction {
    override def left: Direction = E
    override def right: Direction = W
  }

}
