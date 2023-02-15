package com.android.flexxpay_sdk.utils

import java.text.NumberFormat
import java.util.*

class NumbersManager {
    companion object{
        fun formatNumber(amount: Double): String? {
            /**
             * To get only the first two characters and format the number
             */
            var isoCode = "AED"
            if (isoCode == "") {
                isoCode = "US"
            }
            val stringBuilder = StringBuilder()
            stringBuilder.append(isoCode[0])
            stringBuilder.append(isoCode[1])
            val languageTag = "en" + "-" + stringBuilder.toString().uppercase(Locale.getDefault())
            val format = NumberFormat.getCurrencyInstance(Locale.forLanguageTag(languageTag))
            var currency = format.format(amount)
            currency = currency.replace("[^0-9.,]".toRegex(), "")
            return currency
        }

        fun formatNumber(amount: Int): String? {
            /**
             * To get only the first two characters and format the number
             */
            var isoCode = "AED"
            if (isoCode == "") {
                isoCode = "US"
            }
            val stringBuilder = StringBuilder()
            stringBuilder.append(isoCode[0])
            stringBuilder.append(isoCode[1])
            val languageTag = "en" + "-" + stringBuilder.toString().uppercase(Locale.getDefault())
            val format = NumberFormat.getCurrencyInstance(Locale.forLanguageTag(languageTag))
            var currency = format.format(amount)
            currency = currency.replace("[^0-9.,]".toRegex(), "")
            return currency
        }
    }
}