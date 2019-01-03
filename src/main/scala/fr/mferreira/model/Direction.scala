package fr.mferreira.model

import fr.mferreira.model.Command.{D, G}

sealed trait Direction

object Direction {

    case object W extends Direction
    case object E extends Direction
    case object N extends Direction
    case object S extends Direction

    def stringToDirection(string: String) : Direction = {
        string match {
            case "W" => W
            case "E" => E
            case "N" => N
            case "S" => S
        }
    }

    def returnNewDirection(command: Command, direction: Direction): Direction = {
        direction match {
            case W =>
                command match {
                    case G => S
                    case D => N
                }
            case E =>
                command match {
                    case G => N
                    case D => S
                }
            case N =>
                command match {
                    case G => W
                    case D => E
                }
            case S =>
                command match {
                    case G => E
                    case D => W
                }
        }
    }
}
