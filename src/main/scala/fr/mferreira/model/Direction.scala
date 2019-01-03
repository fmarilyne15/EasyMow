package fr.mferreira.model

import fr.mferreira.model.Command.{A, D, G}

sealed trait Direction

object Direction {

    case object W extends Direction
    case object E extends Direction
    case object N extends Direction
    case object S extends Direction

    def stringToDirection(string: String) : Option[Direction] = {
        string match {
            case "W" => Option(W)
            case "E" => Option(E)
            case "N" => Option(N)
            case "S" => Option(S)
            case _ => None
        }
    }

    def returnNewDirection(command: Command, direction: Direction): Direction = {
        direction match {
            case W =>
                command match {
                    case G => S
                    case D => N
                    case A => direction
                }
            case E =>
                command match {
                    case G => N
                    case D => S
                    case A => direction
                }
            case N =>
                command match {
                    case G => W
                    case D => E
                    case A => direction
                }
            case S =>
                command match {
                    case G => E
                    case D => W
                    case A => direction
                }
        }
    }
}
