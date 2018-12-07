package fr.mferreira.model

import org.scalatest._
import Matchers._

class DirectionTest extends FlatSpec{

  "Direction Left" should "direction when turn left" in {
    Direction.W.left should be(Direction.S)
    Direction.E.left should be(Direction.N)
    Direction.N.left should be(Direction.W)
    Direction.S.left should be(Direction.E)
  }

  "Direction Right" should "direction when turn right" in {
    Direction.W.right should be(Direction.N)
    Direction.E.right should be(Direction.S)
    Direction.N.right should be(Direction.E)
    Direction.S.right should be(Direction.W)
  }

}