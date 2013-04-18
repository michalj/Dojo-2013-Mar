object test {
  import chapter3._
  
  val l = List(1, 2, 3)                           //> l  : List[Int] = List(1, 2, 3)
  setHead(l, 5)                                   //> res0: List[Int] = List(5, 2, 3)
  
  setHead(Nil, 3)                                 //> res1: List[Int] = List(3)
  
  
  init(l)                                         //> res2: List[Int] = List(1, 2)
  
  length(l)                                       //> res3: Int = 3
  length(Nil)                                     //> res4: Int = 0
  
  foldLeft((1 to 1000000).toList, 0.0)((a, e) => a * 1.0 + e)
                                                  //> res5: Double = 5.000005E11
  reverse(l)                                      //> res6: List[Int] = List(3, 2, 1)
  
  foldLeft2(l, 0)((a, e) => a * 10 + e)           //> res7: Int = 123
  l.foldRight(0)((e, a) => a * 10 + e)            //> res8: Int = 321
}