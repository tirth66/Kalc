package com.example.kalc

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transactions")
data class Transaction(
    @PrimaryKey val id: Long,
    val sender: String,
    val amount: Double,
    val type: String,
    val messageBody: String,
    val timestamp: String // You may want to use a Date type or Long for timestamp depending on your needs
)