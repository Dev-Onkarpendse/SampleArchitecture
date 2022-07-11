package com.example.samplearchitecture

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.samplearchitecture.base.BaseActivity
import com.example.samplearchitecture.databinding.ActivityMainBinding
import com.example.samplearchitecture.di.StoragePreference
import com.example.samplearchitecture.utility.ERROR
import com.example.samplearchitecture.utility.LOADING
import com.example.samplearchitecture.utility.SUCCESS
import com.example.samplearchitecture.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {
    @Inject
    lateinit var storagePreference: StoragePreference


    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
    override val mViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mViewBinding.root)

    }

    override fun onResume() {
        super.onResume()
/*
        mViewModel.callLoginApi().observe(this, {
            println(it)
        })
*/
        mViewModel.callLoginApiTEMP().observe(this) { response ->
            response?.let { resources ->
                when (resources) {
                    is SUCCESS -> {
                        Log.e( "resources: ","SUCCESS ${resources.data}" )
                    }
                    is ERROR -> {
                        Log.e( "resources: ","ERROR ${resources.message}" )
                    }
                    is LOADING -> {
                        Log.e( "resources: ","Loading" )
                    }
                }
            }
        }

    }


}