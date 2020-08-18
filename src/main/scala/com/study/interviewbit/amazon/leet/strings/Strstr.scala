package com.study.interviewbit.amazon.leet.strings

/**
 *
 * @author andrii_lytvynskyi
 */
object Strstr {
  def strStr(haystack: String, needle: String): Int = {
    for (start <- 0 until (haystack.length - needle.length + 1)) {
      if (haystack.substring(start, start + needle.length) == needle){
        return start
      }
    }
    return -1
  }

}
