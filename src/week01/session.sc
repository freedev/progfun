package week01

object session {

  def abs(x: Double): Double = if (x < 0) -x else x
                                                  //> abs: (x: Double)Double
  
  def isGoodEnough(guess: Double, x: Double): Boolean =
    abs(guess * guess - x) < 0.00000000000001     //> isGoodEnough: (guess: Double, x: Double)Boolean

  def improve(guess: Double, x: Double): Double =
    (guess + x / guess) / 2                       //> improve: (guess: Double, x: Double)Double

  def sqrtIter(guess: Double, x: Double): Double =
  	if (isGoodEnough(guess, x)) guess
  	else sqrtIter(improve(guess, x), x)       //> sqrtIter: (guess: Double, x: Double)Double
  	
  sqrtIter(1, 0.001)                              //> res0: Double = 0.03162277660168433
  
  sqrtIter(1, 0.1e-20)                            //> res1: Double = 5.960465036779586E-8
  
  sqrtIter(1, 1e-20)                              //> res2: Double = 5.960470069943345E-8
  
  sqrtIter(1, 1e-50)                              //> res3: Double = 5.9604644775390625E-8
  	
}