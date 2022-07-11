package com.example.samplearchitecture.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.samplearchitecture.network.signinmodel.LoginModel
import com.example.samplearchitecture.repository.MainRepository
import com.example.samplearchitecture.utility.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository) :
    ViewModel() {

    fun callLoginApi(): LiveData<LoginModel> {
        return mainRepository.callloginApi()
    }

    fun callLoginApiTEMP(): LiveData<Resource> {
        return mainRepository.callloginApiTEMP()
    }
}