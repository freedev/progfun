package week01

object TestRecursion {
  
    def countChange(money: Int, coins: List[Int]): Int = {
      
       def sumList(acc: List[Int]):Int = {
         if (acc.isEmpty)
           0
         else
           acc.head + sumList(acc.tail)
       }
       def recursCoin(coins: List[Int], curCoins: Int, counter: Int): Int = {
          var c = counter
          if (!coins.isEmpty) {
            c = checkCoin(coins.tail, coins.head, List(), c)
            c = recursCoin(coins.tail, coins.head, c);
          }
          c
       }
       def checkCoin(coins: List[Int], curCoins: Int, acc: List[Int], counter: Int): Int = {
         var c = counter
           println(acc)
           var sum = sumList(acc)
           if (sum < money) {
             println("add " + curCoins)
             c = checkCoin(coins, curCoins, acc :+ curCoins, c)
           } else if (sum >= money) {
             if (sum == money) {
               c = counter + 1
               println("- found " + acc)
//               if (acc.head != curCoins) {
//                 println("remove " + acc.head)
//                 c = checkCoin(coins, curCoins, acc.tail, c)
//               }
             }
             else {
               if (!acc.isEmpty) {
                 if (!coins.isEmpty) {
                     c = checkCoin(coins.tail, coins.head, acc.tail, c) 
                 }
               }
             }
           } 
         c
       }
       recursCoin(coins, 0, 0)
    }
  
  def main(args: Array[String]) {
    println(countChange(5,List(3,1,2)))
    println(countChange(6,List(4,2,1)))
    println(countChange(6,List(1,2,4)))
    println(countChange(4,List(4,1,2)))
    println(countChange(300,List(500,5,50,100,20,200,10)))
  }
}