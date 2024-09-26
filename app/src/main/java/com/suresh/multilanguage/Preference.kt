package com.suresh.multilanguage

import android.content.Context

const val DEFAULT = "en"
const val DATA_NAME = "selectedLanguage"
const val SELECTED_LANGUAGE = "selected_language"

fun Context.saveSelectedLanguage(language: String) {
    with(getSharedPreferences(DATA_NAME, Context.MODE_PRIVATE).edit()) {
        putString(SELECTED_LANGUAGE, language)
        apply()
    }
}

fun Context.getSelectedLanguage() =
    getSharedPreferences(DATA_NAME, Context.MODE_PRIVATE)
        .getString(SELECTED_LANGUAGE, DEFAULT).toString()