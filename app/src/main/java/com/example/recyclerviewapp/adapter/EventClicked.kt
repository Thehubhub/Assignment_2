package com.example.recyclerviewapp.adapter

import com.example.recyclerviewapp.models.Event

interface EventClicked {
    fun onEventClicked(evenlist: Event){
    }
}