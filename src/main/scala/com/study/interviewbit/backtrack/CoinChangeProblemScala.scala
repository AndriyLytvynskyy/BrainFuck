package com.study.interviewbit.backtrack

/**
  * coin 1 ->
  *
  */
object CoinChangeProblemScala extends App{
  val coins = Array(1, 2)
  val target = 3
  def getCombinations(target: Int, coin: Int): Int = {
     if (target == 0) return 1

     if (target < 0) return 0

    var numCombinations = 0
    for (i <- coins.indices) {
      numCombinations += getCombinations(target - coins(i), coins(i))
    }
    numCombinations
  }
  println("Coin Change Problem Scala Solved: " + getCombinations(target,0))

}
