import scala.io.Source

class File(val name: String) {
  require(name != null && !name.isEmpty)
  var lines: List[String] = Source.fromResource(name).getLines.toList
}