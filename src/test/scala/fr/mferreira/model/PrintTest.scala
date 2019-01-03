package fr.mferreira.model

import org.scalatest.Matchers._
import org.scalatest._

class PrintTest extends FlatSpec {

    "Show mower " should "correctly when we call a typeclass print" in {
        "5 4 S" should be (Print.print(Mower(Position(5, 4), Direction.S)))
    }

    "Show position " should "correctly when we call a typeclass print" in {
        "1 3" should be (Print.print(Position(1, 3)))
    }

}
