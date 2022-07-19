package com.example.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), INotesRVAdapter {

    lateinit var viewModel: NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView : RecyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = NotesRVAdapter(this, this)
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).
        get(NoteViewModel::class.java)

        viewModel.allNotes.observe(this, Observer {list->
            list?.let {
                adapter.updateList(it)
            }

        })


    }

    override fun onItemCLicked(note: Note) {
        viewModel.deleteNote(note)
        Toast.makeText(this, "Deleted", Toast.LENGTH_LONG).show()
    }

    fun submitData(view: View) {
        Log.i("Failure", "45")
        val noteText = findViewById<TextView>(R.id.input).text.toString()
        Log.i("Failure", "47")
        if(noteText.isNotEmpty())
        {
            Log.i("Failure", "50")
            viewModel.insertNote(Note(noteText))
            Toast.makeText(this, "Inserted", Toast.LENGTH_LONG).show()
            findViewById<TextView>(R.id.input).text = ""
        }
    }
}