package com.example.stressmeter.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.stressmeter.R
import com.example.stressmeter.model.StressDataModel
import com.example.stressmeter.ui.SubmitReportActivity

class StressAdapter(private val context: Context) : RecyclerView.Adapter<StressAdapter.ViewHolder>() {

    private val stressList: MutableList<StressDataModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_stress, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val stressData = stressList[position]
        holder.imageView.setImageResource(stressData.imageResId)

        holder.imageView.setOnClickListener {
            // Handle image click event here
            val intent = Intent(context, SubmitReportActivity::class.java)
            intent.putExtra("image", stressData.imageResId)
            intent.putExtra("stress_value", stressData.stressValue)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return stressList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clearItems() {
        stressList.clear()
        notifyDataSetChanged()
    }

    fun addItem(item: StressDataModel) {
        stressList.add(item)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }
}
