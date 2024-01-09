package com.josequal.josequaltask.fragments.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.josequal.josequaltask.databinding.RowContactBinding
import com.josequal.josequaltask.donmain.ContactsAndSeasModel

class ContactsAdapter :
    ListAdapter<ContactsAndSeasModel, ContactsAdapter.ContactsViewHolder>(ContactsDiffUtil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        val binding = RowContactBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ContactsViewHolder(private val binding: RowContactBinding) :
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