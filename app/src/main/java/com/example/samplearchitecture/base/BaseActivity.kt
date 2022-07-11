

package com.example.samplearchitecture.base

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import java.util.*

/**
 * Abstract Activity which binds [ViewModel] [VM] and [ViewBinding] [VB]
 */
abstract class BaseActivity<VM : ViewModel, VB : ViewBinding> : AppCompatActivity() {

    protected abstract val mViewModel: VM

    protected lateinit var mViewBinding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewBinding = getViewBinding()
    }

    /**
     * It returns [VB] which is assigned to [mViewBinding] and used in [onCreate]
     */
    abstract fun getViewBinding(): VB
    fun setLanguage(langCode: String, context: Context) { //setting new configuration
        var language = langCode
        System.out.println("Language"+language)
        var locale = Locale(language)
        var res = resources
        var dm = res.displayMetrics
        val config = res.configuration
        //config.setLocale(locale)
        config.locale=locale
        context.createConfigurationContext(config)
        res.updateConfiguration(config, dm)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun hasNetwork(applicationContext: Context):Boolean{
        return isNetworkConnected(applicationContext)

    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun isNetworkConnected(applicationContext: Context): Boolean {
        var networkInfo : Network?=null
        val connectivityManager =
            applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        networkInfo = connectivityManager.activeNetwork
        val networkCapabilities = connectivityManager.getNetworkCapabilities(networkInfo)
        return networkCapabilities!=null && networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)

    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun onDestroy() {
        super.onDestroy()
//        finish()
//        finishAffinity()
//        finishAndRemoveTask()
    }


}
