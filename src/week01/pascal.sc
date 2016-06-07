package week01

object pascal {
    def pascal(c: Int, r: Int): Int = {
        if (r > 1 && c > 0 && r > c)
          pascal(c - 1, r - 1) + pascal(c, r - 1)
        else
          1
    }                                             //> pascal: (c: Int, r: Int)Int

    pascal(0, 0)                                  //> res0: Int = 1

    pascal(0, 1)                                  //> res1: Int = 1

    pascal(1, 1)                                  //> res2: Int = 1

    pascal(0, 2)                                  //> res3: Int = 1

    pascal(1, 2)                                  //> res4: Int = 2

    pascal(2, 2)                                  //> res5: Int = 1

    pascal(0, 3)                                  //> res6: Int = 1

    pascal(1, 3)                                  //> res7: Int = 3

    pascal(2, 3)                                  //> res8: Int = 3

    pascal(3, 3)                                  //> res9: Int = 1

    pascal(0, 4)                                  //> res10: Int = 1

    pascal(1, 4)                                  //> res11: Int = 4

    pascal(2, 4)                                  //> res12: Int = 6

    pascal(3, 4)                                  //> res13: Int = 4

    pascal(4, 4)                                  //> res14: Int = 1
}