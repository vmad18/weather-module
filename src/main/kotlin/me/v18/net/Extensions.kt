package me.v18.net

import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject


val String.to_json: JsonObject
    get() = Gson().fromJson(this, JsonObject::class.java)

val String.json_map: Map<String, JsonElement>
    get() = this.to_json.asMap()

val JsonElement.json_map: Map<String, JsonElement>
    get() = this.toString().json_map