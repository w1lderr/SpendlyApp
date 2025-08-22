package com.apka.spendly.ui.screens.ExchangeRate

import com.apka.spendly.ui.screens.AddNewTarget.Categories

enum class ExchangeRates(
    val cc: String,
    val flag: String
) {
    ALGERIA("DZD", "\uD83C\uDDE9\uD83C\uDDFF"),
    AUSTRALIA("AUD", "\uD83C\uDDE6\uD83C\uDDFA"),
    BANGLADESH("BDT", "\uD83C\uDDE7\uD83C\uDDE9"),
    CANADA("CAD", "\uD83C\uDDE8\uD83C\uDDE6"),
    CHINA("CNY", "\uD83C\uDDE8\uD83C\uDDF3"),
    CZECHIA("CZK", "\uD83C\uDDE8\uD83C\uDDFF"),
    DENMARK("DKK", "\uD83C\uDDE9\uD83C\uDDF0"),
    HONG_KONG("HKD", "\uD83C\uDDED\uD83C\uDDF0"),
    HUNGARY("HUF", "\uD83C\uDDED\uD83C\uDDFA"),
    INDIA("INR", "\uD83C\uDDEE\uD83C\uDDF3"),
    INDONESIA("IDR", "\uD83C\uDDEE\uD83C\uDDE9"),
    ISRAEL("ILS", "\uD83C\uDDEE\uD83C\uDDF1"),
    JAPAN("JPY", "\uD83C\uDDEF\uD83C\uDDF5"),
    KAZAKHSTAN("KZT", "\uD83C\uDDF0\uD83C\uDDFF"),
    SOUTH_KOREA("KRW", "\uD83C\uDDF0\uD83C\uDDF7"),
    LEBANON("LBP", "\uD83C\uDDF1\uD83C\uDDE7"),
    MALAYSIA("MYR", "\uD83C\uDDF2\uD83C\uDDFE"),
    MEXICO("MXN", "\uD83C\uDDF2\uD83C\uDDFD"),
    MOLDOVA("MDL", "\uD83C\uDDE6\uD83C\uDDF2"),
    NEW_ZEALAND("NZD", "\uD83C\uDDF3\uD83C\uDDFF"),
    NORWAY("NOK", "\uD83C\uDDF3\uD83C\uDDF4"),
    SAUDI_ARABIA("SAR", "\uD83C\uDDE6\uD83C\uDDEA"),
    SINGAPORE("SGD", "\uD83C\uDDF8\uD83C\uDDEC"),
    VIETNAM("VND", "\uD83C\uDDFB\uD83C\uDDF3"),
    SOUTH_AFRICA("ZAR", "\uD83C\uDDFF\uD83C\uDDE6"),
    SWEDEN("SEK", "\uD83C\uDDF8\uD83C\uDDEA"),
    SWITZERLAND("CHF", "\uD83C\uDDE8\uD83C\uDDED"),
    THAILAND("THB", "\uD83C\uDDF9\uD83C\uDDED"),
    UAE("AED", "\uD83C\uDDE6\uD83C\uDDEA"),
    TUNISIA("TND", "\uD83C\uDDF9\uD83C\uDDF3"),
    EGYPT("EGP", "\uD83C\uDDEA\uD83C\uDDEC"),
    UK("GBP", "\uD83C\uDDEC\uD83C\uDDE7"),
    USA("USD", "\uD83C\uDDFA\uD83C\uDDF8"),
    SERBIA("RSD", "\uD83C\uDDF7\uD83C\uDDF8"),
    AZERBAIJAN("AZN", "\uD83C\uDDE6\uD83C\uDDFF"),
    ROMANIA("RON", "\uD83C\uDDF7\uD83C\uDDF4"),
    TURKEY("TRY", "\uD83C\uDDF9\uD83C\uDDF7"),
    XDR("XDR", "\u2696\uFE0F"),
    BULGARIA("BGN", "\uD83C\uDDE7\uD83C\uDDEC"),
    EURO("EUR", "\uD83C\uDDEA\uD83C\uDDFA"),
    GEORGIA("GEL", "\uD83C\uDDEA\uD83C\uDDED"),
    POLAND("PLN", "\uD83C\uDDF5\uD83C\uDDF1"),
    GOLD("XAU", "\uD83D\uDCB0"),
    SILVER("XAG", "\uD83E\uDD46"),
    PLATINUM("XPT", "\uD83E\uDD4C"),
    PALLADIUM("XPD", "\uD83E\uDD4D");

    companion object {
        fun fromCC(cc: String): ExchangeRates? =
            ExchangeRates.entries.find { it.cc == cc }
    }
}