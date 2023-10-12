package com.example.traveltaipei.ui.tour

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.traveltaipei.databinding.ItemAttractionShimmerBinding
import com.example.traveltaipei.databinding.ItemTourThemeBinding
import com.example.traveltaipei.pojo.BaseListItem
import com.example.traveltaipei.pojo.ItemViewType
import com.example.traveltaipei.pojo.ShimmerBO
import com.example.traveltaipei.pojo.TourThemeBO
import com.example.traveltaipei.ui.ShimmerViewHolder

class ToursAdapter(private val callback: (data: TourThemeBO) -> Unit) :
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
            return if (oldItem is TourThemeBO && newItem is TourThemeBO) {
                oldItem == newItem
            } else oldItem is ShimmerBO && newItem is ShimmerBO
        }
    }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == ItemViewType.NORMAL.ordinal) {
            return TourThemeViewHolder(
                ItemTourThemeBinding.inflate(
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
            (holder as TourThemeViewHolder).bind(getItem(position) as TourThemeBO)
        } else {
            (holder as ShimmerViewHolder).startShimmer()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).itemViewType.ordinal
    }

    inner class TourThemeViewHolder(
        private var binding: ItemTourThemeBinding,
        private val callback: (data: TourThemeBO) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TourThemeBO) {
            itemView.setOnClickListener {
                callback.invoke(item)
            }

            binding.title.text = item.title
            binding.content.text = item.description
            binding.season.text = String.format("Seasons：%s", item.seasons)
            binding.month.text = String.format("Months：%s", item.months)
        }
    }
}