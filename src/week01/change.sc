package week01

object change {
    def countChange(money: Int, coins: List[Int]): Int = {
       def sum(coin: Int, acc: Int): Boolean = {
          println(acc)
          if (acc < money)
             sum(coin, acc + coin)
          else
          	(acc == money)
       }
       
       def checkCoin(coins: List[Int], coin: Int, acc: Int, counter: Int): Int = {
         println(coins + " " + coin + " " + acc + " " + counter)
         var c = 0
         if (acc < money) {
	         println("-")
            c = checkCoin(coins, coin, acc + coin, counter)
         } else if (acc == money) {
	         println("+" + counter)
            counter + 1
         } else {
         }
	       println("+")
         c
       }
       checkCoin(coins.tail, coins.head, 0, 0)
    }                                             //> countChange: (money: Int, coins: List[Int])Int
    
    countChange(10, List(1, 2))                   //> List(2) 1 0 0
                                                  //| -
                                                  //| List(2) 1 1 0
                                                  //| -
                                                  //| List(2) 1 2 0
                                                  //| -
                                                  //| List(2) 1 3 0
                                                  //| -
                                                  //| List(2) 1 4 0
                                                  //| -
                                                  //| List(2) 1 5 0
                                                  //| -
                                                  //| List(2) 1 6 0
                                                  //| -
                                                  //| List(2) 1 7 0
                                                  //| -
                                                  //| List(2) 1 8 0
                                                  //| -
                                                  //| List(2) 1 9 0
                                                  //| -
                                                  //| List(2) 1 10 0
                                                  //| +0
                                                  //| +
                                                  //| +
                                                  //| +
                                                  //| +
                                                  //| +
                                                  //| +
                                                  //| +
                                                  //| +
                                                  //| +
                                                  //| +
                                                  //| +
                                                  //| res0: Int = 0
}