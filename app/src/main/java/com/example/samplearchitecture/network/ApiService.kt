package com.example.samplearchitecture.network

import com.example.samplearchitecture.network.signinmodel.LoginModel
import com.example.samplearchitecture.network.signinmodel.SignModel
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {
    @Headers("Content-Type: application/json")
    @POST("auth/login")
    fun validateLogin(@Body signModel: SignModel): Deferred<Response<LoginModel>>

}