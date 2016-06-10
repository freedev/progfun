package week01

object TestRecursion {

  def countChange(money: Int, coins: List[Int]): Int = {

    def sumList(acc: List[Int]): Int = {
      if (acc.isEmpty)
        0
      else
        acc.head + sumList(acc.tail)
    }
    def recursCoin(coins: List[Int], curCoin: Int, counter: Int): Int = {
      var c = counter
      if (!coins.isEmpty) {
        c = checkCoin(coins, curCoin, 0, List(), c, 0)
        c = recursCoin(coins.tail, coins.head, c);
      }
      c
    }
        
    def countCoins(s: List[Int], rest: Int, counter: Int): Int = {
      var c = counter
      if (!s.isEmpty) {
        var curRest = rest - s.head
        if (!(curRest < 0)) {
          if (curRest >= s.head) {
            if (s.size > 1) {
              c = countCoins(s.tail, curRest, c)
            }
            println(" "+s.head)
            c = countCoins(s, curRest, c)
          } else if (curRest == 0 && s.size == 1) {
            println("-" + s.head)
            c = c + 1
          } else
              c = countCoins(s.tail, curRest, c)
        }
      }
      c
    }

    def comb1(s: List[Int]): Int = { comb2(List(), s, 0) }

    def comb2(prefix: List[Int], s: List[Int], counter : Int): Int = {
      var c = counter
      if (s.size > 0) {
        val curComb = prefix :+ s.head
        println("entering  " + curComb);
        c = countCoins(curComb, money, c)
        println(money + " " + c + " " + curComb);
        c = comb2(prefix :+ s.head, s.tail, c);
        c = comb2(prefix, s.tail, c);
      }
      c
    }


    def getCoin(coins: List[Int], curCoin: Int): Int = {
      
      0
    }
    
    def checkCoin(curCoins: List[Int], coin: Int, pos: Int, acc: List[Int], counter: Int, deep: Int): Int = {
      var c = counter
      if (!curCoins.isEmpty) {
        println("pos: " + pos + " " + acc)
        var sum = sumList(acc)
        if (sum < money) {
          println("adding " + curCoins.head)
          c = checkCoin(curCoins, coin, pos, acc :+ curCoins.head, c, deep+1)
        } else if (sum >= money) {
          if (sum == money) {
            c = counter + 1
            println("- found " + acc)
            if ((acc.head != curCoins.head)) {
              c = checkCoin(curCoins, coin, pos, acc.tail, c, deep+1)
            } else {
              c = checkCoin(curCoins.tail, coin, pos + 1, acc.tail, c, deep+1)
            }
          } else {
            if ((acc.head != curCoins.head)) {
              c = checkCoin(curCoins, coin, pos, acc.tail, c, deep+1)
            } else
              c = checkCoin(curCoins.tail, coin, pos + 1, acc.tail, c, deep+1)
          }
        }
      }
      c
    }
    val s = coins.sorted.reverse
    comb1(s)
  }

  def main(args: Array[String]) {
    println(countChange(300, List(200, 50, 20, 10, 5, 100)))
//    println(countChange(5, List(5, 2, 3)))
//    println(countChange(5, List(1, 2, 3)))
//    println(countChange(5, List(3, 1, 2)))
//    println(countChange(6, List(4, 2, 1)))
//    println(countChange(6, List(1, 2, 4)))
//    println(countChange(4, List(4, 1, 2)))
//  println(countChange(300, List(500, 5, 50, 100, 20, 200, 10)))
  }
}