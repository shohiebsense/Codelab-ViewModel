package com.shohiebsense.codelabviewmodellivedata.repository

import android.app.Application
import android.os.AsyncTask
import com.shohiebsense.codelabviewmodellivedata.db.WordRoomDatabase
import com.shohiebsense.codelabviewmodellivedata.model.Word

class WordRepository(app : Application) {
    val db = WordRoomDatabase.getDatabase(app)
    val wordDao = db.wordDao()
    val allWords = wordDao.getAllWords()

    fun insert(word : Word){
        InsertAsyncTask().execute(word)
    }

    inner class InsertAsyncTask : AsyncTask<Word, Boolean, Boolean>() {
        override fun doInBackground(vararg p0: Word): Boolean {
            wordDao.insert(p0[0])
            return true
        }

    }


}