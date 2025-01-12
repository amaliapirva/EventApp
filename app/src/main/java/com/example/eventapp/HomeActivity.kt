package com.example.eventapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.eventapp.R
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.SearchView


class HomeActivity : AppCompatActivity() {
    private lateinit var eventAdapter: EventAdapter
    private lateinit var eventList: ArrayList<Event>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)


        eventList = arrayListOf(
            Event("Concert Rock", "Arena Nationala", "12 Jan 2025"),
            Event("Art Expo", "City Museum", "15 Jan 2025"),
            Event("Tech Meetup", "Tech Hub", "20 Jan 2025")
        )

        eventAdapter = EventAdapter(eventList)
        recyclerView.adapter = eventAdapter

        val searchView = findViewById<SearchView>(R.id.searchView)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                filterEvents(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterEvents(newText)
                return true
            }
        })
    }

    private fun filterEvents(query: String?) {
        val filteredList = if (query.isNullOrEmpty()) {
            eventList
        } else {
            eventList.filter {
                it.name.contains(query, ignoreCase = true) ||
                        it.location.contains(query, ignoreCase = true)
            }
        }
        eventAdapter.updateList(ArrayList(filteredList))
    }

    fun goBack(view: View) {
        onBackPressed()
    }

}
