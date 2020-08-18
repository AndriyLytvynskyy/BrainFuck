package com.study.interviewbit.amazon.leet.strings

import scala.collection.mutable.ArrayBuffer

/**
 *
 * @author andrii_lytvynskyi
 */
object ThreeSumScala {

  def threeSum(nums: Array[Int]): List[List[Int]] = {


    def threeSumHelper(index: Int, result: ArrayBuffer[List[Int]]) = {

      var lowIndex = index + 1
      var highIndex = nums.length - 1
      while (lowIndex < highIndex) {
        val sum = nums(index) + nums(lowIndex) + nums(highIndex)
        if (sum < 0 || (lowIndex > index + 1 && nums(lowIndex) == nums(lowIndex - 1))) {
          lowIndex = lowIndex + 1
        }
        else if (sum > 0 || (highIndex < nums.length - 1 && nums(highIndex) == nums(highIndex + 1))) {
          highIndex = highIndex - 1
        } else {
          //triplet
          result.append(List(nums(index), nums(lowIndex), nums(highIndex)))
          lowIndex = lowIndex + 1
          highIndex = highIndex - 1

        }
      }

    }

    val result:ArrayBuffer[List[Int]] = ArrayBuffer[List[Int]]()
    scala.util.Sorting.quickSort(nums)
    for (x <- nums.indices){
      if (x == 0 || nums(x) != nums(x - 1)) { //no duplicates
        threeSumHelper(index = x, result)
      }
    }

    result.toList

  }


  def main(args: Array[String]): Unit = {
    threeSum(Array[Int](10,2,3,4,5))
  }

}
