package com.example.news.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.news.base.BaseDiffUtilItemCallback
import com.example.news.databinding.ItemSourcesBinding
import com.example.news.models.sources.SourcesNewItem

class SourcesAdapter :
    ListAdapter<SourcesNewItem, SourcesAdapter.SourcesViewHolder>(BaseDiffUtilItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SourcesViewHolder =
        SourcesViewHolder(
            ItemSourcesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: SourcesViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    class SourcesViewHolder(private val binding: ItemSourcesBinding) : ViewHolder(binding.root) {
        fun onBind(model: SourcesNewItem) {
            binding.tvName.text = model.name
            binding.tvDescription.text = model.description
            binding.tvLanguage.text = model.language
            binding.tvCategory.text = model.category
        }
    }
}
