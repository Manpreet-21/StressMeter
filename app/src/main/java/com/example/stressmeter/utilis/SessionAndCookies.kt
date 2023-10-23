package com.example.stressmeter.utilis

import android.content.Context
import android.content.SharedPreferences
import com.example.stressmeter.model.StressDataModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SessionAndCookies {

    companion object {
        // Function to save stressList in SharedPreferences
        fun saveStressList(context: Context, stressList: MutableList<StressDataModel>) {
            val sharedPreferences: SharedPreferences =
                context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            val gson = Gson()
            val json = gson.toJson(stressList)
            editor.putString("stressList", json)
            editor.apply()
        }

        // Function to get stressList from SharedPreferences
        fun getStressList(context: Context): MutableList<StressDataModel> {
            val sharedPreferences: SharedPreferences =
                context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
            val gson = Gson()
            val json = sharedPreferences.getString("stressList", null)
            val type = object : TypeToken<List<StressDataModel>>() {}.type
            return gson.fromJson(json, type) ?: mutableListOf()
        }
    }
}