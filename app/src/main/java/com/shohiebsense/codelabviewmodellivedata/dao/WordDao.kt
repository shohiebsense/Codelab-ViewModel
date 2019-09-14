package com.shohiebsense.codelabviewmodellivedata.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.shohiebsense.codelabviewmodellivedata.model.Word

@Dao
interface WordDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(word : Word)

    @Update
    fun update(word : Word)

    @Query("DELETE FROM word")
    fun deleteAll()

    @Query("SELECT * FROM Word ORDER BY word ASC")
    fun getAllWords() : LiveData<List<Word>>



}