package week01

object factorial {

  def factorial(n: Int): Int = {
      def tailFactorial(s: Int, n: Int): Int =
        if (n > 0) tailFactorial(s * n, n -1) else s
      tailFactorial(1, n)
  }                                               //> factorial: (n: Int)Int

  factorial(5)                                    //> res0: Int = 120
}