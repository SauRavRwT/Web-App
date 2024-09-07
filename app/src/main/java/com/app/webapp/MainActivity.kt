package com.app.webapp

import android.app.AlertDialog
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.app.webapp.utils.NetworkUtils

class MainActivity : AppCompatActivity() {
    private lateinit var mywebView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mywebView = findViewById(R.id.webview)
        mywebView.webViewClient = MyWebClient()

        // Check internet connection
        if (NetworkUtils.isInternetAvailable(this)) {
            // If internet is available, load the URL
            mywebView.loadUrl("Enter_your_Link_here")
        } else {
            // If no internet, show the alert dialog
            showInternetAlertDialog()
        }

        // Enable JavaScript in WebView
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

    // Show alert dialog to ask the user to enable the internet
    private fun showInternetAlertDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("No Internet Connection")
        builder.setMessage("Please enable internet access to continue using the app.")
        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss() // Close the dialog
        }
        builder.setCancelable(false) // Make the dialog non-cancellable
        val alertDialog = builder.create()
        alertDialog.show()
    }

    inner class MyWebClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            view?.loadUrl(url ?: "")
            return true
        }
    }
}
