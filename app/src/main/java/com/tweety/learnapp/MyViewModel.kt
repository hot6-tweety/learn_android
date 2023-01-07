package com.tweety.learnapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MyViewModel(_counter: Int, private val savedStateHandle: SavedStateHandle) : ViewModel() {
//    var counter = _counter
    var counter = savedStateHandle.get<Int>(SAVE_STATE_KEY) ?: _counter

    var liveCounter : MutableLiveData<Int> = MutableLiveData(_counter)
    val modifiedCounter : LiveData<String> = Transformations.map(liveCounter) { counter ->
        "LiveData 타입의 $counter 를 반환합니다"
    } // switchMap 함수는 매핑한 변수도 바꾼다...

    val hasChecked : MutableLiveData<Boolean> = MutableLiveData<Boolean>(false)
    fun saveState() {
        savedStateHandle.set(SAVE_STATE_KEY, counter)
    }

    companion object {
        private const val SAVE_STATE_KEY = "counter"
    }
}