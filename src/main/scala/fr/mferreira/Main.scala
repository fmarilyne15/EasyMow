package fr.mferreira
import fr.mferreira.file.File
import fr.mferreira.model.Position

import scala.util.{Failure, Success, Try}

object Main extends App{
  val file = new File()
  file.getLinesFromFile("\\test1.txt") match {
    case Success(lines) => lines.foreach(println)
    case Failure(f) => println(f)
  }

}