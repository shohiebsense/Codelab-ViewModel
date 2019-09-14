package com.shohiebsense.codelabviewmodellivedata.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Word(
    @PrimaryKey
    @ColumnInfo(name = "word")
    val word : String) {

}