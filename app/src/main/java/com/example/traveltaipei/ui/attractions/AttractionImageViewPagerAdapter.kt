package com.example.traveltaipei.ui.attractions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.traveltaipei.databinding.ItemAttractionImageBinding

class AttractionImageViewPagerAdapter(private val images: List<String>) :
    RecyclerView.Adapter<AttractionImageViewPagerAdapter.ImageViewHolder>() {

    override fun getItemCount(): Int = images.size

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): AttractionImageViewPagerAdapter.ImageViewHolder {
        return ImageViewHolder(
            ItemAttractionImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(images[position])
    }

    inner class ImageViewHolder(
        private val binding: ItemAttractionImageBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(image: String) {
            binding.image.load(image)
        }
    }
}