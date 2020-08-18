package com.study.leet

import scala.collection.mutable.ArrayBuffer

/**
 *
 * @author andrii_lytvynskyi
 */
object TextJustification {

  def fullJustify(words: Array[String], maxWidth: Int): Unit = {
    val lines = ArrayBuffer[String]()
    if (!words.isEmpty) {
      val lineBuffer: StringBuilder = new StringBuilder
      var numOfLetters = 0
      var curr = Array[String]()

      for (w <- words) {
        //if (numOfLetters + w.length)
      }
      //        if ((words(i).length < maxWidth) && (maxWidth - lineBuffer.length > 0)) {
      //          lineBuffer.append(words(i) + " ")
      //        } else {
      //          lines.append(lineBuffer.toString)
      //        }
      //      }
      //      lines.append(lineBuffer.toString)
      //      lines.toList
      //    } else {
      //      lines.toList
      //    }
    }
  }

  def main(args: Array[String]): Unit = {
    val words = Array[String] ("This", "is")
    println(fullJustify(words, 16))
  }

}
