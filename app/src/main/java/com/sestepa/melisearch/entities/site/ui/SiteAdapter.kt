package com.sestepa.melisearch.entities.site.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sestepa.melisearch.R
import com.sestepa.melisearch.entities.site.domain.SiteData

class SiteAdapter(private val siteDataList: List<SiteData>, private val onClickListener: (SiteData) -> Unit): RecyclerView.Adapter<SiteViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
		SiteViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_site, parent, false))

	override fun onBindViewHolder(holder: SiteViewHolder, position: Int) = holder.render(siteDataList[position], onClickListener)

	override fun getItemCount() = siteDataList.size
}
