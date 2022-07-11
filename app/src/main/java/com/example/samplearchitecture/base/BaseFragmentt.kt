package com.example.samplearchitecture.base

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragmentt<V : BaseViewModel> : Fragment() {

    protected lateinit var viewModel: V

    abstract fun getViewModel(): Class<V>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
    }

    private fun initViewModel() {
//        viewModel = ViewModelProviders.of(
//            this,
//            ViewModelProvider.AndroidViewModelFactory(activity!!.application)
//        ).get(getViewModel())
    }

    protected fun finish() {
        activity?.finish()
    }


    private lateinit var viewGroup: ViewGroup
    open fun isOnline(context: Context): Boolean {
        val cm =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return netInfo != null && netInfo.isConnectedOrConnecting
    }




}