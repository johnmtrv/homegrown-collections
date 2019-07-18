package homegrown.collections

trait Set extends (String => Boolean) {
  def add(input: String): Set
  def remove(input: String): Set
  def union(that: Set): Set
  def intersection(that: Set): Set
  def difference(that: Set): Set
  def isSubsetOf(that: Set): Boolean
  def isSuperSet(that: Set): Boolean

}
object Set {

  private final case class NonEmpty(element: String, otherElements: Set) extends Set {
    final override def apply(input: String): Boolean =
      input == element || otherElements(input)

    final override def add(input: String): Set = // todo
      if (input == element)
        this
      else
        NonEmpty(input, otherElements.add(element))

    final override def remove(input: String): Set =
      if (input == element)
        otherElements //todo
      else
        NonEmpty(element, otherElements.remove(input))

    final override def union(that: Set): Set = {
      println(this.element)
      otherElements.union(that.add(element))

    }
    final override def intersection(that: Set): Set = {
      if (that(element))
        otherElements.intersection(that).add(element)
      else
        otherElements.intersection(that)

    }

    final override def difference(that: Set): Set = {
      if (that(element))
        otherElements.difference(that)
      else
        otherElements.difference(that).add(element)
    }

    final override def isSubsetOf(that: Set): Boolean =
      that(element) && otherElements.isSubsetOf(that)
    //      if (that(element))
    //        otherElements.isSubsetOf(that)
    //      else
    //        false

    final override def isSuperSet(that: Set): Boolean =
      that.isSubsetOf(this)

    final override def equals(other: Any): Boolean = other match {
      case that: Set => that.isSubsetOf(this) && this.isSubsetOf(that)
      case _         => false
    }

  }

  private object Empty extends Set {
    def apply(input: String): Boolean =
      false

    final override def add(input: String): Set =
      NonEmpty(input, Empty)

    final override def remove(input: String): Set = this

    final override def union(that: Set): Set = that

    final override def intersection(that: Set): Set = this

    final override def difference(that: Set): Set = this

    final override def isSubsetOf(that: Set): Boolean = true

    final override def isSuperSet(that: Set): Boolean = true

  }

  val empty: Set = Empty

  //val empty: Set = input => false
  //   the line precedent is compile like this because it's a finction Set extends (String => Boolean)
  //   val empty: Set = new Set {
  //     override final def apply(input: String) = false
  //   }

}
