package me.v18.net

import com.jaunt.JNode

class Website(lat: String, long: String, key: String, units: String = "imperial"){
    val site: String = "https://api.openweathermap.org/data/2.5/weather?lat=$lat&lon=$long&units=$units&appid=$key"
}

class Weather(private val ping: () -> JNode) {

    private val main: JNode?
        get() = ping.invoke().fe("main")[1]

    private val wind: JNode?
        get() = ping.invoke().ff("wind")

    private val icon = mapOf("01d" to "●", "02d" to "", "03d" to "", "04d" to "", "09d" to "", "10d" to "", "11d" to "", "13d" to "", "50d" to "")

    val temp: String
        get() = main?.ff("temp").toString()

    val feel_temp: String
        get() = main?.ff("feels_like").toString()

    val humid: String
        get() = main?.ff("humidity").toString()

    val wind_speed: String
        get() = wind?.ff("speed").toString()

}
