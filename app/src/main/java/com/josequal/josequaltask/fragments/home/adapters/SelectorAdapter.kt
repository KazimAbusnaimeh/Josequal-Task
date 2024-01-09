package com.josequal.josequaltask.fragments.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.josequal.josequaltask.databinding.RowSelectorBinding
import com.josequal.josequaltask.donmain.SelectorModel

class SelectorAdapter :
    ListAdapter<SelectorModel, SelectorAdapter.SelectorViewHolder>(SelectorDiffUtil()) {

    private var indexLastSelected = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectorViewHolder {
        val binding = RowSelectorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SelectorViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SelectorViewHolder, position: Int) {
        holder.bind(getItem(position), position)
    }

    inner class SelectorViewHolder(private val binding: RowSelectorBinding) :
        ViewHolder(binding.root) {
        fun bind(selector: SelectorModel, position: Int) {
            binding.data = selector
            binding.clSelectorItem.setOnClickListener {
                if (position != indexLastSelected) {
                        getItem(indexLastSelected).isSelected = false
                }

                indexLastSelected = position
                getItem(position).isSelected = true
                notifyDataSetChanged()
            }
        }
    }

    class SelectorDiffUtil : DiffUtil.ItemCallback<SelectorModel>() {
        override fun areItemsTheSame(oldItem: SelectorModel, newItem: SelectorModel): Boolean {
            return newItem.id == oldItem.id
        }

        override fun areContentsTheSame(oldItem: SelectorModel, newItem: SelectorModel): Boolean {
            return newItem == oldItem
        }

    }
}