package br.com.wizsolucoes.copa_prototipo.utils

import android.content.Context
import android.net.ConnectivityManager

/**
 * Created by eduardoewerton on 14/09/17.
 */
class MyNetwork() {

    fun isNetworkConnected(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }
}