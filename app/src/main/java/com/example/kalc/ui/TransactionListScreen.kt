import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

data class Transaction(val sender: String, val amount: Double, val type: String, val timestamp: String)

@Composable
fun TransactionListScreen(transactions: List<Transaction>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(transactions) { transaction ->
            TransactionCard(transaction)
        }
    }
}

@Composable
fun TransactionCard(transaction: Transaction) {
    Card(
        modifier = Modifier.padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Sender: ${transaction.sender}")
            Text(text = "Amount: $${transaction.amount}")
            Text(text = "Type: ", color = if (transaction.type == "Credit") Color.Green else Color.Red)
            Text(text = "Timestamp: ${transaction.timestamp}")
        }
    }
}

@Preview
@Composable
fun PreviewTransactionListScreen() {
    val sampleTransactions = listOf(
        Transaction("Alice", 50.0, "Credit", "2026-03-27 10:30:00"),
        Transaction("Bob", 30.0, "Debit", "2026-03-27 11:00:00")
    )
    TransactionListScreen(transactions = sampleTransactions)
}