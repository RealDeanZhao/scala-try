package ScalaByExample.FindingFiexedPointsOfFunctions

import scala.math.abs

object FindingFixedPointsOfFunctions extends App {
  val tolerance = 0.0001

  def isCloseEnough(x: Double, y: Double) = abs((x - y) / x) < tolerance

  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double = {
      val next = f(guess)
      println(next)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }

    iterate(firstGuess)
  }

  // A number x is called a fixed point of a function f if
  // f(x) = x
  // (y = x / y) ... sqrt(x)
  // so sqrt(x) is a fixed point of function y => x / y   ??????


  // Newton: y => (y + x/y)/2
  def sqrt(x: Double) = fixedPoint(y => (y + x / y) / 2)(1.0)

  // Newton: y => (2y + x/y/y)/3
  def cbrt(x: Double) = fixedPoint(y => ((2 * y + x / y / y)) / 3)(1.0)

  // Newton: y => (3y + x/y/y/y)/4
  def fourt(x: Double) = fixedPoint(y => (3 * y + (x / y) / y / y) / 4)(1.0)

  println("sqrt" + sqrt(4))
  println("cbrt" + cbrt(27))
  println("fourt" + fourt(16))
  println("fourt" + fourt(256))
  println("cbrt" + cbrt(-27))
}
