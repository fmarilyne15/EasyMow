package fr.mferreira.model

sealed trait Command
  object Command {
    case object A extends Command
    case object D extends Command
    case object G extends Command
  }

