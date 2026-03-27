package com.example.kalc

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.telephony.SmsMessage
import android.util.Log

class SmsReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            val pdus = bundle.get("pdus") as Array<*>
            for (pdu in pdus) {
                val message = SmsMessage.createFromPdu(pdu as ByteArray)
                val sender = message.displayOriginatingAddress
                val messageBody = message.messageBody

                Log.d("SmsReceiver", "SMS from: $sender; Message: $messageBody")

                // Parsing logic (example implementation)
                if (messageBody.contains("Transaction")) {
                    saveTransaction(sender, messageBody)
                }
            }
        }
    }

    private fun saveTransaction(sender: String?, messageBody: String) {
        // Logic to save the transaction, possibly to a database or file
        Log.d("SmsReceiver", "Transaction saved from: $sender with message: $messageBody")
        // Implement actual saving of the transaction data here
    }
}