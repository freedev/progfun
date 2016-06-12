package week01

import scala.annotation.tailrec

object TestTailRecursive {

  def sumrec(f: Int => Int, a: Int, b: Int): Int = {
    if (a > b) 
      0
    else 
      f(a) + sumrec(f, a + 1, b)
  }
  
  def id(x: Int): Int = x
  
  @tailrec
  def factorial2(s: Int, n: Int): Int = {
      if (n == 0)
	      s
	    else
	      factorial2(s * n, n - 1)
  }

  def main(args: Array[String]) {
//    println(factorial2(1, 5))
//    combinations(list)       
//> start: 0 pos: 0 size: 0

//    println(sum(x => x + 1)(2, 5) )
//    println(sumrec(id, 2, 5) )

    println(product(x => x * x)(3, 4) )
    println(factorial(5) )
    println(combine((a, b) =>{ a * b })(1)(x => x)(1, 5))
  
  }

  def sum(f: Int => Int)(a: Int, b: Int): Int = {
  @tailrec
    def loop(a: Int, acc: Int): Int = {
      if (a > b) 
        acc
      else 
        loop(a + 1, f(a) + acc)
    }
    loop(a, 0)
  }
 
  def product(f: Int => Int)(a: Int, b: Int): Int = {
  @tailrec
    def loop(a: Int, acc: Int): Int = {
      if (a > b) 
        acc
      else 
        loop(a + 1, f(a) * acc)
    }
    loop(a, 1)
  }
  
  def combine(fcomb:(Int, Int) => Int)(base: Int)(f: Int => Int)(a: Int, b: Int): Int = {
    @tailrec
      def loop(a: Int, acc: Int): Int = {
        if (a > b) 
          acc
        else 
          loop(a + 1, fcomb(f(a), acc))
      }
      loop(a, base)
  }
  
  def factorial(f: Int): Int = {
    if (f == 1)
      f
    else
      product(x => x)(1, f)
  }
}