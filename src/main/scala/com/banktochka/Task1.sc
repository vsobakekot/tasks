implicit class StringCharExtension(xs: String) {
  def groupAndSortByChar: String =
    xs
      .groupBy(identity)
      .values
      .toList
      .sortWith(_.length > _.length)
      .mkString
}

val test = "asdasdaaaweqbbbbasdasd".groupAndSortByChar

assert(test == "aaaaaaassssddddbbbbewq")

val empty = "".groupAndSortByChar

assert(empty == "")
