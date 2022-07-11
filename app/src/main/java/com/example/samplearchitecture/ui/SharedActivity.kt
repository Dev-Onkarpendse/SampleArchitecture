package com.example.samplearchitecture.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.samplearchitecture.R
import com.example.samplearchitecture.viewmodel.SharedViewModel

class SharedActivity : AppCompatActivity() {
    val sharedViewModel:SharedViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared)
    }
}