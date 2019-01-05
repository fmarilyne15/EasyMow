package fr.mferreira.model

import fr.mferreira.model.Direction.{E, N, S, W}
import fr.mferreira.model.Command.{A, D, G}

case class Mower(position: Position, direction: Direction) {

    def execute(command: Command) : Mower ={
        command match {
            case A => this.move()
            case G =>  this.copy(direction = Direction.returnNewDirection(G, direction))
            case D =>  this.copy(direction = Direction.returnNewDirection(D, direction))
        }
    }

    def move() : Mower ={
        direction match {
            case W => Mower(position.changePosition(-1, 0), direction)
            case E => Mower(position.changePosition(1, 0), direction)
            case N => Mower(position.changePosition(0, 1), direction)
            case S => Mower(position.changePosition(0, -1), direction)

        }
    }

}
