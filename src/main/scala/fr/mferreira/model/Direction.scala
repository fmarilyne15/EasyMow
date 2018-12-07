package fr.mferreira.model

sealed trait Direction{
  def left : Direction
  def right : Direction
}
object Direction {
  case object W extends Direction {
    override def left: Direction = S
    override def right: Direction = N
  }

  case object E extends Direction {
    override def left: Direction = N
    override def right: Direction = S
  }

  case object N extends Direction {
    override def left: Direction = W
    override def right: Direction = E
  }

  case object S extends Direction {
    override def left: Direction = E
    override def right: Direction = W
  }

}
