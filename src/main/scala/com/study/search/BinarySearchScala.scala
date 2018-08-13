package com.study.search

object BinarySearchScala {

  def search(list: Array[Int], key: Int): Int ={
    var start = 0
    var end = list.length - 1
    while (start <= end) {
      val mid = start + (end - start) / 2
      if (key < list(mid)) {
        end = mid - 1
      }
      else if (key > list(mid)) {
        start = mid + 1
      }
      else {
        return mid
      }
    }
    -1
  }

  def searchRecursive(list: Array[Int], key: Int): Int ={
      def recursive(start: Int, end: Int, key: Int, list: Array[Int]): Int = {
        if (start > end) return -1
        val mid = start + (end - start) / 2
        if (key < list(mid)) {
          recursive(start, mid -1, key, list)
        }
        else if (key > list(mid)) {
          recursive( mid + 1, end, key, list)
        } else {
          mid
        }

      }
    recursive(0 , list.length - 1, key, list)
  }

  def main(args: Array[String]): Unit = {
    val list = Array(6,2,3,4,5).sorted
    println(search(list, 25))
    println(searchRecursive(list, 25))
  }
}
