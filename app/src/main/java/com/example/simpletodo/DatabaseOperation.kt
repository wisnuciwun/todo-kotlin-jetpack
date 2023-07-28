package com.example.simpletodo
import android.content.ContentValues
import android.content.Context
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Date

class DatabaseOperation(context: Context) {
    private val databaseHelper = DatabaseHelper(context)
    fun insertNewNote(note: Note){
        val contentValues = ContentValues().apply {
            put("content", note.content)
            put("date", note.date)
            put("done", note.done)
        }

        val db = databaseHelper.writableDatabase
        db.insert("items", null, contentValues)
        db.close()
    }

    fun getNotes(): List<Note>{
        val notes = mutableListOf<Note>()
        val db = databaseHelper.readableDatabase
        val cursor = db.query("items", null, null, null, null, null, null)
        while (cursor.moveToNext()) {
            val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
            val content = cursor.getString(cursor.getColumnIndexOrThrow("content"))
            val date = cursor.getString(cursor.getColumnIndexOrThrow("date"))
            val done = cursor.getInt(cursor.getColumnIndexOrThrow("done"))
            notes.add(Note(id,date,content,done))
        }
        cursor.close()
        db.close()
        return notes
    }

    fun deleteNote(id: Int){
        val db = databaseHelper.writableDatabase
        db.delete("items", "id = ?", arrayOf(id.toString()))
        db.close()
    }

    fun updateNote(newNote: Note){
        val contentValues = ContentValues().apply {
            put("content", newNote.content)
            put("date", newNote.date)
            put("done", newNote.done)
        }

        val db = databaseHelper.writableDatabase
        db.update("items", contentValues, "id = ?", arrayOf(newNote.id.toString()))
        db.close()
    }
}