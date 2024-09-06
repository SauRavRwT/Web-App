package com.app.webapp

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var mywebView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mywebView = findViewById(R.id.webview)
        mywebView.webViewClient = MyWebClient()
            mywebView.loadUrl("Enter_your_Link_here")


        val webSettings: WebSettings = mywebView.settings
        webSettings.javaScriptEnabled = true

        // Handle back press using OnBackPressedDispatcher
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (mywebView.canGoBack()) {
                    mywebView.goBack()
                } else {
                    finish() // Or call super.onBackPressed()
                }
            }
        })
    }

    inner class MyWebClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            view?.loadUrl(url ?: "")
            return true
        }
    }
}
