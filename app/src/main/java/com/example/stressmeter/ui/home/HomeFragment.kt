package com.example.stressmeter.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stressmeter.R
import com.example.stressmeter.adapter.StressAdapter
import com.example.stressmeter.databinding.FragmentHomeBinding
import com.example.stressmeter.model.StressDataModel

class HomeFragment : Fragment() {

    private lateinit var stressList: MutableList<StressDataModel>
    private lateinit var stressAdapter: StressAdapter
    private var currentIndex = 0

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // val homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        stressList = mutableListOf(
            StressDataModel(R.drawable.psm_alarm_clock, 6),
            StressDataModel(R.drawable.psm_alarm_clock2, 8),
            StressDataModel(R.drawable.psm_angry_face, 14),
            StressDataModel(R.drawable.psm_anxious, 16),
            StressDataModel(R.drawable.psm_baby_sleeping, 5),
            StressDataModel(R.drawable.psm_bar, 7),
            StressDataModel(R.drawable.psm_barbed_wire2, 13),
            StressDataModel(R.drawable.psm_beach3, 15),
            StressDataModel(R.drawable.psm_bird3, 2),
            StressDataModel(R.drawable.psm_blue_drop, 4),
            StressDataModel(R.drawable.psm_cat, 10),
            StressDataModel(R.drawable.psm_clutter, 12),
            StressDataModel(R.drawable.psm_clutter3, 1),
            StressDataModel(R.drawable.psm_dog_sleeping, 3),
            StressDataModel(R.drawable.psm_exam4, 9),
            StressDataModel(R.drawable.psm_gambling4, 11),
            StressDataModel(R.drawable.psm_headache, 6),
            StressDataModel(R.drawable.psm_headache2, 8),
            StressDataModel(R.drawable.psm_hiking3, 14),
            StressDataModel(R.drawable.psm_kettle, 16),
            StressDataModel(R.drawable.psm_lake3, 6),
            StressDataModel(R.drawable.psm_lawn_chairs3, 7),
            StressDataModel(R.drawable.psm_lonely, 13),
            StressDataModel(R.drawable.psm_lonely2, 15),
            StressDataModel(R.drawable.psm_mountains11, 19),
            StressDataModel(R.drawable.psm_neutral_child, 6),
            StressDataModel(R.drawable.psm_neutral_person2, 7),
            StressDataModel(R.drawable.psm_peaceful_person, 12),
            StressDataModel(R.drawable.psm_puppy, 7),
            StressDataModel(R.drawable.psm_puppy3, 24),
            StressDataModel(R.drawable.psm_reading_in_bed2, 12),
            StressDataModel(R.drawable.psm_running3, 3),
            StressDataModel(R.drawable.psm_running4, 6),
            StressDataModel(R.drawable.psm_sticky_notes2, 8),
            StressDataModel(R.drawable.psm_stressed_cat, 9),
            StressDataModel(R.drawable.psm_stressed_person12, 1),
            StressDataModel(R.drawable.psm_stressed_person, 8),
            StressDataModel(R.drawable.psm_stressed_person3, 9),
            StressDataModel(R.drawable.psm_stressed_person4, 5),
            StressDataModel(R.drawable.psm_stressed_person6, 13),
            StressDataModel(R.drawable.psm_stressed_person7, 14),
            StressDataModel(R.drawable.psm_stressed_person8, 7),
            StressDataModel(R.drawable.psm_wine3, 4),
            StressDataModel(R.drawable.psm_work4, 11),
            StressDataModel(R.drawable.psm_yoga4, 15),
        )
        /*val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) { textView.text = it }*/

        // Load the first 10 images initially

        stressAdapter = StressAdapter(requireContext())
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 4)
        binding.recyclerView.adapter = stressAdapter

        loadNextImages()


        binding.btnMoreImages.setOnClickListener {
            // Handle "More Images" button click event here
            // Load the next 10 images
            stressAdapter.clearItems()
            loadNextImages()
        }

        return root
    }

    private fun loadNextImages() {
        // Load the next 10 images from the stressList and add them to the recyclerView
        for (i in 0 until 16) {
            // Get the next item from the stressList, if available
            if (currentIndex < stressList.size) {
                val stressData = stressList[currentIndex]
                stressAdapter.addItem(stressData)
                currentIndex++
            } else {
                // If the stressList is exhausted, reset the index and start again
                currentIndex = 0
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}