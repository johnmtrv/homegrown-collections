import homegrown.collections._

import org.scalatest._

class TestSuite extends FunSuite with Matchers {
  test("apply on empty set should yield false") {
    Set.empty(randomElement) shouldBe false
  }

  // private methode
  private def randomElement: String =
    scala.util.Random.alphanumeric.take(5).mkString
}
