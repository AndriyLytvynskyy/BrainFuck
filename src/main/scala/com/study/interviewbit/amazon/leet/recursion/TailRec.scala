package com.study.interviewbit.amazon.leet.recursion

/**
 *
 * @author andrii_lytvynskyi
 */
object TailRec {
  def fact(n: Int): Int = {
    def helper(n: Int, accum: Int): Int = {
      if (n == 0) {
        accum
      } else {
        helper (n - 1, accum * n)
      }
    }
    helper(n, 1)
  }

  def main(args: Array[String]): Unit = {
    println(fact(4))
  }

}
