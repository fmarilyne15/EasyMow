package fr.mferreira.model

import fr.mferreira.model.Direction.{N, W}
import fr.mferreira.model.Command.{A, D, G}

case class Mower(position: Position, direction: Direction) {

  //retourne un mower avec la nouvelle direction
  def execute(command: Command) : Mower ={
    command match {
      //case A => this.move()
      case G =>  this.copy(direction = direction.left)
      case D =>  this.copy(direction = direction.right)
    }
  }


  def move() : Mower ={
    direction match {
      case N => position.move(position, 0, 1) //pb comment acceder a la fonction move de position
    }
  }

}
