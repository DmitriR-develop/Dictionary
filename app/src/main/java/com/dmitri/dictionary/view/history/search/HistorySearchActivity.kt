package com.dmitri.dictionary.view.history.search

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import com.dmitri.dictionary.R
import com.dmitri.dictionary.databinding.ActivityHistorySearchBinding
import com.dmitri.dictionary.model.data.AppState
import com.dmitri.core.BaseActivity
import com.dmitri.dictionary.view.descriptionscreen.DescriptionActivity

class HistorySearchActivity : com.dmitri.core.BaseActivity<AppState>() {
    override val model: HistorySearchViewModel = get()
    private val observer = Observer<AppState> { renderData(it) }
    private var _binding: ActivityHistorySearchBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHistorySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.searchButton.setOnClickListener {
            model.getData(
                binding.searchEditText.text.toString(),
                false
            )
        }
        model.subscribe().observe(this, observer)
    }

    override fun showErrorScreen(error: String?) {
        showViewError()
        binding.errorTextView.text = error ?: getString(R.string.error_undefined)
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

        startActivity(
            DescriptionActivity.getIntent(
                this@HistorySearchActivity,
                appState.data?.get(0)?.text!!,
                "",
                ""
            )
        )
    }
}