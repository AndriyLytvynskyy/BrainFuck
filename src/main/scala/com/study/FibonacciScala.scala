package com.study

import scala.collection.mutable

object FibonacciScala extends App{
  val map = mutable.Map[Int, Int]()

  def fib(n: Int):Int = {
    if ((n == 1 ) || (n == 2)) {
       return 1
    }
    map.getOrElseUpdate(n, fib(n-1) + fib(n - 2))
  }

  println(fib(6))

}
