package fr.mferreira.model

sealed trait Command

object Command {

    case object A extends Command
    case object D extends Command
    case object G extends Command

    def toCommand(char: Char) : Option[Command] = {
        char match {
            case 'A' => Option(A)
            case 'D' => Option(D)
            case 'G' => Option(G)
            case _ => None
        }
    }
}

