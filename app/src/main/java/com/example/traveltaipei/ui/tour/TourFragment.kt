package com.example.traveltaipei.ui.tour

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
class TourFragment : BaseFragment() {
    override val viewModel: TourViewModel by viewModels()

    override fun initListAdapter(): ListAdapter<BaseListItem, RecyclerView.ViewHolder> {
        return ToursAdapter {
            if (it.url.isNullOrEmpty()) {
                Toast.makeText(requireContext(), "無法前往", Toast.LENGTH_SHORT).show()
            } else {
                CustomTabsIntent.Builder().build().launchUrl(requireActivity(), Uri.parse(it.url))
            }
        }
    }
}