package com.study.leet

import scala.collection.mutable

/**
  *
  * @author andrii_lytvynskyi
  */
object TwoSum {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    var result = Array[Int]()
    for (i <- 0 until nums.length) {
      for (j <- i + 1 until nums.length) {
         if (nums(j) == (target - nums(i))) {
           result = Array(i, j)
           return result
         }
      }

    }
    result
  }


  def twoSumScala(nums: Array[Int], target: Int): Array[Int] = {
    for (i <- nums.indices;
         j <- i + 1 until nums.length if nums(j) == (target - nums(i)))
      yield Array(i, j)

  }.flatten.toArray

  def twoSumMap(nums: Array[Int], target: Int): Array[Int] = {
    val mapWithIndexes = mutable.Map[Int, Int]()
    for (i <- nums.indices) {
      if (mapWithIndexes.contains(target - nums(i))) {
        return Array(i, mapWithIndexes(target - nums(i)))
      } else {
        mapWithIndexes.put(nums(i), i)
      }
    }
    Array[Int]()
  }

  def twoSumMapRec(nums: Array[Int], target: Int): Array[Int] = {
    def twoSumRecHelp(map: mutable.Map[Int, Int], index: Int): Array[Int] = {
      val elementToFind = target - nums(index)
      if (map.contains(elementToFind)) {
        Array(index, map(elementToFind))
      } else {
        if (!nums.isEmpty) {
          map.put(nums(index), index)
          twoSumRecHelp(map, index + 1)
        } else {
          Array[Int]()
        }
      }
    }
    twoSumRecHelp(mutable.Map[Int, Int](), 0)
  }

  def main(args: Array[String]): Unit = {
    twoSumMapRec(Array(3,2,4), 6).foreach(println)
    println()
  }
}
