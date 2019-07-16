package com.example.alc_challenge_1

import android.net.http.SslError
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.webkit.SslErrorHandler
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_about.*
import kotlinx.android.synthetic.main.activity_profile.*


class About : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        setSupportActionBar(toolbar)

        // JavaScript settings
        aboutWebView.settings.javaScriptEnabled = true
        aboutWebView.settings.loadWithOverviewMode = true
        aboutWebView.settings.domStorageEnabled = true
        aboutWebView.settings.useWideViewPort = true
        aboutWebView.settings.javaScriptCanOpenWindowsAutomatically = true
        aboutWebView.webViewClient = SSLTolerentWebViewClient()

        // launch the url inside the webView
        aboutWebView.loadUrl(getString(R.string.alc_url))

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}

internal class SSLTolerentWebViewClient : WebViewClient() {
    override fun onReceivedSslError(webView: WebView, handler: SslErrorHandler, error: SslError) {
        handler.proceed() // Ignore SSL certificate errors
    }
}