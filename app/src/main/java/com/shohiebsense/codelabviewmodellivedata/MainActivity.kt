package com.shohiebsense.codelabviewmodellivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.shohiebsense.codelabviewmodellivedata.adapter.WordAdapter
import com.shohiebsense.codelabviewmodellivedata.model.Word
import kotlinx.android.synthetic.main.activity_main.*
import com.shohiebsense.codelabviewmodellivedata.viewmodel.WordViewModel
import java.util.*


class MainActivity : AppCompatActivity() {

    lateinit var wordViewModel : WordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        wordViewModel = ViewModelProviders.of(this).get(WordViewModel::class.java)

        initRecyclerView()

        button_add.setOnClickListener {
            wordViewModel.insert(Word(UUID.randomUUID().toString()))
        }

    }

    fun initRecyclerView(){
        val adapter = WordAdapter(this)
        recycler_word.adapter = adapter
        recycler_word.layoutManager = LinearLayoutManager(this)

        wordViewModel.allWords.observe(this, object:  Observer<List<Word>>{
            override fun onChanged(t: List<Word>) {
                adapter.refresh(t)
            }

        })

    }
}
