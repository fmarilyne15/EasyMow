package fr.mferreira.model

sealed trait Command
  object Command {
    def toCommand(char: Char) : Option[Command] = {
      char match {
        case 'A' => Option(A)
        case 'D' => Option(D)
        case 'G' => Option(G)
        case _ => None
      }
    }
    case object A extends Command
    case object D extends Command
    case object G extends Command
  }

