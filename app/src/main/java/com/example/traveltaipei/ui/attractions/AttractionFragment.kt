package com.example.traveltaipei.ui.attractions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.traveltaipei.databinding.FragmentAttractionBinding
import com.example.traveltaipei.pojo.AttractionBO
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AttractionFragment : Fragment() {
    private var _binding: FragmentAttractionBinding? = null

    private lateinit var attraction: AttractionBO

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args: AttractionFragmentArgs by navArgs()
        attraction = args.attraction
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentAttractionBinding.inflate(inflater, container, false)
        val root: View = binding.root

        with(binding.imgViewpager) {
            adapter = AttractionImageViewPagerAdapter(attraction.images ?: emptyList())
        }

        with(binding.toolbarLayout) {
            title = attraction.name
        }

        with(binding.content) {
            text = attraction.introduction
        }

        with(binding.address) {
            text = attraction.address
        }

        with(binding.url) {
            text = attraction.officialSite ?: attraction.url
        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    findNavController().popBackStack()
                }
            })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}