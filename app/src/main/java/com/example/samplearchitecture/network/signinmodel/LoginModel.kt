package com.example.samplearchitecture.network.signinmodel

import com.example.samplearchitecture.network.signinmodel.Data

data class LoginModel(
    val code: Int,
    val `data`: Data,
    val success: Boolean
)