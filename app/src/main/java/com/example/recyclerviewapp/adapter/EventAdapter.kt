package com.example.recyclerviewapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewapp.R
import com.example.recyclerviewapp.models.Event
import kotlin.math.E

class EventAdapter(
    private val evenlist: MutableList<Event> = mutableListOf(),
    private val onEventClicked: (Event) -> Unit
): RecyclerView.Adapter<EventViewHolder>() {

    fun updateEventData(newEvent: Event){
        evenlist.add(newEvent)
        notifyItemInserted(0)
    }

    //Creating view holder that holds views to be bound
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {

        //inflating EVENT ITEM coming from the XML file
        val eventView = LayoutInflater.from(parent.context).inflate(R.layout.event_item, parent, false)
        return EventViewHolder(eventView, onEventClicked)
    }
    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = evenlist[position]
        holder.bind(event)
    }
    override fun getItemCount(): Int = evenlist.size
}


class EventViewHolder(
    itemView: View,
    private val onEventClicked: (Event) -> Unit
) : RecyclerView.ViewHolder(itemView){

    private val title: TextView = itemView.findViewById(R.id.event_title)
    private val category: TextView = itemView.findViewById(R.id.event_category)
    private val date: TextView = itemView.findViewById(R.id.event_date)

    fun bind(event: Event) {
        title.text = event.title
        category.text = event.category
        date.text = event.date

        itemView.setOnClickListener {
            onEventClicked.invoke(event)

        }
    }
}