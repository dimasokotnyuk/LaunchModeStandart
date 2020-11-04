package com.example.launchmodestandart.testrecycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.launchmodestandart.R
import com.example.launchmodestandart.model.TestName


class NameAdapter : RecyclerView.Adapter<NameViewHolder>() {

    var data: MutableList<TestName> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder =
        NameViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_name, parent, false)
        )

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun onBindViewHolder(
        holder: NameViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        super.onBindViewHolder(holder, position, payloads)
        when {
            payloads.any {  it.toString() == "KEY_CHECK_BOX" } -> {
                holder.updateCheckBox(data[position])
            }
            payloads.any { it.toString() == "KEY_TEXT_VIEW" } -> {
                holder.updateTextView(data[position])
            }
            else -> {
                super.onBindViewHolder(holder, position, payloads)
            }
        }
    }

    fun updateItemAt(pos: Int, name: String) {
        data[pos].name = name
        notifyItemChanged(pos, "KEY_TEXT_VIEW")
    }

    override fun getItemCount(): Int = data.size
}