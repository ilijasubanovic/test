package ilija.aura.dione;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class news extends Activity {
	TextView textNews;
	String tempNews;
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

	int[] backgrounds={
			R.drawable.background2_1,
			R.drawable.background2_2,
			R.drawable.background2_3,
			R.drawable.background2_4,
			R.drawable.background2_5			
	}; 
	
public class BackgroundAsyncTask extends
    AsyncTask<Void, Integer, Void> {

public BackgroundAsyncTask() {
}

@Override
  protected void onPostExecute(Void result) {
	  textNews.setText(tempNews);

  }

  @Override
  protected void onPreExecute() {
	  textNews.setText("Loading news from server....");
  }

  @Override
  protected Void doInBackground(Void... params) {
	  	InputStream inputStream = getResources().openRawResource(R.raw.news);
	     int i;
	     try {
         URL url = new URL("http://www.pars.hr/ilija_bikes/aura_dione_live_news.txt");
         inputStream = url.openStream();
         
	    	i = inputStream.read();
	    	while (i != -1)
	     	{
	     		byteArrayOutputStream.write(i);
	     		i = inputStream.read();
	     	}
	     	inputStream.close();
	     } catch (IOException e) {
	     	e.printStackTrace();
	     }
	     tempNews = byteArrayOutputStream.toString();
   return null;
  }

  @Override
  protected void onProgressUpdate(Integer... values) {
  }
}
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.news);
		
		Random rgenerator = new Random ();
        RelativeLayout relLay = (RelativeLayout) findViewById(R.id.rLayNews);
        relLay.setBackgroundResource(backgrounds[rgenerator.nextInt(backgrounds.length)]);
        
        
        textNews = (TextView) findViewById(R.id.textViewNews2);
		new BackgroundAsyncTask().execute();

		
	//	textNews.setText(readTxt());		
	}
	



}
