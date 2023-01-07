package com.tweety.learnapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tweety.learnapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
/*
        var counter = 100
        binding.textView.text = counter.toString()

        binding.button.setOnClickListener {
            counter += 1
            binding.textView.text = counter.toString()
        }
*/

/*      // ViewModel
        // ViewModelProvider 는 싱글톤이고 초기값 전달 불가
        val myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        // 액티비티가 재구성 될 때마다 값 할당
        myViewModel.counter = 100

        binding.textView.text = myViewModel.counter.toString()

        binding.button.setOnClickListener {
            myViewModel.counter += 1
            binding.textView.text = myViewModel.counter.toString()
        }
*/
        // ViewModel Factory
        val factory = MyViewModelFactory(100)
        val myViewModel = ViewModelProvider(this, factory).get(MyViewModel::class.java)
        binding.textView.text = myViewModel.counter.toString()

        binding.button.setOnClickListener {
            myViewModel.counter += 1
            binding.textView.text = myViewModel.counter.toString()
        }
    }
}