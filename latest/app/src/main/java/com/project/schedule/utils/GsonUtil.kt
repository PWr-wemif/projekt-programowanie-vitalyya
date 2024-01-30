package com.project.schedule.utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.project.schedule.models.Lesson

class GsonUtil {
    val gson: Gson = Gson()

    fun convertToString(list: List<Lesson>): String{
        return Gson().toJson(list)
    }

    fun convertFromGson(string: String): List<Lesson>{
        class Token : TypeToken<List<Lesson>>()
        return Gson().fromJson(string, Token().type)
    }
}