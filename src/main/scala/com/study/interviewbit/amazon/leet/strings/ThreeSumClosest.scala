package com.study.interviewbit.amazon.leet.strings

/**
 *
 * @author andrii_lytvynskyi
 */
object ThreeSumClosest {
  def threeSumClosest(nums: Array[Int], target: Int): Int = {
    scala.util.Sorting.quickSort(nums)
    var diff = Integer.MAX_VALUE
    var index = 0
    while (index < nums.length && diff != 0){
    //for (index <- 0 until nums. if diff != 0 ) {

      var (lowIndex, highIndex) = (index + 1, nums.length - 1)
      while (lowIndex < highIndex) {
        val sum = nums(lowIndex) + nums(highIndex) + nums(index)
        if (Math.abs(target - sum) < Math.abs(diff)){
          diff = target - sum;
          if (sum < target)
            lowIndex = lowIndex + 1
        } else{
          highIndex = highIndex - 1
        }
      }
      index = index + 1
    }
    target - diff
  }

  def main(args: Array[String]): Unit = {
    print(threeSumClosest(Array(1,2,4,8,16,32,64,128), 82))
    }
}
