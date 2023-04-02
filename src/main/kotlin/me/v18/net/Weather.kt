package me.v18.net


import com.google.gson.JsonArray
import com.google.gson.JsonElement

class Website(lat: String, long: String, key: String, units: String = "imperial") {
    val site: String = "https://api.openweathermap.org/data/2.5/weather?lat=$lat&lon=$long&units=$units&appid=$key"
}

class Weather(private val ping: () -> Map<String, JsonElement>) {

    private val main: Map<String, JsonElement>?
        get() = ping.invoke()["main"]!!.json_map

    private val wind: Map<String, JsonElement>?
        get() = ping.invoke()["wind"]!!.json_map

    private val icon = mapOf(
        "01" to "\uF185",
        "02" to "\uF6C4",
        "03" to "\uF6C4",
        "04" to "\uF6C4",
        "09" to "\uF740",
        "10" to "\uF740",
        "11" to "\uF76C",
        "13" to "\uF2DC",
        "50" to "\uF75F"
    )

    val temp: String
        get() = main!!["temp"].toString()

    val feel_temp: String
        get() = main!!["feels_like"].toString()

    val humid: String
        get() = main!!["humidity"].toString()

    val wind_speed: String
        get() {
            var speed = wind!!["speed"].toString()
            if (speed.length == 1)
                speed += ".00"
            return speed
        }

    val status: String?
        get() = icon[(ping.invoke()["weather"]!! as JsonArray)[0].json_map["icon"].toString().substring(1, 3)]

}
