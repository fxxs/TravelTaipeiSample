package com.example.traveltaipei

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.traveltaipei.databinding.FragmentCommonBinding
import com.example.traveltaipei.pojo.BaseListItem

abstract class BaseFragment : Fragment() {
    protected abstract val viewModel: BaseFeatureViewModel<*>
    private var _binding: FragmentCommonBinding? = null
    private val parentViewModel: MainViewModel by viewModels({ requireActivity() })
    private lateinit var listAdapter: ListAdapter<BaseListItem, RecyclerView.ViewHolder>
    private lateinit var linearLayoutManager: LinearLayoutManager

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentCommonBinding.inflate(inflater, container, false)

        listAdapter = initListAdapter()

        linearLayoutManager = LinearLayoutManager(
            binding.root.context,
            RecyclerView.VERTICAL,
            false
        )

        with(binding.root) {
            addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    DividerItemDecoration.VERTICAL
                )
            )

            layoutManager = linearLayoutManager
            adapter = listAdapter

            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    if (dy > 0) {
                        triggerContentLoadMoreByScrollIfNeeded();
                    }
                }
            })
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        parentViewModel.languageUpdated.observe(viewLifecycleOwner) {
            if (it) {
                viewModel.refresh()
            }
        }

        viewModel.immutableListLiveData.observe(viewLifecycleOwner) {
            listAdapter.submitList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /**
     * 滑動觸發的loadMore
     */
    private fun triggerContentLoadMoreByScrollIfNeeded() {
        val visibleItemCount: Int = linearLayoutManager.childCount
        var totalItemCount: Int = linearLayoutManager.itemCount
        val pastVisibleItems: Int = linearLayoutManager.findFirstVisibleItemPosition()
        if (viewModel.lastReceivedContentSize > 0) {
            // 資料總數 - 前次call api 拿到的資料數的1/3 = 滑動至新取得的資料數目的1/3的位置時會觸發loadMore
            totalItemCount -= viewModel.lastReceivedContentSize / 3
        }
        if (pastVisibleItems + visibleItemCount >= totalItemCount) {
            viewModel.loadMore()
        }
    }

    protected abstract fun initListAdapter(): ListAdapter<BaseListItem, RecyclerView.ViewHolder>
}