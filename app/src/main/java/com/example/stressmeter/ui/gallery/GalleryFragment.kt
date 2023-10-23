package com.example.stressmeter.ui.gallery

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.stressmeter.adapter.GraphAdapter
import com.example.stressmeter.adapter.StressAdapter
import com.example.stressmeter.databinding.FragmentGalleryBinding
import com.example.stressmeter.model.StressDataModel
import com.example.stressmeter.utilis.SessionAndCookies
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import lecho.lib.hellocharts.model.*
import lecho.lib.hellocharts.view.LineChartView

class GalleryFragment : Fragment() {

    private var stressList: MutableList<StressDataModel> = mutableListOf()
    private lateinit var adapter: GraphAdapter

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        stressList = SessionAndCookies.getStressList(requireActivity())
        // Create a list of entries from the stressList
        val entries: MutableList<Entry> = mutableListOf()
        for (stressData in stressList) {
            // Check if the stress value is non-negative before adding it to the entries list
            if (stressData.stressValue >= 0) {
                entries.add(Entry(stressData.stressValue.toFloat(), stressData.stressValue.toFloat()))
            }
            //entries.add(Entry(stressData.stressValue.toFloat(), stressData.stressValue.toFloat()))
        }


        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = GraphAdapter(stressList)
        binding.recyclerView.adapter = adapter

        if (entries.isNotEmpty()) {
            val dataSet = LineDataSet(entries, "Stress Values")
            dataSet.color = Color.BLUE
            dataSet.valueTextColor = Color.BLACK
            dataSet.lineWidth = 2f

            val lineData = LineData(dataSet)
            binding.lineChart.data = lineData

            val description = Description()
            description.text = "Stress Level Over Time"
            binding.lineChart.description = description

            binding.lineChart.invalidate()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}