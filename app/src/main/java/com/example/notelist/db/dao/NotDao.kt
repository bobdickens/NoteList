package com.example.notelist.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.notelist.model.NoteModel

@Dao
interface NotDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(noteModel: NoteModel)

    @Delete
    suspend fun delete(noteModel: NoteModel)

    @Query("SELECT * from note_table")
    fun getAllNotes(): LiveData<List<NoteModel>>
}