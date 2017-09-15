package br.com.wizsolucoes.copa_prototipo.utils

import android.util.Log
import com.google.gson.JsonObject
import java.io.DataOutputStream
import java.net.HttpURLConnection
import java.net.URL


/**
 * Created by eduardoewerton on 14/09/17.
 */

class ReadJson {

    fun readJsonGET(url: String): String {
        val conn = URL(url).openConnection() as HttpURLConnection
        val data = conn.inputStream.bufferedReader().readText()

        Log.i("JSON", data)

        return data
    }

    fun readJsonPOST(url: String): String {
        val conn = URL(url).openConnection() as HttpURLConnection
        conn.doOutput = true
        val data = conn.inputStream.bufferedReader().readText()

        Log.i("JSON", data)

        return data
    }

    fun readJsonPOST(url: String, json: JsonObject): String {
        val conn = URL(url).openConnection() as HttpURLConnection
        conn.setRequestProperty("Content-Type", "application/json")
        conn.doOutput = true
        conn.doInput = true
        conn.requestMethod = "POST"

        val urlParameters = json.toString()
        val postData = urlParameters.toByteArray()
        DataOutputStream(conn.outputStream).use { wr -> wr.write(postData) }

        val data = conn.inputStream.bufferedReader().readText()

        Log.i("JSON", data)

        return data
    }
}