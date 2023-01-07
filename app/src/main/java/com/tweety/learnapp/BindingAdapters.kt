package com.tweety.learnapp

import android.widget.ProgressBar
import androidx.databinding.BindingAdapter

@BindingAdapter(value = ["app:progressScaled", "android:max"], requireAll = true)
fun setProgress(progressBar: ProgressBar, counter: Int, max: Int) {
    // progressBar 는 View, counter 는 전달하려는 값
    progressBar.progress = (counter * 2).coerceAtMost(max)
}