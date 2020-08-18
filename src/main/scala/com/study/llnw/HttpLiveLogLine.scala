package com.study.llnw

/**
  *
  * @author andrii_lytvynskyi
  */
case class HttpLiveLogLine(ip: String,
                           login: String,
                           auth: String,
                           date: Long = -1,
                           offset:Int = -1,
                           reqMethod: String,
                           reqUrl: String,
                           protocol: String,
                           resultCode: Int,
                           bytes: Long = -1,
                           referer: String,
                           userAgent:String,
                           reqDuration:Long = -1,
                           byteRangeRequestFor206:String,
                           publishedUrl:String,
                           contentLength: Long = -1,
                           hitMiss: Int = -1
                          )

