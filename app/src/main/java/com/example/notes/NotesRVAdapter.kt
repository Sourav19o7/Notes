package com.example.notes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesRVAdapter(private val context: Context,private val listener: INotesRVAdapter): RecyclerView.Adapter<NotesRVAdapter.NoteViewHolder>() {

    private val allNotes = ArrayList<Note>()
    inner class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val textview: TextView = itemView.findViewById<TextView>(R.id.text)
        val deleteButton: ImageView = itemView.findViewById<ImageView>(R.id.deleteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val viewHolder = NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false))
        viewHolder.deleteButton.setOnClickListener {
            listener.onItemCLicked(allNotes[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = allNotes[position]
        holder.textview.text = currentNote.text
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    fun updateList(newList: List<Note>)
    {
        allNotes.clear()
        allNotes.addAll(newList)

        notifyDataSetChanged()
    }
}

interface INotesRVAdapter{
    fun onItemCLicked(note: Note)
}