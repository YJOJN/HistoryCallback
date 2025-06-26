package com.learn.androidhistoryechoes

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.learn.androidhistoryechoes.databinding.ActivityMainBinding
import com.learn.androidhistoryechoes.viewmodel.MainViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val simpleDateFormat = SimpleDateFormat("MM月dd日", Locale.getDefault())
        val currentDate = simpleDateFormat.format(Date())
        binding.tvData.text = currentDate

        mainViewModel.getHistoryEchoesList(binding.tvData.text.toString())
        mainViewModel.historyEchoesListLiveData.observe(this) {
            Log.i(TAG, it.toString())
        }
    }

    companion object {
        const val TAG = "MainActivity"
    }
}