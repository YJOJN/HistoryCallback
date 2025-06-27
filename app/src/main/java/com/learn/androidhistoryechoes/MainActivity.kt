package com.learn.androidhistoryechoes

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.learn.androidhistoryechoes.databinding.ActivityMainBinding
import com.learn.androidhistoryechoes.view.adapter.HistoryEchoesAdapter
import com.learn.androidhistoryechoes.viewmodel.MainViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()
    private val adapter = HistoryEchoesAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val simpleDateFormat = SimpleDateFormat("MM月dd日", Locale.getDefault())
        val currentDate = simpleDateFormat.format(Date())
        binding.tvData.text = currentDate
        binding.rvHistoryEchoes.adapter = adapter
        adapter.setOnItemHistoryEchoesClickListener { view, model ->
            Toast.makeText(this, model.title, Toast.LENGTH_SHORT).show()
        }
        Log.i(TAG, binding.tvData.text.toString())
        mainViewModel.getHistoryEchoesList(binding.tvData.text.toString())
        mainViewModel.historyEchoesListLiveData.observe(this) {
            Log.i(TAG, it.toString())
            adapter.mData = it
        }
    }

    companion object {
        const val TAG = "MainActivity"
    }
}