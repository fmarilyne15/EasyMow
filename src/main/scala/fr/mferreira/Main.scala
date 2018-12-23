package fr.mferreira


import fr.mferreira.parser.Parser

import scala.util.{Failure, Success, Try}

object Main extends App{
  val parser = new Parser()
  parser.getLinesFromFile("\\test1.txt") match {
    case Success(lines) => lines.foreach(println)
    case Failure(f) => println(f)
  }


}