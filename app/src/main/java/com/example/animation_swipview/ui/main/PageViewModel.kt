package com.example.animation_swipview.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PageViewModel : ViewModel() {

    private val index1 = MutableLiveData<Int>()

    val text: LiveData<String> = Transformations.map(index1) {
        "Hello world from section: $it"
    }
    val text1: LiveData<String> = Transformations.map(index1) {
        "It's new message from page: $it"
    }

    fun setIndex(index: Int) {
        index1.value = index
    }
}