package com.example.samplearchitecture.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.samplearchitecture.db.InterfaceDao
import com.example.samplearchitecture.di.StoragePreference
import com.example.samplearchitecture.network.ApiService
import com.example.samplearchitecture.network.signinmodel.LoginModel
import com.example.samplearchitecture.network.signinmodel.SignModel
import com.example.samplearchitecture.utility.ERROR
import com.example.samplearchitecture.utility.Resource
import com.example.samplearchitecture.utility.SUCCESS
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject
import retrofit2.Response
import javax.inject.Inject

class MainRepository @Inject constructor(
    val apiService: ApiService,
    val interfaceDao: InterfaceDao,
    val storagePreference: StoragePreference
) {
    private val uiScope = CoroutineScope(Dispatchers.IO)
    fun callloginApi(): LiveData<LoginModel> {
        val loginLiveData = MutableLiveData<LoginModel>()
        uiScope.launch {
            val resultDef: Deferred<Response<LoginModel>> =
                apiService.validateLogin(SignModel("mr.sandeep51@gmail.com", "1234"))
            try {
                val result: Response<LoginModel> = resultDef.await()
                if (result.code() == 200) {
                    if (result.isSuccessful) {
                        val response = result.body()
                        response?.let {
                            loginLiveData.postValue(it)
                        }
                    }
                } else {
                    if (result.code() != 200) {
                        result.errorBody()?.string()?.let {
                            val msg = JSONObject(it).optString("message")
                            Log.e("API", "callloginApi: $msg")
                            storagePreference.setSampleData(msg)
                        }
                    }
                }
            } catch (ex: Exception) {
                resultDef.getCompletionExceptionOrNull()?.let {
                    println(it.message)
                }

            }
        }
        return loginLiveData
    }
    fun callloginApiTEMP(): LiveData<Resource> {
        val loginLiveData = MutableLiveData<Resource>()
        uiScope.launch {
            val resultDef: Deferred<Response<LoginModel>> =
                apiService.validateLogin(SignModel("mr.sandeep51@gmail.com", "1234"))
            try {
                val result: Response<LoginModel> = resultDef.await()
                if (result.code() == 200) {
                    if (result.isSuccessful) {
                        val response = result.body()
                        response?.let {
                            loginLiveData.postValue(SUCCESS(it))
                        }
                    }
                } else {
                    if (result.code() != 200) {
                        result.errorBody()?.string()?.let {
                            val msg = JSONObject(it).optString("message")
                            Log.e("API", "callloginApi: $msg")
                            loginLiveData.postValue(ERROR(msg))
                        }
                    }
                }
            } catch (ex: Exception) {
                resultDef.getCompletionExceptionOrNull()?.let {
                    println(it.message)
                    loginLiveData.postValue(ERROR(it.message!!))
                }

            }
        }
        return loginLiveData
    }
}