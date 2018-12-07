package fr.mferreira.file
import scala.io.Source
import scala.util.Try

class File{

  def getLinesFromFile(name: String) : Try[List[String]] ={
    Try(Source.fromResource(name).getLines.toList)
  }

}