import org.scalatest._
import Matchers._

class FileTest extends FlatSpec {

  "fileGetPosition" should "5 5 N" in{
    val file = new File("test1.txt")
    file.lines should equal (List("5 5 N"))
  }
}
