package com.example.notes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesRVAdapter(val context: Context): RecyclerView.Adapter<NotesRVAdapter.NoteViewHolder>() {

    val allNotes = ArrayList<Note>()
    inner class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val textview = itemView.findViewById<TextView>(R.id.text)
        val deleteButton = itemView.findViewById<ImageView>(R.id.deleteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val viewHolder = NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false))

        return viewHolder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return allNotes.size
    }
}