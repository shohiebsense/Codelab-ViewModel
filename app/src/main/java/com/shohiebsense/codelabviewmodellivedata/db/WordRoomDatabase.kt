package com.shohiebsense.codelabviewmodellivedata.db

import android.content.Context
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.shohiebsense.codelabviewmodellivedata.dao.WordDao
import com.shohiebsense.codelabviewmodellivedata.model.Word
import android.icu.lang.UCharacter.GraphemeClusterBreak.V
import android.os.AsyncTask
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase
import com.shohiebsense.codelabviewmodellivedata.repository.WordRepository


@Database(entities = [Word::class], version = 1, exportSchema = false)
abstract class WordRoomDatabase(): RoomDatabase() {

    companion object {
        var INSTANCE : WordRoomDatabase? = null
        fun getDatabase(context : Context) : WordRoomDatabase{
            if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder(context.applicationContext,
                    WordRoomDatabase::class.java, "word_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomDatabaseCallback)
                    .build()
            }
            return INSTANCE!!
        }
        val roomDatabaseCallback = object : RoomDatabase.Callback() {
            override fun onOpen(db: SupportSQLiteDatabase) {
                PopulateDbAsyncTask().execute()
            }
        }


        class PopulateDbAsyncTask : AsyncTask<Boolean, Boolean, Boolean>(){
            val words = arrayListOf<String>("Me","You","Love")
            override fun doInBackground(vararg p0: Boolean?): Boolean {
                INSTANCE?.wordDao()?.deleteAll()
                words.forEach {
                    INSTANCE?.wordDao()?.insert(Word(it))
                }
                return true
            }

        }

    }





    abstract fun wordDao() : WordDao



}