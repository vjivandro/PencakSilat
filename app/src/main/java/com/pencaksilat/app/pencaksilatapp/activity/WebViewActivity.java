package com.pencaksilat.app.pencaksilatapp.activity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.pencaksilat.app.pencaksilatapp.R;

public class WebViewActivity extends AppCompatActivity {

    String kode, web_um, web_fik, web_pp;

    WebView webView;
    ConnectivityManager conMgr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        webView = (WebView) findViewById(R.id.webview);

        kode = getIntent().getStringExtra("kode");
        web_um = getIntent().getStringExtra("um");
        web_fik = getIntent().getStringExtra("fik");
        web_pp = getIntent().getStringExtra("policy");

        if (conMgr.getActiveNetworkInfo() != null
                && conMgr.getActiveNetworkInfo().isAvailable()
                && conMgr.getActiveNetworkInfo().isConnected()) {

            webView.getSettings().setBuiltInZoomControls(true);
            webView.getSettings().setSupportZoom(true);
            webView.getSettings().setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.setWebViewClient(new MyBrowser());

            if (kode.equals("0")) {
                webView.loadUrl(web_um);
                System.out.println("UM => " + web_um);
            } else if (kode.equals("1")) {
                webView.loadUrl(web_fik);
                System.out.println("FIK => "+ web_fik);
            } else if (kode.equals("2")) {
                webView.loadUrl(web_pp);
                System.out.println("Policy => "+ web_pp);
            }

        } else {
            Toast.makeText(this, "Periksa Jaringan anda", Toast.LENGTH_LONG).show();
        }
    }

    public class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (view == null) {
                webView.loadUrl(url);
            }
            return true;
        }
    }
}
