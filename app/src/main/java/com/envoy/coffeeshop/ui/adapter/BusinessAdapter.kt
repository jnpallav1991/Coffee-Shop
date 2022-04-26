package com.envoy.coffeeshop.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.envoy.coffeeshop.data.model.Businesse
import com.envoy.coffeeshop.databinding.AdapterBusinessBinding
import javax.inject.Inject

class BusinessAdapter @Inject constructor() :
    PagingDataAdapter<Businesse, BusinessAdapter.BusinessViewHolder>(BusinesseComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BusinessViewHolder(
            AdapterBusinessBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: BusinessViewHolder, position: Int) {
        getItem(position)?.let { holder.bindItems(it) }
    }

    inner class BusinessViewHolder(private val binding: AdapterBusinessBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindItems(result: Businesse) = with(binding) {
//            Glide.with(itemView.context).load(result.image_url)
//                //.placeholder(R.drawable.default_image)
//                //.error(R.drawable.default_image)
//                .into(binding.imageview)
//            binding.txtShop.text = result.name
//            binding.txtLocation.text = result.location.city
//            binding.txtPrice.text = result.price
//            binding.txtRating.text = result.rating.toString()
            businesse = result
        }

    }

    object BusinesseComparator : DiffUtil.ItemCallback<Businesse>() {
        override fun areItemsTheSame(oldItem: Businesse, newItem: Businesse) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Businesse, newItem: Businesse) =
            oldItem == newItem
    }
}