package fr.mferreira.model

import fr.mferreira.parser.Parser.MowersWithCommands

trait Lawn {

    def inside(p: Position): Boolean

    def simulateOneMower(mower: Mower, commands: List[Command]): Mower = {
        commands match {
            case h :: d =>
                val newMower = mower.execute(h)
                if(inside(newMower.position)) simulateOneMower(newMower, d)
                else simulateOneMower(mower, d)
            case Nil => mower
        }
    }

    def simulate(mowersWithCommands : List[MowersWithCommands]): List[Mower]= {
        mowersWithCommands.map(x => simulateOneMower(x._1, x._2))
    }

}

case class RectangularLawn(x: Int, y: Int) extends Lawn {

    require(x > 0 && y > 0, "Lawn must be positive.")

    override def inside(position: Position): Boolean ={
        position.x >= 0 &&
            position.y >= 0 &&
            position.x <= x &&
            position.y <= y
    }

}