package com.josequal.josequaltask.fragments.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.josequal.josequaltask.databinding.RowInformationBinding
import com.josequal.josequaltask.donmain.InformationModel

class InformationAdapter :
    ListAdapter<InformationModel, InformationAdapter.InformationViewHolder>(InformationDiffUtil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InformationViewHolder {
        val binding =
            RowInformationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return InformationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: InformationViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class InformationViewHolder(private val binding: RowInformationBinding) :
        ViewHolder(binding.root) {
        fun bind(info: InformationModel) {
            binding.data = info
        }
    }

    class InformationDiffUtil : DiffUtil.ItemCallback<InformationModel>() {
        override fun areItemsTheSame(
            oldItem: InformationModel,
            newItem: InformationModel
        ): Boolean {
            return newItem.id == oldItem.id
        }

        override fun areContentsTheSame(
            oldItem: InformationModel,
            newItem: InformationModel
        ): Boolean {
            return newItem == oldItem
        }
    }
}