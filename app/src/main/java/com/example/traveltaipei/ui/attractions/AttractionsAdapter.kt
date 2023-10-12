package com.example.traveltaipei.ui.attractions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.traveltaipei.databinding.ItemAttractionBinding
import com.example.traveltaipei.databinding.ItemAttractionShimmerBinding
import com.example.traveltaipei.pojo.AttractionBO
import com.example.traveltaipei.pojo.BaseListItem
import com.example.traveltaipei.pojo.ShimmerBO
import com.example.traveltaipei.pojo.ItemViewType
import com.example.traveltaipei.ui.ShimmerViewHolder

class AttractionsAdapter(private val callback: (data: AttractionBO) -> Unit) :
    ListAdapter<BaseListItem, RecyclerView.ViewHolder>(object :
        DiffUtil.ItemCallback<BaseListItem>() {
        override fun areItemsTheSame(
            oldItem: BaseListItem,
            newItem: BaseListItem,
        ): Boolean {
            return oldItem.itemViewType == newItem.itemViewType
        }

        override fun areContentsTheSame(
            oldItem: BaseListItem,
            newItem: BaseListItem,
        ): Boolean {
            return if (oldItem is AttractionBO && newItem is AttractionBO) {
                oldItem == newItem
            } else oldItem is ShimmerBO && newItem is ShimmerBO
        }
    }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == ItemViewType.NORMAL.ordinal) {
            return AttractionViewHolder(
                ItemAttractionBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ),
                callback
            )
        } else {
            return ShimmerViewHolder(
                ItemAttractionShimmerBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ).root
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewType = getItemViewType(position)

        if (viewType == ItemViewType.NORMAL.ordinal) {
            (holder as AttractionViewHolder).bind(getItem(position) as AttractionBO)
        } else {
            (holder as ShimmerViewHolder).startShimmer()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).itemViewType.ordinal
    }

    inner class AttractionViewHolder(
        private var binding: ItemAttractionBinding,
        private val callback: (data: AttractionBO) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(attraction: AttractionBO) {
            itemView.setOnClickListener {
                callback.invoke(attraction)
            }

            if (attraction.images.isNullOrEmpty().not()) {
                binding.img.load(attraction.images!![0])
            }
            binding.title.text = attraction.name
            binding.content.text = attraction.introduction
        }
    }
}