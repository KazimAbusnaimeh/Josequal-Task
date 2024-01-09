package com.josequal.josequaltask.fragments.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.josequal.josequaltask.databinding.RowSeaBinding
import com.josequal.josequaltask.donmain.ContactsAndSeasModel

class SeasAdapter :
    ListAdapter<ContactsAndSeasModel, SeasAdapter.SeasViewHolder>(ContactsDiffUtil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeasViewHolder {
        val binding = RowSeaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SeasViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SeasViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class SeasViewHolder(private val binding: RowSeaBinding) :
        ViewHolder(binding.root) {
        fun bind(contact: ContactsAndSeasModel) {
            binding.data = contact
        }
    }

    class ContactsDiffUtil : DiffUtil.ItemCallback<ContactsAndSeasModel>() {
        override fun areItemsTheSame(
            oldItem: ContactsAndSeasModel,
            newItem: ContactsAndSeasModel
        ): Boolean {
            return newItem.id == oldItem.id
        }

        override fun areContentsTheSame(
            oldItem: ContactsAndSeasModel,
            newItem: ContactsAndSeasModel
        ): Boolean {
            return newItem == oldItem
        }

    }
}