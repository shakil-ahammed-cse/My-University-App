package com.example.myuniversityapplication;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private WebView iuweb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        iuweb =(WebView) findViewById(R.id.iuwebid);

        WebSettings iuwebset = iuweb.getSettings();
        iuwebset.setJavaScriptEnabled(true);

        iuweb.setWebViewClient(new WebViewClient());
        iuweb.loadUrl("https://www.iu.ac.bd/");


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onBackPressed() {
        if(iuweb.canGoBack())
        {
            iuweb.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
