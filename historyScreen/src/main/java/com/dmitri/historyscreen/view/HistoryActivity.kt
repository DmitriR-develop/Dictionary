package com.dmitri.dictionary.view.history

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.dmitri.dictionary.R
import com.dmitri.dictionary.model.data.AppState
import com.dmitri.historyscreen.databinding.ActivityHistoryBinding
import com.dmitri.historyscreen.di.injectDependencies
import org.koin.androidx.viewmodel.ext.android.viewModel

class HistoryActivity : com.dmitri.core.BaseActivity<AppState>() {

    private var adapter: HistoryAdapter? = null
    override val model: HistoryViewModel by viewModel()
    private val observer = Observer<AppState> { renderData(it) }
    private var _binding: ActivityHistoryBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        injectDependencies()
        model.subscribe().observe(this, observer)
    }

    override fun onResume() {
        super.onResume()
        model.getData("", false)
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
        if (adapter == null) {
            binding.historyActivityRv.layoutManager =
                LinearLayoutManager(applicationContext)
            binding.historyActivityRv.adapter = HistoryAdapter(appState.data!!)
        } else {
            adapter!!.setData(appState.data!!)
        }
    }
}