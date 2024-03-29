package com.example.notes

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(note : Note)

    @Delete
    fun delete(note : Note)

    @Query("Select * from NOTES_TABLE order by id ASC")
    fun getAllNotes() : LiveData<List<Note>>
}