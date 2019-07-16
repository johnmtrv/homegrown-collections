import homegrown.collections._

import org.scalatest._

class TestSuite extends FunSuite with Matchers {
  test("1. apply on empty set should yield false") {
    Set.empty(randomElement) shouldBe false
  }

  test("2. add on an empty set should yield a new Set with a new element") {

    val first = randomElement
    val second = randomElement

    first should not be second

    val set = Set.empty.add(first)
    set(first) shouldBe true
    set(second) shouldBe false

  }
  test("3. add on a non empty set should yield a new Set with two elements") {

    val first = randomElement
    val second = randomElement

    first should not be second

    val set = Set.empty.add(first).add(second)

    set(first) shouldBe true
    set(second) shouldBe true

  }

  test("4. remove on a non empty set should yield a new Set without the element") {
    val element = randomElement

    val setWithElement = Set.empty.add(element)

    setWithElement(element) shouldBe true

    val setWithoutElement = setWithElement.remove(element)

    setWithElement(element) shouldBe true
    setWithoutElement(element) shouldBe false

  }

  test("5. remove removes only the element in question") {
    val first = randomElement
    val second = randomElement

    first should not be second

    val setWithElement = Set.empty.add(first).add(second)

    setWithElement(first) shouldBe true
    setWithElement(second) shouldBe true

    val setWithoutElement = setWithElement.remove(first)

    setWithoutElement(first) shouldBe false
    setWithoutElement(second) shouldBe true
  }

  test("6. remove removes only the element in question v2") {
    val first = randomElement
    val second = randomElement

    first should not be second

    val setWithElement = Set.empty.add(first).add(second)

    setWithElement(first) shouldBe true
    setWithElement(second) shouldBe true

    val setWithoutElement = setWithElement.remove(second)

    setWithoutElement(first) shouldBe true
    setWithoutElement(second) shouldBe false
  }

  test("7. union an empty set should yield an empty set ") {
    Set.empty.union(Set.empty)(randomElement) shouldBe false
  }
  test("8. union on a non empty Set with an empty set should yield the original Set untouched") {
    val first = randomString
    val second = randomString

    first should not be second

    val emptySet = Set.empty
    val nonEmptySet = emptySet.add(first).add(second)
    emptySet.union(nonEmptySet)(first) shouldBe true
    emptySet.union(nonEmptySet)(second) shouldBe true

    nonEmptySet.union(emptySet)(first) shouldBe true
    nonEmptySet.union(emptySet)(second) shouldBe true

  }

  test("9. union on two non empty Sets should yield their union") {

    val a = randomElement
    val b = randomElement
    val c = randomElement
    val d = randomElement

    val left = Set.empty.add(a).add(b)
    val right = Set.empty.add(c).add(d)
    val union = left.union(right)

    union(a) shouldBe true
    union(b) shouldBe true
    union(c) shouldBe true
    union(d) shouldBe true
  }

  test("10. intersection on empty Set should yield an empty Set") {
    Set.empty.intersection(Set.empty)(randomElement) shouldBe false
  }

  test("11. intersection on a non empty Set with an empty Set should yield an empty Set") {
    val first = randomString
    val second = randomString

    first should not be second

    val emptySet = Set.empty
    val nonEmptySet = emptySet.add(first).add(second)
    emptySet.intersection(nonEmptySet)(first) shouldBe false
    emptySet.intersection(nonEmptySet)(second) shouldBe false

    nonEmptySet.intersection(emptySet)(first) shouldBe false
    nonEmptySet.intersection(emptySet)(second) shouldBe false

  }

  test("12. intersection on two non empty Sets should yield their intersection") {
    val a = randomElement
    val b = randomElement
    val c = randomElement
    val d = randomElement

    val left = Set.empty.add(a).add(b).add(c)
    val right = Set.empty.add(c).add(d).add(b)
    val intersection = left.intersection(right)

    intersection(a) shouldBe false
    intersection(b) shouldBe true
    intersection(c) shouldBe true
    intersection(d) shouldBe false
  }

  test("13. difference on empty Set should yield an empty Set") {
    Set.empty.difference(Set.empty)(randomElement) shouldBe false
  }

  test("14. difference on a non empty Set with an empty Set should yield an empty Set") {
    val first = randomString
    val second = randomString

    first should not be second

    val emptySet = Set.empty
    val nonEmptySet = emptySet.add(first).add(second)

    emptySet.difference(nonEmptySet)(first) shouldBe false
    emptySet.difference(nonEmptySet)(second) shouldBe false

    nonEmptySet.difference(emptySet)(first) shouldBe true
    nonEmptySet.difference(emptySet)(second) shouldBe true
  }

  test("15. difference on two non empty Sets should yield their difference") {
    val a = randomElement
    val b = randomElement
    val c = randomElement
    val d = randomElement

    val left = Set.empty.add(a).add(b).add(c)
    val right = Set.empty.add(c).add(d).add(b)
    val leftDifference = left.difference(right)

    leftDifference(a) shouldBe true
    leftDifference(b) shouldBe false
    leftDifference(c) shouldBe false
    leftDifference(d) shouldBe false

    val rightDifference = right.difference(left)

    rightDifference(a) shouldBe false
    rightDifference(b) shouldBe false
    rightDifference(c) shouldBe false
    rightDifference(d) shouldBe true
  }

  test("16 isSubsetOf on an empty Set should yield true") {
    Set.empty.isSubsetOf(Set.empty) shouldBe true
    Set.empty.isSubsetOf(Set.empty.add(randomString)) shouldBe true
  }
  // private methode
  private def randomElement: String =
    scala.util.Random.alphanumeric.take(5).mkString

  private def randomString: String =
    scala.util.Random.alphanumeric.take(5).mkString
}
