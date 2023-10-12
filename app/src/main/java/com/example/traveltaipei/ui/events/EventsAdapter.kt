package com.example.traveltaipei.ui.events

import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.text.HtmlCompat.FROM_HTML_MODE_LEGACY
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.traveltaipei.databinding.ItemAttractionShimmerBinding
import com.example.traveltaipei.databinding.ItemEventActivityBinding
import com.example.traveltaipei.pojo.BaseListItem
import com.example.traveltaipei.pojo.EventActivityBO
import com.example.traveltaipei.pojo.ItemViewType
import com.example.traveltaipei.pojo.ShimmerBO
import com.example.traveltaipei.ui.ShimmerViewHolder

class EventsAdapter(private val callback: (data: EventActivityBO) -> Unit) :
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
            return if (oldItem is EventActivityBO && newItem is EventActivityBO) {
                oldItem == newItem
            } else oldItem is ShimmerBO && newItem is ShimmerBO
        }
    }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == ItemViewType.NORMAL.ordinal) {
            return EventActivityViewHolder(
                ItemEventActivityBinding.inflate(
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
            (holder as EventActivityViewHolder).bind(getItem(position) as EventActivityBO)
        } else {
            (holder as ShimmerViewHolder).startShimmer()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).itemViewType.ordinal
    }

    inner class EventActivityViewHolder(
        private var binding: ItemEventActivityBinding,
        private val callback: (data: EventActivityBO) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: EventActivityBO) {
            itemView.setOnClickListener {
                callback.invoke(item)
            }

            binding.title.text = item.title
            binding.content.text = Html.fromHtml(item.description, FROM_HTML_MODE_LEGACY)
        }
    }
}