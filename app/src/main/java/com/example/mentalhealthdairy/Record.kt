package com.example.mentalhealthdairy

import java.util.*

data class Record(
    val id: UUID = UUID.randomUUID(),
    var title: String = "",
    var date: Date = Date(),
    var isReflected: Boolean = false
)