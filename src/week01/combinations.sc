package week01

object combinations {

  val list = List(1, 2, 3, 4)                     //> list  : List[Int] = List(1, 2, 3, 4)

     def combinations(coins: List[Int]): List[List[Int]] = {
         def loop(start: Int, pos: Int, size: Int, combs: List[List[Int]]): List[List[Int]] = {
           println("start: " + start + " pos: " + pos + " size: " + size)
           
           if ((pos + size) < coins.size) {
          	 loop(start, pos + 1, size, combs)
         	 } else if (start + size < coins.size)
           	 loop(start, 0, size + 1, combs)
           else if (start + 1 < coins.size) {
         	   loop(start + 1, start + 1, 1, combs)
         	 } else
         	   combs
         }
         loop(0, 0, 1, List())
      }                                           //> combinations: (coins: List[Int])List[List[Int]]
        
  combinations(list)                              //> start: 0 pos: 0 size: 1
                                                  //| start: 0 pos: 1 size: 1
                                                  //| start: 0 pos: 2 size: 1
                                                  //| start: 0 pos: 3 size: 1
                                                  //| start: 0 pos: 0 size: 2
                                                  //| start: 0 pos: 1 size: 2
                                                  //| start: 0 pos: 2 size: 2
                                                  //| start: 0 pos: 0 size: 3
                                                  //| start: 0 pos: 1 size: 3
                                                  //| start: 0 pos: 0 size: 4
                                                  //| start: 1 pos: 1 size: 1
                                                  //| start: 1 pos: 2 size: 1
                                                  //| start: 1 pos: 3 size: 1
                                                  //| start: 1 pos: 0 size: 2
                                                  //| start: 1 pos: 1 size: 2
                                                  //| start: 1 pos: 2 size: 2
                                                  //| start: 1 pos: 0 size: 3
                                                  //| start: 1 pos: 1 size: 3
                                                  //| start: 2 pos: 2 size: 1
                                                  //| start: 2 pos: 3 size: 1
                                                  //| start: 2 pos: 0 size: 2
                                                  //| start: 2 pos: 1 size: 2
                                                  //| start: 2 pos: 2 size: 2
                                                  //| start: 3 pos: 3 size: 1
                                                  //| res0: List[List[Int]] = List()
  
  (1 to list.length).flatMap {
    list.combinations(_)
  }.toList                                        //> res1: List[List[Int]] = List(List(1), List(2), List(3), List(4), List(1, 2),
                                                  //|  List(1, 3), List(1, 4), List(2, 3), List(2, 4), List(3, 4), List(1, 2, 3), 
                                                  //| List(1, 2, 4), List(1, 3, 4), List(2, 3, 4), List(1, 2, 3, 4))
  
}