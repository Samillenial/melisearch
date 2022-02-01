package com.sestepa.melisearch.entities.site.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.sestepa.melisearch.R
import com.sestepa.melisearch.databinding.ItemSiteBinding
import com.sestepa.melisearch.entities.site.domain.SiteData
import java.security.InvalidParameterException

class SiteViewHolder(view: View): RecyclerView.ViewHolder(view) {

	private val binding = ItemSiteBinding.bind(view)

	fun render(site: SiteData, onClickListener: (SiteData) -> Unit) {
		binding.siteName.text = site.name
		binding.flagImage.setImageResource(getFlagResource(site.id))
		itemView.setOnClickListener { onClickListener(site) }
	}

	companion object {

		fun getFlagResource(id: String): Int {
			return when(id) {
				"MRD" -> R.drawable.flag_costa_rica
				"MBO" -> R.drawable.flag_bolivia
				"MLC" -> R.drawable.flag_chile
				"MCO" -> R.drawable.flag_colombia
				"MCR" -> R.drawable.flag_costa_rica
				"MCU" -> R.drawable.flag_cuba
				"MEC" -> R.drawable.flag_ecuador
				"MGT" -> R.drawable.flag_guatemala
				"MHN" -> R.drawable.flag_honduras
				"MLA" -> R.drawable.flag_argentina
				"MLB" -> R.drawable.flag_brasil
				"MLM" -> R.drawable.flag_mexico
				"MLU" -> R.drawable.flag_uruguay
				"MLV" -> R.drawable.flag_venezuela
				"MNI" -> R.drawable.flag_nicaragua
				"MPA" -> R.drawable.flag_panama
				"MPY" -> R.drawable.flag_paraguay
				"MSV" -> R.drawable.flag_salvador
				"MPE" -> R.drawable.flag_peru
				else  -> throw InvalidParameterException("Wrong parameter $id")
			}
		}
	}
}
