package com.learn.androidhistoryechoes.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HistoryEchoesDetailModel(
    @SerialName("code")
    val code: Int,
    @SerialName("data")
    val `data`: DataX,
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