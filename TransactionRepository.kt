package com.example.repository

import com.example.model.Transaction

interface TransactionRepository {
    fun findById(id: Long): Transaction?
    fun save(transaction: Transaction): Transaction
    fun delete(id: Long)
    fun findAll(): List<Transaction>
}