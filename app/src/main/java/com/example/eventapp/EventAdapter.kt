package com.example.eventapp
import androidx. recyclerview. widget. RecyclerView
import android.view.View
import android.widget.TextView
import android.view.ViewGroup
import android.view.LayoutInflater

class EventAdapter(private var eventList: List<Event>) :
    RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    inner class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.eventName)
        val locationTextView: TextView = itemView.findViewById(R.id.eventLocation)
        val dateTextView: TextView = itemView.findViewById(R.id.eventDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_event, parent, false)
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = eventList[position]
        holder.nameTextView.text = event.name
        holder.locationTextView.text = event.location
        holder.dateTextView.text = event.date
    }

    override fun getItemCount(): Int {
        return eventList.size
    }


    fun filterList(filteredEvents: List<Event>) {
        eventList = filteredEvents
        notifyDataSetChanged()
    }
    fun updateList(newList: ArrayList<Event>) {
        eventList = newList
        notifyDataSetChanged()
    }
}
