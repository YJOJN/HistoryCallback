package com.learn.androidhistoryechoes.view.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.scopeNetLife
import com.drake.net.Get
import com.drake.net.utils.scopeNetLife
import com.learn.androidhistoryechoes.R
import com.learn.androidhistoryechoes.databinding.ActivityHistoryEchoesDetailBinding
import com.learn.androidhistoryechoes.model.HistoryEchoes
import com.learn.androidhistoryechoes.model.HistoryEchoesDetailModel
import com.learn.androidhistoryechoes.network.Api
import okhttp3.internal.applyConnectionSpec

class HistoryEchoesDetailActivity : AppCompatActivity() {
    private lateinit var id: String
    private lateinit var binding: ActivityHistoryEchoesDetailBinding
    companion object {
        fun start(context: Context, id: String) {
            val intent = Intent(context, HistoryEchoesDetailActivity::class.java)
            intent.putExtra("id", id)
            context.startActivity(intent)
        }

        const val TAG = "HistoryEchoesDetailActivity"
    }
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryEchoesDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        id = intent.getStringExtra("id")!!
        scopeNetLife {
            val model = Get<HistoryEchoesDetailModel>(Api.HISTORY_ECHOES_DETAIL) {
                param("id", id)
            }.await()
            binding.tvYear.text = model.data.year.toString()
            binding.tvDate.text = "${model.data.month}月${model.data.day}日"
            binding.tvTitle.text = model.data.title
            binding.tvContent.text = model.data.content
            Log.i(TAG, model.data.content)
        }

    }
}