package com.erantal.challenge.adapters

import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.erantal.assignment.inflate
import com.erantal.challenge.R
import com.erantal.challenge.models.RestOrderInformation
import com.erantal.challenge.ui.ItemViewHolder

class OrderItemsAdapter(private val items: ArrayList<RestOrderInformation>) : RecyclerView.Adapter<ItemViewHolder>(), Filterable {

    internal var filteredItems: List<RestOrderInformation> = items

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder {
        val inflatedView = parent.inflate(R.layout.item_product_row, false)
        return ItemViewHolder(inflatedView)
    }

    override fun getItemCount(): Int {
        return filteredItems.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = filteredItems[position]
        holder.bindItem(item)
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charString: CharSequence?): FilterResults {
                val query = charString.toString()
                if (query.isEmpty()) {
                    filteredItems = items
                } else {
                    filteredItems = items
                    filteredItems = filteredItems.filter { it.product?.name?.toLowerCase()?.contains(query.toLowerCase()) == true}
                }

                var filterResults = FilterResults()
                filterResults.values = filteredItems
                return filterResults
            }

            override fun publishResults(charString: CharSequence?, filterResults: FilterResults?) {
                filteredItems = filterResults?.values as ArrayList<RestOrderInformation>
                notifyDataSetChanged()
            }

        }
    }

}