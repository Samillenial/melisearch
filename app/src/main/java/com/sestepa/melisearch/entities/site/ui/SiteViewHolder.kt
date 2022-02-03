package com.sestepa.melisearch.entities.site.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.sestepa.melisearch.R
import com.sestepa.melisearch.core.setFlag
import com.sestepa.melisearch.databinding.ItemSiteBinding
import com.sestepa.melisearch.entities.site.domain.SiteData
import java.security.InvalidParameterException

class SiteViewHolder(view: View): RecyclerView.ViewHolder(view) {

	private val binding = ItemSiteBinding.bind(view)

	fun render(site: SiteData, onClickListener: (SiteData) -> Unit) {
		binding.siteName.text = site.name
		binding.flagImage.setFlag(site.id)
		itemView.setOnClickListener { onClickListener(site) }
	}
}
