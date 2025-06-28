package com.learn.androidhistoryechoes.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DataX(
    @SerialName("content")
    val content: String,
    @SerialName("date")
    val date: String,
    @SerialName("day")
    val day: Int,
    @SerialName("desc")
    val desc: String,
    @SerialName("id")
    val id: String,
    @SerialName("month")
    val month: Int,
    @SerialName("monthday")
    val monthday: String,
    @SerialName("title")
    val title: String,
    @SerialName("year")
    val year: Int
)