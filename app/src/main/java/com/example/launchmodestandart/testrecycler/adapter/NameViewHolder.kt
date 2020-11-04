package com.example.launchmodestandart.testrecycler.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.launchmodestandart.model.TestName
import kotlinx.android.synthetic.main.item_name.view.*

class NameViewHolder(private val listItemView: View) : RecyclerView.ViewHolder(listItemView) {

    fun bind(item: TestName) {
        listItemView.tvPosition.text = item.name
        if (item.name.toInt() % 10 == 0) {
            listItemView.tvPosition.visibility = View.GONE
        } else {
            listItemView.tvPosition.visibility = View.VISIBLE
        }
        listItemView.cbCheck.isChecked = item.isChecked
        listItemView.cbCheck.setOnCheckedChangeListener { buttonView, isChecked ->
            if (buttonView.isPressed) item.isChecked = isChecked
        }
    }

    fun updateCheckBox(item: TestName) {
        listItemView.cbCheck.isChecked = item.isChecked
    }

    fun updateTextView(item: TestName) {
        listItemView.tvPosition.text = item.name
    }
}