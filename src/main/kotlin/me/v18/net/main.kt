package me.v18.net

import org.jsoup.Jsoup


fun main(args: Array<String>): Unit {

    assert(args.size >= 4)

    val web = Website(args[0], args[1], args[2])

    val weather = Weather {
        val parse: String = Jsoup.connect(web.site).ignoreContentType(true).execute().body()
        parse.json_map
    }

    when (args[3]) {
        "temp" -> println(weather.temp)
        "feel" -> println(weather.feel_temp)
        "humid" -> println(weather.humid)
        "speed" -> println(weather.wind_speed)
        "status" -> println(weather.status)
    }
}