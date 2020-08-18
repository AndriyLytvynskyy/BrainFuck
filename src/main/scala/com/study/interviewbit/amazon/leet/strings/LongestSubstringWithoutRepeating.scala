package com.study.interviewbit.amazon.leet.strings

import scala.collection.mutable

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 */
object LongestSubstringWithoutRepeating {

  /**
   * OOM Solution, although all tests pass
   *
   * @param s
   * @return
   */
  def lengthOfLongestSubstring(s: String): Int = {
    def lengthHelp(longestStringAcc: mutable.Set[Char], str: Array[Char], start: Int, end: Int): Int = {
      if (start < s.length && end < s.length) {
        val el = str(end)
        if (longestStringAcc.contains(el)) {
          longestStringAcc.remove(str(start))
          Math.max(end - start, lengthHelp(longestStringAcc, str, start + 1, end))
        } else {
          longestStringAcc.add(el)
          Math.max(end - start, lengthHelp(longestStringAcc, str, start, end + 1))
        }
      } else {
        end - start
      }
    }

    lengthHelp(mutable.Set[Char](), s.toCharArray, 0, 0)
    //if (seq.isEmpty) 0 else seq.max

  }

  //  def lengthOfLongestSubstringSliding(s: String): Int = {
  //    val n = s.length
  //    val set = mutable.Set[Char]()
  //    var (ans, i, j) = (0, 0, 0)
  //    while (i < n && j < n) {
  //      if (!set.contains(s.charAt(j))) {
  //        set.add(s.charAt(j))
  //        j = j + 1
  //        ans = Math.max(ans, j - i)
  //      }
  //      else {
  //        set.remove(s.charAt(i))
  //        i = i + 1
  //      }
  //    }
  //    ans
  //  }

  def longestSubstringCoding(s: String): Int = {
    var x, y = 0
    var max = 0
    val duplicateTrack: mutable.Set[Char] = mutable.Set[Char]()
    while (x < s.length && y < s.length) {

      if (!duplicateTrack.contains(s(y))) {
        duplicateTrack.add(s(y))
        y = y + 1
        max = Math.max(max, y - x)
      } else {
        duplicateTrack.remove(s(x))
        x = x + 1
      }
    }
    max
  }

  def main(args: Array[String]): Unit = {
    print(lengthOfLongestSubstring("dvdf"))
    print(lengthOfLongestSubstring("abcabcbb"))
    print(lengthOfLongestSubstring("pwwkew"))
    //print(lengthOfLongestSubstringSliding("abcabcbb"))
  }
}
