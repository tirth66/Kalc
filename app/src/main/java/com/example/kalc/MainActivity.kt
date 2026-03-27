package com.example.kalc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.kalc.ui.theme.KalcTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { 
            KalcTheme { 
                Surface(color = MaterialTheme.colorScheme.background) {
                    DisplayTransactions()
                }
            }
        }
    }
}

@Composable
fun DisplayTransactions() {
    // Sample transactions
    val transactions = listOf("Transaction 1", "Transaction 2", "Transaction 3")
    for (transaction in transactions) {
        Text(text = transaction)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KalcTheme { 
        DisplayTransactions() 
    }
}