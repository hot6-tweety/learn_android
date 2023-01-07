package com.tweety.learnapp

import androidx.lifecycle.LiveData

interface MyRepository {
    fun getCounter(): LiveData<Int>
    fun increaseCounter()
}