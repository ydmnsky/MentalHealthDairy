package com.example.mentalhealthdairy

import androidx.lifecycle.ViewModel

class RecordListViewModel: ViewModel() {
    val records = mutableListOf<Record>()

    init {
        for (i in 0 until 100) {
            val record = Record()
            record.title = "Record #$i"
            record.isReflected = i % 2 == 0
            records += record
        }
    }
}