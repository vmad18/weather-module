package me.v18.net

import com.jaunt.JNode

fun JNode.fe(q: String?): JNode = this.findEvery(q)

fun JNode.ff(q: String?): JNode = this.findFirst(q)