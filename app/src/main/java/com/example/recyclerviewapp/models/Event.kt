package com.example.recyclerviewapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Event (
    val title: String,
    val category: String,
    val date: String
    ) : Parcelable

object SingletonEvent {
    var eventList: MutableList<Event> = mutableListOf()
}
