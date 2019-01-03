package fr.mferreira.model

import fr.mferreira.model.Direction.{E, N, S, W}

object Print {

    trait Show[A] {
        def show(a: A): String
    }

    implicit val mowerShow: Show[Mower] = new Show[Mower] {
        override def show(mower: Mower): String = Print.print(mower.position) + " " + Print.print(mower.direction)
    }

    implicit val positionSow: Show[Position] = new Show[Position] {
        override def show(position: Position): String = position.x + " " + position.y
    }

    implicit val directionShow: Show[Direction] = new Show[Direction]{
        override def show(direction: Direction) : String =
            direction match {
                case W => "W"
                case E => "E"
                case N => "N"
                case S => "S"
            }
    }

    def print[T](t: T)(implicit ev: Show[T]):String = ev.show(t)
}