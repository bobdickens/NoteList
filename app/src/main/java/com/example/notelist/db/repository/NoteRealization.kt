package com.example.notelist.db.repository

import androidx.lifecycle.LiveData
import com.example.notelist.db.dao.NotDao
import com.example.notelist.model.NoteModel

class NoteRealization(private val noteDao: NotDao): NoteRepository {
    override val allNotes: LiveData<List<NoteModel>>
        get() = noteDao.getAllNotes()

    override suspend fun insertNote(noteModel: NoteModel, onSuccess: () -> Unit) {
       noteDao.insert(noteModel)
        onSuccess()
    }

    override suspend fun deleteNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.delete(noteModel)
        onSuccess()
    }
}