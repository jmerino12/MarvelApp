package com.jmb.marvelapp

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.jmb.domain.repository.InternetChecker
import java.lang.Exception

class AndroidCheckedInternet(private val application: Application) : InternetChecker {

    override suspend fun check(): Boolean {
        if (isNetworkAvailable()) {
            if (isOnlineNet()) {
                return true
            }
        }
        return false
    }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager =
            application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork ?: return false
        val isActiveNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false
        return when {
            isActiveNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            isActiveNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            else -> false
        }
    }

    private fun isOnlineNet(): Boolean {
        try {
            val p =
                Runtime.getRuntime().exec("ping -c 1 www.google.es")
            val `val` = p.waitFor()
            return `val` == 0
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return false
    }
}
