package com.tweety.learnapp

// https://developer.android.com/topic/libraries/architecture/viewmodel
// https://developer.android.com/topic/libraries/architecture/saving-states.html#options

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.tweety.learnapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(binding.root)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

//        var counter = 100
//        binding.textView.text = counter.toString()
//
//        binding.button.setOnClickListener {
//            counter += 1
//            binding.textView.text = counter.toString()
//        }

//        ViewModelProvider 는 싱글톤이고 초기값 전달 불가
//        val myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)

//        액티비티가 재구성 될 때마다 값 할당
//        myViewModel.counter = 100

//        binding.textView.text = myViewModel.counter.toString()
//
//        binding.button.setOnClickListener {
//            myViewModel.counter += 1
//            binding.textView.text = myViewModel.counter.toString()
//        }

//        ViewModel Factory 팩토리 패턴으로 뷰모델에 초기값 적용
        val myRepositoryImpl = MyRepositoryImpl(10)
        val factory = MyViewModelFactory(10, myRepositoryImpl,this)
//        val myViewModel = ViewModelProvider(this, factory).get(MyViewModel::class.java)
        val myViewModel by viewModels<MyViewModel> { factory }
//        ActivityViewModelLazy, FragmentViewModelLazy

        binding.lifecycleOwner = this
        binding.viewmodel = myViewModel
        binding.textView.text = myViewModel.counter.toString()

        binding.button.setOnClickListener {
//            myViewModel.counter += 1
//            binding.textView.text = myViewModel.counter.toString()
//            myViewModel.saveState()

//            myViewModel.liveCounter.value = myViewModel.liveCounter.value?.plus(1)

            myViewModel.increaseCounter()
        }

        // 라이브데이터 옵저빙
//        myViewModel.modifiedCounter.observe(this) { counter ->
//            binding.textView.text = counter.toString()
//        }

        // 라이브데이터 값 변경
//        myViewModel.modifiedCounter.observe(this) { counter ->
//            binding.textView.text = counter.toString()
//        }


    }
}