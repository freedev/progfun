package week01

import scala.collection.immutable.Nil

object TestCombinations {

  val list = List("A", "B", "C", "D")                     //> list  : List[Int] = List(1, 2, 3, 4)
  
     def printList(l: List[String]): String = {
        if (l.isEmpty)
           ""
        else
          l.head + printList(l.tail)
     }

  // print all subsets of the characters in s
  
     def combinations(coins: List[String]): Int = {
         def loop(start: Int, start_pos: Int, pos: Int, size: Int, combs: List[List[Int]]): Int = {
           println("start: " + start + " start_pos: " + start_pos + " pos: " + pos + " size: " + size)
           print("list: ")
           if ((start + size) > 0) {
             print(printList(list.slice(start - 1, start + size)) + " " )
           }
           println(printList(list.slice(pos, pos + 1)) )
           if (pos < (coins.size - 1 - size)) {
          	 loop(start, start_pos, pos + 1, size, combs)
         	 } else if (start < coins.size - 2) {
             	 loop(start + 1, start_pos, start + 1, size, combs)
         	 } else if (size < coins.size - 1) {
             loop(1, 0, start_pos, size + 1, combs)
         	 }
         	 start_pos + 1
         }
         loop(0, 0, 0, 0, List())
      }                                           //> combinations: (coins: List[Int])List[List[Int]]
        
 
  def main(args: Array[String]) {
//    combinations(list)                              //> start: 0 pos: 0 size: 0
  }
}