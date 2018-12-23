package fr.mferreira.parser
import scala.io.Source
import scala.util.Try

class Parser{

  def getLinesFromFile(name: String) : Try[List[String]] ={
    Try(Source.fromResource(name).getLines.toList)
  }

}