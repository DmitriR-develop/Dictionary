package com.dmitri.dictionary.view.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dmitri.dictionary.databinding.ActivityMainRecyclerviewItemBinding
import com.dmitri.dictionary.model.data.DataModel

class MainAdapter(
    private var data: List<DataModel>,
    private var onListItemClickListener: OnListItemClickListener
) :
    RecyclerView.Adapter<MainAdapter.RecyclerItemViewHolder>() {

    fun setData(data: List<DataModel>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerItemViewHolder {
        return RecyclerItemViewHolder(
            ActivityMainRecyclerviewItemBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerItemViewHolder, position: Int) {
        holder.bind(data.get(position))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    interface OnListItemClickListener {
        fun onItemClick(data: DataModel)
    }

    inner class RecyclerItemViewHolder(val view: ActivityMainRecyclerviewItemBinding) :
        RecyclerView.ViewHolder(view.root) {
        fun bind(data: DataModel) {
            view.headerTextviewRecyclerItem.text = data.text
            view.descriptionTextviewRecyclerItem.text =
                data.meanings?.get(0)?.translation?.translation
        }
    }
}