package week01

object finding_fixed_point {

  val tolerance = 0.0001                          //> tolerance  : Double = 1.0E-4
  
  def isCloseEnough(x: Double, y: Double): Boolean =
    math.abs((x - y) / x) / x  < tolerance        //> isCloseEnough: (x: Double, y: Double)Boolean

  def improve(guess: Double, x: Double): Double =
    (guess + x / guess) / 2                       //> improve: (guess: Double, x: Double)Double

  def fixedPoint(f: Double => Double)(firstGuess : Double): Double = {
    def iterate(guess: Double): Double = {
      val next = f(guess)
      println(guess)
	  	if (isCloseEnough(guess, next)) next
	  	else iterate(next)
    }
    iterate(firstGuess)
  }                                               //> fixedPoint: (f: Double => Double)(firstGuess: Double)Double
  fixedPoint(x => 1 + x/2)(1)                     //> 1.0
                                                  //| 1.5
                                                  //| 1.75
                                                  //| 1.875
                                                  //| 1.9375
                                                  //| 1.96875
                                                  //| 1.984375
                                                  //| 1.9921875
                                                  //| 1.99609375
                                                  //| 1.998046875
                                                  //| 1.9990234375
                                                  //| 1.99951171875
                                                  //| res0: Double = 1.999755859375
  def averageDamp(f: Double => Double)(x: Double) = (x + f(x))/2
                                                  //> averageDamp: (f: Double => Double)(x: Double)Double
  
  def sqrt(x: Double) = fixedPoint(averageDamp(y => x / y))(1)
                                                  //> sqrt: (x: Double)Double
  sqrt(2)                                         //> 1.0
                                                  //| 1.5
                                                  //| 1.4166666666666665
                                                  //| 1.4142156862745097
                                                  //| res1: Double = 1.4142135623746899
}