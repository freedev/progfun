package week01

object permutate {
  val list = List(1, 2, 3, 4)                     //> list  : List[Int] = List(1, 2, 3, 4)
 
      def combinations(coins: List[Int]): List[List[Int]] = {
         def loop(start: Int, pos: Int, combs: List[List[Int]]): List[List[Int]] = {
           if (pos < coins.size) {
             val c = if (start != pos)
               List(coins.slice(start, pos)) else List()
         	   loop(start, pos + 1, combs ::: c)
         	 } else if (start < coins.size) {
             
         	   loop(start + 1, start + 1, combs ::: List(coins.slice(start, pos)))
         	 } else
         	   combs
         }
         loop(0, 0, List())
      }                                           //> combinations: (coins: List[Int])List[List[Int]]

  
  combinations(list)                              //> res0: List[List[Int]] = List(List(1), List(1, 2), List(1, 2, 3), List(1, 2, 
                                                  //| 3, 4), List(2), List(2, 3), List(2, 3, 4), List(3), List(3, 4), List(4))
  
//  (1 to list.length).flatMap {
//    list.combinations(_)
//  }.toList
  
}