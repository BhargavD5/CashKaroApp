package in.simpal.cashkaro.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import in.simpal.cashkaro.R;

public class WebActivity extends AppCompatActivity {


	private WebView webView;
	private ProgressBar progressBar;
	private float m_downX;


	private String url="http://www.cashkaro.com";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_content);

		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setTitle("");

		//set Url as per requirements from prev
		//url = getIntent().getStringExtra("url");

		progressBar = (ProgressBar) findViewById(R.id.progressBar);


		webView=(WebView) findViewById(R.id.webEngine);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.clearCache(true);
		webView.clearHistory();
		webView.setHorizontalScrollBarEnabled(false);
		initWebView();
		webView.loadUrl(url);
    
}
/////////

	private void initWebView() {
		webView.setWebChromeClient(new MyWebChromeClient(this));
		webView.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView view, String url, Bitmap favicon) {
				super.onPageStarted(view, url, favicon);
				progressBar.setVisibility(View.VISIBLE);
				invalidateOptionsMenu();
			}

			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				webView.loadUrl(url);
				return true;
			}

			@Override
			public void onPageFinished(WebView view, String url) {
				super.onPageFinished(view, url);
				progressBar.setVisibility(View.GONE);
				invalidateOptionsMenu();
			}

			@Override
			public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
				super.onReceivedError(view, request, error);
				progressBar.setVisibility(View.GONE);
				invalidateOptionsMenu();
			}
		});
		webView.clearCache(true);
		webView.clearHistory();
		webView.getSettings().setJavaScriptEnabled(true);
		webView.setHorizontalScrollBarEnabled(false);
		webView.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {

				if (event.getPointerCount() > 1) {
					//Multi touch detected
					return true;
				}

				switch (event.getAction()) {
					case MotionEvent.ACTION_DOWN: {
						// save the x
						m_downX = event.getX();
					}
					break;

					case MotionEvent.ACTION_MOVE:
					case MotionEvent.ACTION_CANCEL:
					case MotionEvent.ACTION_UP: {
						// set x so that it doesn't move
						event.setLocation(m_downX, event.getY());
					}
					break;
				}

				return false;
			}
		});
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.

		if (item.getItemId() == android.R.id.home) {
			finish();
		}


		return super.onOptionsItemSelected(item);
	}


	@Override
	public void onBackPressed() {
		super.onBackPressed();
		finish();
	}


private class MyWebChromeClient extends WebChromeClient {
	Context context;

	public MyWebChromeClient(Context context) {
		super();
		this.context = context;
	}


}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
