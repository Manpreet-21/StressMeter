package com.example.stressmeter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.stressmeter.R
import com.example.stressmeter.model.StressDataModel

class GraphAdapter(private val dataList: List<StressDataModel>) :
    RecyclerView.Adapter<GraphAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_graph, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[position]
        holder.stressValueTextView.text = data.stressValue.toString()
        holder.timestampTextView.text = data.currentTimeStamp.toString()
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val stressValueTextView: TextView = itemView.findViewById(R.id.stressValueTextView)
        val timestampTextView: TextView = itemView.findViewById(R.id.timestampTextView)
    }
}
