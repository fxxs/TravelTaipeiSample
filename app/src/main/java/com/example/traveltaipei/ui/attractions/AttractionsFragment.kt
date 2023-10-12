package com.example.traveltaipei.ui.attractions

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.traveltaipei.BaseFragment
import com.example.traveltaipei.pojo.BaseListItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AttractionsFragment : BaseFragment() {
    override val viewModel: AttractionsViewModel by viewModels()

    override fun initListAdapter(): ListAdapter<BaseListItem, RecyclerView.ViewHolder> {
        return AttractionsAdapter {
            findNavController().navigate(
                AttractionsFragmentDirections.actionAttractionsToAttraction(
                    attraction = it
                )
            )
        }
    }
}