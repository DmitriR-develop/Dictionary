package com.dmitri.dictionary.view.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.dmitri.dictionary.R
import com.dmitri.dictionary.databinding.ActivityMainBinding
import com.dmitri.dictionary.model.data.AppState
import com.dmitri.dictionary.model.data.DataModel
import com.dmitri.dictionary.view.base.BaseActivity
import com.dmitri.dictionary.view.descriptionscreen.DescriptionActivity
import com.dmitri.dictionary.view.history.HistoryActivity
import com.dmitri.dictionary.view.history.search.HistorySearchActivity
import com.dmitri.dictionary.view.main.adapter.MainAdapter
import org.koin.android.ext.android.get

class MainActivity : BaseActivity<AppState>() {

    private var adapter: MainAdapter? = null
    override val model: MainViewModel = get()
    private val observer = Observer<AppState> { renderData(it) }
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val onListItemClickListener: MainAdapter.OnListItemClickListener =
        object : MainAdapter.OnListItemClickListener {
            override fun onItemClick(data: DataModel) {
                startActivity(
                    DescriptionActivity.getIntent(
                        this@MainActivity,
                        data.text!!,
                        data.meanings!![0].translation?.translation.toString(),
                        data.meanings[0].imageUrl
                    )
                )
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.searchButton.setOnClickListener {
            model.getData(binding.searchEditText.text.toString(), true)
        }
        model.subscribe().observe(this, observer)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.history_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.menu_history -> {
                startActivity(Intent(this, HistoryActivity::class.java))
                true
            }
            R.id.menu_history_search -> {
                startActivity(Intent(this, HistorySearchActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun showErrorScreen(error: String?) {
        showViewError()
        binding.errorTextview.text = error ?: getString(R.string.undefined_error)
        binding.reloadButton.setOnClickListener { model.getData("Hi", true) }
    }

    override fun showViewSuccess() {
        binding.successLinearLayout.visibility = VISIBLE
        binding.loadingFrameLayout.visibility = GONE
        binding.errorLinearLayout.visibility = GONE
    }

    override fun showViewLoading() {
        binding.successLinearLayout.visibility = GONE
        binding.loadingFrameLayout.visibility = VISIBLE
        binding.errorLinearLayout.visibility = GONE
    }

    override fun showViewError() {
        binding.successLinearLayout.visibility = GONE
        binding.loadingFrameLayout.visibility = GONE
        binding.errorLinearLayout.visibility = VISIBLE
    }

    override fun onLoadingSuccess(appState: AppState.Success) {
        if (adapter == null) {
            binding.mainActivityRv.layoutManager =
                LinearLayoutManager(applicationContext)
            binding.mainActivityRv.adapter = MainAdapter(appState.data!!, onListItemClickListener)
        } else {
            adapter!!.setData(appState.data!!)
        }
    }
}