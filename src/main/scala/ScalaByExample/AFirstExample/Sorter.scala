/** *
  * Chapter 2
  * A first exmaple
  */
object Sorter {
  // Array[String] like ArrayList<String> in java
  def main(args: Array[String]): Unit = {
    // val means value, read only variables
    val arrays = Array(2122, 421, 12, 3342, 12, 52, 3412, 3)
    sort(arrays)
    // <- 1 to n
    println("arrays sort result")
    for (i <- 1 to arrays.length)
    //array(i) instead of array[i]
      println(arrays(i - 1))

    var arrays2 = Array(123, 5, 1, 234, 2, 3, 0, 23, 12, 7, 23, 223, 4)
    arrays2 = fpSort(arrays2)
    println("array2 sort result")
    for (i <- 1 to arrays2.length)
      println(arrays2(i - 1))
  }

  // normal one
  def sort(arrays: Array[Int]) = {
    def swap(i: Int, j: Int) = {
      val t = arrays(i)
      arrays(i) = arrays(j)
      arrays(j) = t

      // If no explicit return expression is given, the value () is assumed
      // () is "unit"
      ()
    }

    // nested functions
    // Unit like void in Java
    def innerSort(l: Int, r: Int): Unit = {
      val pivot = arrays((l + r) / 2)
      // var means variables
      var i = l
      var j = r
      while (i <= j) {
        while (arrays(i) < pivot) i += 1
        while (arrays(j) > pivot) j -= 1
        if (i <= j) {
          swap(i, j)
          i += 1
          j -= 1
        }
      }
      if (l < j) innerSort(l, j)
      if (j < r) innerSort(i, r)
    }

    innerSort(0, arrays.length - 1)
  }

  // functional programming one
  def fpSort(arrays: Array[Int]): Array[Int] = {
    if (arrays.length <= 1) arrays
    else {
      val pivot = arrays(arrays.length / 2)
      // arrays filter (pivot >)
      // eqauls
      // arrays.filter(pivot >)
      // equals
      // arrays filter (x => pivot > x)
      Array.concat(
        fpSort(arrays filter (pivot >)),
        arrays filter (pivot ==),
        fpSort(arrays filter (pivot <))
      )
    }
  }
}

