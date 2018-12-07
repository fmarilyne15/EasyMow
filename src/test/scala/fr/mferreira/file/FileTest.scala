package fr.mferreira.file
import org.scalatest._
import Matchers._

import scala.util.{Failure, Success}

class FileTest extends FlatSpec {

  "fileGetPosition" should "5 5 N" in{
    val file = new File()
    file.getLinesFromFile("\\test1.txt") match {
      case Success(lines) => lines should equal (List("5 5 N"))
    }
  }
}
