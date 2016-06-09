package week01

object TestRecursion {
  
    def countChange(money: Int, coins: List[Int]): Int = {
      
       def sumList(acc: List[Int]):Int = {
         if (acc.isEmpty)
           0
         else
           acc.head + sumList(acc.tail)
       }
       def checkCoin(coins: List[Int], coin: Int, acc: List[Int], counter: Int): Int = {
         var c = counter
         if (!coins.isEmpty) {
           var sum = sumList(acc)
           if (sum < money) {
             c = checkCoin(coins, coin, acc :+ coin, c)
           } else if (sum >= money) {
             if (sum == money) {
               c = counter + 1
               println(acc)
               print("-")
             }
             if (!acc.isEmpty) {
               if (acc.head != coin)
                 c = checkCoin(coins, coin, acc.tail, c)
               else if (!coins.isEmpty)
                 c = checkCoin(coins.tail, coins.head, acc.tail, c)
             }
           } 
         }
         c
       }
       checkCoin(coins.tail, coins.head, List(), 0)
    }
  
  def main(args: Array[String]) {
    println(countChange(4,List(1,2,4)))
    println(countChange(300,List(500,5,50,100,20,200,10)))
  }
}