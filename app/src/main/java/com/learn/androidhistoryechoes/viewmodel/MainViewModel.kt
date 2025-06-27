package com.learn.androidhistoryechoes.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.scopeNetLife
import com.drake.net.Get
import com.learn.androidhistoryechoes.model.Data
import com.learn.androidhistoryechoes.model.HistoryEchoes
import com.learn.androidhistoryechoes.network.Api

class MainViewModel: ViewModel() {
     val historyEchoesListLiveData = MutableLiveData<List<Data>>()
     fun getHistoryEchoesList(time: String) {
          val pair = extractMonthAndDay(time)
          val month = pair.first
          val day = pair.second
          scopeNetLife {
               val model = Get<HistoryEchoes>(Api.HISTORY_ECHOES) {
                    param("month", 6)
                    param("day", 26)
//                    param("month", month)
//                    param("day", day)
               }.await()
               historyEchoesListLiveData.postValue(model.data)
          }
     }

     private fun extractMonthAndDay(time: String): Pair<Int, Int> {
          val list = time.split("月", "日")
          val month = list[0].toInt()
          val day = list[1].toInt()
          return Pair(month, day)
     }
}