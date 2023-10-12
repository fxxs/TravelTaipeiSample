package com.example.traveltaipei.ui.events

import android.net.Uri
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsIntent
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.traveltaipei.BaseFragment
import com.example.traveltaipei.pojo.BaseListItem
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class EventsFragment : BaseFragment() {
    override val viewModel: EventsViewModel by viewModels()

    override fun initListAdapter(): ListAdapter<BaseListItem, RecyclerView.ViewHolder> {
        return EventsAdapter {
            val url: String? = if (it.url.isNullOrEmpty().not()) {
                it.url
            } else {
                it.links?.firstOrNull { link ->
                    link.src.isNullOrEmpty().not()
                }?.src
            }

            if (url.isNullOrEmpty()) {
                Toast.makeText(requireContext(), "無法前往", Toast.LENGTH_SHORT).show()
            } else {
                CustomTabsIntent.Builder().build().launchUrl(requireActivity(), Uri.parse(url))
            }
        }
    }
}