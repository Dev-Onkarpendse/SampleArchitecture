package com.example.samplearchitecture.utility

sealed class Resource
data class SUCCESS(val data: Any) : Resource()
data class ERROR(val message: String) : Resource()
object LOADING : Resource()
