package com.learn.androidhistoryechoes.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HistoryEchoes(
    @SerialName("code")
    val code: Int,
    @SerialName("data")
    val `data`: List<Data>,
    @SerialName("message")
    val message: String,
    @SerialName("request_id")
    val requestId: String,
    @SerialName("success")
    val success: Boolean,
    @SerialName("time")
    val time: Int,
    @SerialName("usage")
    val usage: Int
)