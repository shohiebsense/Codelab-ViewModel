package com.shohiebsense.codelabviewmodellivedata.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shohiebsense.codelabviewmodellivedata.R
import com.shohiebsense.codelabviewmodellivedata.model.Word
import kotlinx.android.synthetic.main.item_word.view.*

class WordAdapter(val context : Context): RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    val inflater = LayoutInflater.from(context)
    var words = arrayListOf<Word>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val itemView = inflater.inflate(R.layout.item_word, parent, false)
        return WordViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return words.size
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val word = words[position]
        holder.view.text_word_name.setText(word.word)
    }

    fun refresh(words : List<Word>){
        this.words.clear()
        this.words.addAll(words)
        notifyDataSetChanged()
    }

    inner class WordViewHolder(val view : View) : RecyclerView.ViewHolder(view) {

    }
}