package fr.mferreira.model

final case class Position(x: Int, y: Int){

  def changePosition(deltaX: Int, deltaY: Int): Position = copy(x = x + deltaX, y = y + deltaY)

}
