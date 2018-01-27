package com.gitshah.blog

import com.google.gson.GsonBuilder


fun Any.toJson(): String = GsonBuilder().setPrettyPrinting().create().toJson(this)

inline fun <reified T : Any> String.fromJson(): T = GsonBuilder().setPrettyPrinting().create().fromJson(this, T::class.java)
