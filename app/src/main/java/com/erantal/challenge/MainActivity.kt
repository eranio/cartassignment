package com.erantal.challenge

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.erantal.challenge.AppConstants.CENTS_IN_DOLLAR
import com.erantal.challenge.adapters.OrderItemsAdapter
import com.erantal.challenge.viewmodels.CartViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: OrderItemsAdapter
    private lateinit var cartViewModel: CartViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = getString(R.string.my_cart)
        cartViewModel = ViewModelProviders.of(this).get(CartViewModel::class.java)
        cartViewModel.init()
        initRecyclerView()
        observeLiveData()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu.findItem(R.id.search).actionView as SearchView).apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
            maxWidth = Int.MAX_VALUE
            setOnQueryTextListener  (object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    filterResults(query)
                    return false
                }

                override fun onQueryTextChange(query: String?): Boolean {
                    filterResults(query)
                    return false
                }
            } )
        }
        return true
    }

    private fun filterResults(query: String?) {
        adapter.filter.filter(query)
    }

    private fun observeLiveData() {
        cartViewModel.cartLiveData.observe(this, Observer {
            total_cart.text = getString(R.string.total_cart_price,
                it.cart_total?.toDouble()?.div(CENTS_IN_DOLLAR)
            )
            adapter = OrderItemsAdapter(it.order_items_information ?: ArrayList())
            recyclerView.adapter = adapter
        })
    }

    private fun initRecyclerView() {
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        val divider = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        divider.setDrawable(ContextCompat.getDrawable(baseContext, R.drawable.horizontal_divider)!!)
        recyclerView.addItemDecoration(divider)
    }

}
