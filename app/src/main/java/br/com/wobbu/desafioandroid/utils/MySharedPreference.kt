package br.com.wizsolucoes.copa_prototipo.utils

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by eduardoewerton on 14/09/17.
 */
class MySharedPreference(context: Context) {

    var pref: SharedPreferences = context.getSharedPreferences("DesafioAndroid", 0)

    fun setString(key: String, value: String) {
        pref.edit().putString(key, value).apply()
    }

    fun setBoolean(key: String, value: Boolean) {
        pref.edit().putBoolean(key, value).apply()
    }

    fun setInt(key: String, value: Int) {
        pref.edit().putInt(key, value).apply()
    }

    fun getString(key: String): String {
        return pref.getString(key, "")
    }

    fun getBoolean(key: String): Boolean {
        return pref.getBoolean(key, false)
    }

    fun getInt(key: String): Int {
        return pref.getInt(key, 0)
    }

}