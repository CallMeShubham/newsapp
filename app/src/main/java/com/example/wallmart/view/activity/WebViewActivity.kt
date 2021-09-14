package com.example.wallmart.view.activity

import android.webkit.WebView
import android.os.Bundle
import android.app.Activity
import com.example.wallmart.R
import com.example.wallmart.utils.Constants

/**
 * webview class for showing news article details
 */
class WebViewActivity : Activity() {
    private var webView: WebView? = null
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.webview_layout)
        webView?.settings?.javaScriptEnabled = true
        webView?.settings?.loadWithOverviewMode = true
        webView?.settings?.useWideViewPort = true
        intent.getStringExtra(Constants.url)?.let { webView?.loadUrl(it) }
    }
}
