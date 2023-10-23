package com.example.stressmeter.model

data class StressDataModel(val imageResId: Int, val stressValue: Int, val currentTimeStamp: Long = 0) {
    constructor(imageResId: Int, stressValue: Int) : this(imageResId, stressValue, 0)
}