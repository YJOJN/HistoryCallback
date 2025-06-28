package com.learn.androidhistoryechoes

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.MaterialDatePicker
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
    private var selectedDateTime = System.currentTimeMillis()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val simpleDateFormat = SimpleDateFormat("MM月dd日", Locale.getDefault())
        val currentDate = simpleDateFormat.format(Date())
        binding.tvData.text = currentDate
        binding.tvData.setOnClickListener {
            showDatePickerDialog()
        }
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

    private fun showDatePickerDialog() {
        val picker = MaterialDatePicker.Builder.datePicker()
            .setTitleText("选择日期")
            .setSelection(selectedDateTime)
            .build()
        picker.addOnPositiveButtonClickListener {
            val simpleDateFormat = SimpleDateFormat("MM月dd日", Locale.getDefault())
            val selectedDate = simpleDateFormat.format(it)
            mainViewModel.getHistoryEchoesList(selectedDate)
            binding.tvData.text = selectedDate
            selectedDateTime = it
        }
        picker.show(supportFragmentManager, "DATE_PICKER")
    }

    companion object {
        const val TAG = "MainActivity"
    }
}