package com.example.lesson36

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// Ваш ViewModel
class CounterViewModel : ViewModel() {
    private val _counter = MutableLiveData<Int>()
    val counter: LiveData<Int> get() = _counter

    init {
        _counter.value = 0
    }

    fun increment() {
        _counter.value = (_counter.value ?: 0) + 1
    }

    fun decrement() {
        _counter.value = (_counter.value ?: 0) - 1
    }
}
