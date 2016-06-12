package week01

import scala.annotation.tailrec

object factorial {

  @tailrec
  def factorial2(n: Int): Int = {
      if (n == 0)
	      1
	    else
	      factorial2(n * (n - 1))
  }

  factorial2(5)
  factorial2(3)
}