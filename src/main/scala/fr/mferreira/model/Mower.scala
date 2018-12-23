package fr.mferreira.model

import fr.mferreira.model.Direction.{E, N, S, W}
import fr.mferreira.model.Command.{A, D, G}

case class Mower(position: Position, direction: Direction) {

  /* execute command
    return a new mower
   */
  def execute(command: Command) : Mower ={
    command match {
      case A => this.move()
      case G =>  this.copy(direction = direction.left)
      case D =>  this.copy(direction = direction.right)
    }
  }

  /* change position
    return a new mower
   */
  def move() : Mower ={
    direction match {
      case W => new Mower(position.changePosition(-1, 0),  direction)
      case E => new Mower(position.changePosition(1, 0),  direction)
      case N => new Mower(position.changePosition(0, 1),  direction)
      case S => new Mower(position.changePosition(0, -1),  direction)

    }
  }

}
