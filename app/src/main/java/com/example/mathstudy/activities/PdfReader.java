package com.example.mathstudy.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.mathstudy.R;
import com.example.mathstudy.interfaces.ActivityInitializer;
import com.github.barteksc.pdfviewer.PDFView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


    // TODO: i will change the schema of the database and the entity classes
    //      01: delete the season entity and table
    //      02: add section and lesson tables and connect them
    // COMPLETED (changed to be not downloadable) TODO 06: add the functionality of download document
    //                                                      by clicking on document item
    // COMPLETED (this plan changed) TODO 07: open the file directly after download it
    // TODO 08: fill the database with real data
    // TODO 09: add navigation drawer to categories activity
    // FIXME 09: make some change to design
    // FIXME 10: create interface for initViews, initVar, initListener and implement it in the classes

/**
 * this activity read the files with format pdf using "barteksc_pdf_viewer".
 */
public class PdfReader extends AppCompatActivity implements ActivityInitializer {

    private PDFView pdfViewer;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initViews();
        initFunctionality();

//        pdfViewer.fromAsset("math_level1.pdf").load();
//        new RetrivePDFfromUrl().execute("https://drive.google.com/file/d/10ZNrWN8o-bqrqzymf4nify9zy-QkZ55X/view");
    }

    @Override
    public void initViews() {
        setContentView(R.layout.activity_pdf_reader);
//      pdfViewer = (PDFView) findViewById(R.id.pdfViewer);
        webView = (WebView) findViewById(R.id.webView);
    }

    @Override
    public void initListeners() {

    }

    @Override
    public void initVars() {

    }

    @Override
    public void initFunctionality() {
        editWebViewSettings(webView);
        webView.loadUrl(linkReceiver());
    }

    // create an async task class for loading pdf file from URL.
    class RetrivePDFfromUrl extends AsyncTask<String, Void, InputStream> {
        @Override
        protected InputStream doInBackground(String... strings) {
            // we are using inputstream
            // for getting out PDF.
            InputStream inputStream = null;
            try {
                URL url = new URL(strings[0]);
                // below is the step where we are
                // creating our connection.
                HttpURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
                if (urlConnection.getResponseCode() == 200) {
                    // response is success.
                    // we are getting input stream from url
                    // and storing it in our variable.
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
                }

            } catch (IOException e) {
                // this is the method
                // to handle errors.
                e.printStackTrace();
                return null;
            }
            return inputStream;
        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            // after the execution of our async
            // task we are loading our pdf in our pdf view.
            pdfViewer.fromStream(inputStream).load();
        }
    }

    /**
     * this function will receive the link of the document from the Documents Activity
     * we use Intent to pass the link between these two activities.
     */
    public String linkReceiver(){
        String mDocumentLink = "";
        Bundle extras = getIntent().getExtras();
        if(extras !=null) {
            mDocumentLink = extras.getString("documentLink");
        }
        return mDocumentLink;
    }

    /**
     * this function will play with settings of the webView which is the (pdf_reader)
     * like zooming and hide the toolbar of the viewer.
     * @param webView
     */
    public void editWebViewSettings(WebView webView){
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                webView.loadUrl("javascript: (function() { " +
                        "document.querySelector('[role=\"toolbar\"]').remove();}) ()");
            }
        });
    }
}