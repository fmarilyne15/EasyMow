package fr.mferreira.model

object Print {

  trait Show[A] {
    def show(a: A): String
  }

  implicit val mowerShow: Show[Mower] = new Show[Mower] {
      override def show(mower: Mower): String = mower.position + " " + mower.direction
    }

  implicit val positionSow: Show[Mower] = new Show[Mower] {
    override def show(mower: Mower): String = mower.position + " " + mower.direction
  }

  def print[T](t: T)(implicit ev: Show[T]) = ev.show(t)
}