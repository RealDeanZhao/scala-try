package ScalaByExample.Curry

object Curry extends App {
  def sumInts = sum(x => x)

  def sumSquares = sum(x => x * x)


  println(sumInts(1, 10))
  println(sum(x => x)(1, 10))

  println(sumSquares(1, 10))

  // f(args1)(args2)
  // is equivalent to
  // (f(args1))(args2)
  //
  // def f(args1)...(argsn) = E
  // is equivalent to
  // def f = (args1) => ... => (argsn) => E
  // T1 => T2 => T3
  // is equivalent to
  // T1 => (T2 => T3)
  def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0 else f(a) + sumF(a + 1, b)

    sumF
  }
}
