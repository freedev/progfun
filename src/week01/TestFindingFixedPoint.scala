package week01

object TestFindingFixedPoint {

  val tolerance = 0.0001

  def isCloseEnough(x: Double, y: Double): Boolean =
    math.abs((x - y) / x) / x < tolerance 

  def improve(guess: Double, x: Double): Double =
    (guess + x / guess) / 2

  def fixedPoint(f: Double => Double)(firstGuess: Double): Double = {
    def iterate(guess: Double): Double = {
      val next = f(guess)
      println(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }

  def averageDamp(f: Double => Double)(x: Double) = {
    (x + f(x)) / 2
  }
  

  def sqrt(x: Double) = {
    def newtonSqrtFunction(y: Double) = { 
      println(y / x)
      x / y 
    }
    fixedPoint(averageDamp(newtonSqrtFunction))(1)
  }

  def main(args: Array[String]) {
    sqrt(2)
  }

}