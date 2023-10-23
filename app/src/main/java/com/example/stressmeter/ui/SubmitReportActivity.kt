package com.example.stressmeter.ui

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stressmeter.databinding.ActivitySubmitReportBinding
import com.example.stressmeter.model.StressDataModel
import com.example.stressmeter.utilis.SessionAndCookies

class SubmitReportActivity : AppCompatActivity() {

    var image: Int = 0
    var stressValue: Int = 0
    private var stressList: MutableList<StressDataModel> = mutableListOf()
    private lateinit var binding: ActivitySubmitReportBinding
    private lateinit var context: Activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubmitReportBinding.inflate(layoutInflater)
        setContentView(binding.root)

        context = this@SubmitReportActivity
        image = intent.getIntExtra("image", 0)
        stressValue = intent.getIntExtra("stress_value", 0)

        stressList = SessionAndCookies.getStressList(context)

        stressList.add(StressDataModel(image, stressValue, System.currentTimeMillis()))

        binding.imageView.setImageResource(image)

        binding.submitButton.setOnClickListener {
            SessionAndCookies.saveStressList(context, stressList)
            finishAffinity()
        }
        binding.cancelButton.setOnClickListener {
            finish()
        }
    }
}