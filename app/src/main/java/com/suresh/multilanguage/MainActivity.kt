package com.suresh.multilanguage

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.suresh.multilanguage.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initialSetup()
        clickListener()
    }

    private fun clickListener() {
        binding.apply {

            btnEnglish.setOnClickListener {
                onLanguageSelected("en")
            }

            btnHindi.setOnClickListener {
                onLanguageSelected("hi")
            }

            btnGujarati.setOnClickListener {
                onLanguageSelected("gu")
            }

            btnTamil.setOnClickListener {
                onLanguageSelected("ta")
            }

            btnChinese.setOnClickListener {
                onLanguageSelected("ch")
            }

            btnSpenish.setOnClickListener {
                onLanguageSelected("sp")
            }
        }
    }

    private fun initialSetup() {
        val language = getSelectedLanguage()
        updateLocale(language)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun updateLocale(languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val config = Configuration()
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)
    }

    private fun onLanguageSelected(language: String) {
        saveSelectedLanguage(language)
        updateLocale(language)
        recreate()
    }
}