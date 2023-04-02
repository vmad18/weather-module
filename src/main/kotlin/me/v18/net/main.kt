package me.v18.net
import com.jaunt.*

fun main(args: Array<String>): Unit{

    val web = Website("", "", "")

    val ua = UserAgent()

    val weather = Weather{
        ua.visit(web.site)
        ua.json
    }

    assert(args.isNotEmpty())

    when(args[0]){
        "temp" -> println(weather.temp)
        "feel" -> println(weather.feel_temp)
        "humid" -> println(weather.humid)
        "speed" -> println(weather.wind_speed)
    }
}