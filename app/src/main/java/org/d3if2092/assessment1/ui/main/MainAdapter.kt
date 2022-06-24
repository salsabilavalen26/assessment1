package org.d3if2092.assessment1.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.d3if2092.assessment1.databinding.ListDosenBinding
import org.d3if2092.assessment1.model.Dosen

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private val data = mutableListOf<Dosen>()

    fun updateData(newData: List<Dosen>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ListDosenBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(dosen: Dosen) = with(binding) {
            namaTextView.text = dosen.nama
            matkulTextView.text = dosen.namaLatin
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListDosenBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}