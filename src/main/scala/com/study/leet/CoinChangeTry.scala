package com.study.leet

import scala.collection.mutable

/**
 *
 * @author andrii_lytvynskyi
 */
object CoinChangeTry {
  def change(amount: Int, coins: Array[Int]): Int = {
    def countChange(money: Int, coins: List[Int], memo: mutable.Map[(Int, Int), Int]): Int = {
      if (money == 0) {
        1
      }
      else if (money < 0 || coins.isEmpty) {
        0
      }
      else {
        val t: (Int, Int) = Tuple2(money, coins.head)
        if (memo.contains(t)){
            memo(t)
        }else {
          val firstCoin = countChange(money - coins.head, coins, memo)
          val otherCoins = countChange(money, coins.tail, memo)
          val combs = firstCoin + otherCoins
          memo.put(Tuple2(money, coins.head), combs)
          combs
        }
      }

    }

    val memo = mutable.Map[(Int, Int), Int]()
    countChange(amount, coins.toList, memo)
  }

  def main(args: Array[String]): Unit = {
    //change()
  }

}
