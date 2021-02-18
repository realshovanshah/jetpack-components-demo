package com.realshovanshah.dynamicdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.realshovanshah.dynamicdemo.R
import com.realshovanshah.dynamicdemo.databinding.FragmentBookBinding
import com.realshovanshah.dynamicdemo.databinding.LayoutBookBinding
import com.realshovanshah.dynamicdemo.model.BookDetail
import kotlinx.android.synthetic.main.layout_book.view.*

class RecyclerViewAdapter(private val items: ArrayList<BookDetail>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    lateinit var binding: LayoutBookBinding


    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val book = items[position] // this will be the list object you created
        holder.bind(book)
    }

    class ViewHolder private constructor(private val binding: LayoutBookBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(book: BookDetail) {
            binding.book= book
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = LayoutBookBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }

}
