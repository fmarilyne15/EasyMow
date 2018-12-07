package fr.mferreira.model

final case class Position(x: Int, y: Int)

object Position {

  def move(p: Position, deltaX: Int, deltaY: Int): Position = p.copy(x = p.x + deltaX, y = p.y + deltaY)


}