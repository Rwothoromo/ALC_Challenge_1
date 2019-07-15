package com.example.alc_challenge_1

import android.R
import android.net.http.SslError
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.webkit.SslErrorHandler
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_about.*


class About : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_about)

        aboutWebView.webViewClient = object : WebViewClient() {
            override fun onReceivedSslError(v: WebView, handler: SslErrorHandler, er: SslError) {
                handler.proceed()
            }
        }

        // JavaScript settings
        aboutWebView.settings.javaScriptEnabled = true
        aboutWebView.settings.loadWithOverviewMode = true
        aboutWebView.settings.layoutAlgorithm = WebSettings.LayoutAlgorithm.NORMAL
        aboutWebView.settings.useWideViewPort = true
//        aboutWebView.loadUrl(getString(R.string.alc_url))
        aboutWebView.loadUrl("https://andela.com/alc/")

        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}