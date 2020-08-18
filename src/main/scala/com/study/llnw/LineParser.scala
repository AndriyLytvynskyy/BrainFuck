package com.study.llnw

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale
import java.util.regex.{Matcher, Pattern}



object LineParser {

  private val LogEntryPattern = "^(\\S+) (\\S+) (\\S+) \\[([\\w:/]+\\s[+\\-]\\d{4})\\] \"(\\S+) (.+) (\\S+/\\d\\.?\\d?)\" (\\d{3}) (\\d+) \"(.*)\" \"(.*)\" (?:\"(.*)\" \"(.+)\" \"(\\S+)\"|(\\d+) \"(.*)\" \"(.+)\" \"(\\S*)\") (\\S+)"
  private val LogPattern = Pattern.compile(LogEntryPattern)
  private val DT_FORMATTER = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss XXXX", Locale.US)

  private val POS_IP = 1
  private val POS_LOGIN = 2
  private val POS_AUTH = 3
  private val POS_DATE_OFFSET = 4
  private val POS_REQ_METHOD = 5
  private val POS_REQ_URL = 6
  private val POS_PROTOCOL = 7
  private val POS_RESULT_CODE = 8
  private val POS_BYTES = 9
  private val POS_REFERER = 10
  private val POS_USER_AGENT = 11
  private val POS_BYTE_RANGE_REQUEST_FOR_206 = 12
  private val POS_REQUEST_DURATION = 15
  private val POS_RANGE_FOR_206_GROUP = 16
  private val POS_HIT_MISS = 19

  def parse(line: String): HttpLiveLogLine = {
    val m: Matcher = LogPattern.matcher(line)

    if (!m.find()) {
      throw new RuntimeException("Not able to parse the line")
    }

    var reqDuration = 0L
    var rangeFor206Group = POS_BYTE_RANGE_REQUEST_FOR_206

    val byteRangeRequestFor206 = Option(m.group(POS_BYTE_RANGE_REQUEST_FOR_206))
    if (byteRangeRequestFor206.isEmpty) {
      reqDuration = m.group(POS_REQUEST_DURATION).toLong
      rangeFor206Group = POS_RANGE_FOR_206_GROUP
    }

    val (date, offset) = {
      val dt = ZonedDateTime.parse(m.group(POS_DATE_OFFSET), DT_FORMATTER)
      (dt.toInstant.toEpochMilli, dt.getOffset.getTotalSeconds)
    }

    HttpLiveLogLine(
      ip = m.group(POS_IP),
      login = m.group(POS_LOGIN),
      auth = m.group(POS_AUTH),
      date = date,
      offset = offset,

      reqMethod = m.group(POS_REQ_METHOD),
      reqUrl = m.group(POS_REQ_URL),
      protocol = m.group(POS_PROTOCOL),
      resultCode = m.group(POS_RESULT_CODE).toInt,
      bytes = m.group(POS_BYTES).toLong,
      referer = m.group(POS_REFERER),
      userAgent = m.group(POS_USER_AGENT),
      reqDuration = reqDuration,

      byteRangeRequestFor206 = m.group(rangeFor206Group),
      publishedUrl = m.group(rangeFor206Group + 1),
      contentLength = m.group(rangeFor206Group + 2).toLong,
      hitMiss = m.group(POS_HIT_MISS).toInt
    )

  }

}
