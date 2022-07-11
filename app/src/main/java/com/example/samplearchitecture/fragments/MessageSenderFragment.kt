package com.example.samplearchitecture.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.samplearchitecture.R
import com.example.samplearchitecture.viewmodel.SharedViewModel

class MessageSenderFragment : Fragment(R.layout.message_sender_fragement) {
    val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedViewModel.data.value = "Temp"
        Log.e("MessageSender", "onActivityCreated: ")
    }
}