package com.shohiebsense.codelabviewmodellivedata.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.shohiebsense.codelabviewmodellivedata.model.Word
import com.shohiebsense.codelabviewmodellivedata.repository.WordRepository

class WordViewModel(app : Application) : AndroidViewModel(app) {

    val repository = WordRepository(app)
    val allWords = repository.allWords

    fun insert(word : Word){
        repository.insert(word)
    }


}