package fr.mferreira.model
trait Lawn {

  def inside(p: Position): Boolean

  def simulate(mower: Mower, commands: List[Command]): Mower = {
    commands match {
      case h :: d =>
        val newMower = mower.execute(h)
        if(inside(newMower.position)) simulate(newMower, d)
      else simulate(mower, d)
      case Nil => mower
    }
  }

}

case class RectangularLawn(x: Int, y: Int) extends Lawn {

  override def inside(position: Position): Boolean ={
    position.x >= 0 &&
      position.y >= 0 &&
      position.x <= x &&
      position.y <= y

  }

}