package ilija.aura.dione;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class gallery extends Activity implements OnTouchListener {

	TextView t;
	String model="Texttt";
	ImageView display;
	Bitmap bmp;
	int i=0;
	String linkUrl;
	ProgressBar progressBar;
	Button back;
	Button next;
	float x1, x2, y1, y2;
	String direction;
	
	int[] images={
			R.drawable.aura_1,
			R.drawable.aura_2,
			R.drawable.aura_3,
			R.drawable.aura_4,
			R.drawable.aura_5,
			R.drawable.aura_6,
			R.drawable.aura_7,
			R.drawable.aura_8,
			R.drawable.aura_9,
			R.drawable.aura_10,
			R.drawable.aura_11,
			R.drawable.aura_12,
			R.drawable.aura_13,
			R.drawable.aura_14,
			R.drawable.aura_15,
			R.drawable.aura_16,
			R.drawable.aura_17,
			R.drawable.aura_18,
			R.drawable.aura_19,
			R.drawable.aura_20,
			R.drawable.aura_21,
			R.drawable.aura_22,
			R.drawable.aura_23,
			R.drawable.aura_24,
			R.drawable.aura_25,
			R.drawable.aura_26,
			R.drawable.aura_27,
			R.drawable.aura_28,
			R.drawable.aura_29,
			R.drawable.aura_30,
			R.drawable.aura_31,
			R.drawable.aura_32,
			R.drawable.aura_33,
			R.drawable.aura_34,
			R.drawable.aura_35,
			R.drawable.aura_36,
			R.drawable.aura_37,
			R.drawable.aura_38,
			R.drawable.aura_39,
			R.drawable.aura_40
			};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	//	requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.gallery);


		display	= (ImageView) findViewById(R.id.ImageViewGallery);
		display.setImageResource(images[i]);
		registerForContextMenu (display);
		display.setOnTouchListener(this);
		
		next = (Button) findViewById(R.id.nextGallery);
		back = (Button) findViewById(R.id.backGallery);
		
	    progressBar = (ProgressBar)findViewById(R.id.progressBarGallery);
	    progressBar.setProgress(0);
		progressBar.setVisibility(View.INVISIBLE);
		
				
		next.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (i>=images.length-1) {
					Toast showtoast=Toast.makeText(getApplicationContext(), "Last image", Toast.LENGTH_SHORT);	
					showtoast.show();
				}
				else {
					i++;
					  	TranslateAnimation anim = new TranslateAnimation(400, 0, 0, 0);
				        anim.setDuration(600);
				        anim.setFillAfter(true);
				        display.startAnimation(anim);
				        display.setImageResource(images[i]);
					//display.setImageResource(images[i]);
				}
			}
		});
		
		back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (i==0){
					Toast showtoast=Toast.makeText(getApplicationContext(), "First image", Toast.LENGTH_SHORT);	
					showtoast.show();
				}
				else {
					i--;
				  	TranslateAnimation anim = new TranslateAnimation(-400, 0, 0, 0);
			        anim.setDuration(600);
			        anim.setFillAfter(true);
			        display.startAnimation(anim);
					display.setImageResource(images[i]);

				}
			}
		});
		
		
}
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		switch(event.getAction()) {
	    case(MotionEvent.ACTION_DOWN):
	        x1 = event.getX();
	        y1 = event.getY();
	        break;
	    case(MotionEvent.ACTION_UP): {
	        x2 = event.getX();
	        y2 = event.getY();
	        float dx = x2-x1;
	        float dy = y2-y1;

	            // Use dx and dy to determine the direction
	        if(Math.abs(dx) > Math.abs(dy)) {
	            if(dx>0) {
	            	direction = "right";
	            	if (i==0){
						Toast showtoast=Toast.makeText(getApplicationContext(), "First image", Toast.LENGTH_SHORT);	
						showtoast.show();
					}
					else {
						i--;
					  	TranslateAnimation anim = new TranslateAnimation(-400, 0, 0, 0);
				        anim.setDuration(600);
				        anim.setFillAfter(true);
				        display.startAnimation(anim);
						display.setImageResource(images[i]);

					}
	            	
	            }
	            else {
	            	direction = "left";
	            	if (i>=images.length-1) {
						Toast showtoast=Toast.makeText(getApplicationContext(), "Last image", Toast.LENGTH_SHORT);	
						showtoast.show();
					}
					else {
						i++;
					  	TranslateAnimation anim = new TranslateAnimation(400, 0, 0, 0);
				        anim.setDuration(600);
				        anim.setFillAfter(true);
				        display.startAnimation(anim);
						display.setImageResource(images[i]);

					}
	            }
	            }
	         else if (Math.abs(dy) > Math.abs(dx)) {
	            if(dy>0) direction = "down";
	            else direction = "up";
	        }
	         else {
	        	 direction = "none";
	        	 v.showContextMenu();
	         }
	    }
	    }
		return true;
	}
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
	    super.onCreateContextMenu(menu, v, menuInfo);
	    menu.setHeaderTitle("Select activity");
	    menu.add(0, v.getId(), 0, "Set to wallpaper");
	    menu.add(0, v.getId(), 0, "Cancel");

	}
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		if (item.getTitle()=="Set to wallpaper"){
			Bitmap picture = BitmapFactory.decodeStream(getResources().openRawResource(images[i]));
				try { 
						getApplicationContext().setWallpaper(picture);
					}catch (IOException e){
						e.printStackTrace();
					}
				Toast showtoast=Toast.makeText(getApplicationContext(), "Wallpaper Set", Toast.LENGTH_SHORT);
				showtoast.setGravity(Gravity.CENTER, 0, 0);
				showtoast.show();
				return true;
			}
		return false;
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		        menu.add(0, 0, 0, "Set to wallpaper");
		        menu.add(0, 0, 0, "Cancel");

		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item){
		if (item.getTitle()=="Cancel"){ 	
			return true;
		}
		else if (item.getTitle()=="Set to wallpaper") {
		    WallpaperManager myWallpaperManager = WallpaperManager.getInstance(getApplicationContext());
		//    final int fullWidth = myWallpaperManager.getDesiredMinimumWidth();
		//    final int fullHeight = myWallpaperManager.getDesiredMinimumHeight();
		//    Bitmap picture = BitmapFactory.decodeStream(getResources().openRawResource(images[i]));
		//    Bitmap resizedBitmap = Bitmap.createBitmap(picture, 0, 0,
		//    		fullWidth, fullHeight);
				//Bitmap picture = BitmapFactory.decodeStream(getResources().openRawResource(images[i]));
			try { 
			//	getApplicationContext().setWallpaper(resizedBitmap);
			     myWallpaperManager.setResource(images[i]);

			}catch (IOException e){
				e.printStackTrace();
			}
		Toast showtoast=Toast.makeText(getApplicationContext(), "Wallpaper Set", Toast.LENGTH_SHORT);
		showtoast.setGravity(Gravity.CENTER, 0, 0);
		showtoast.show();
		return true;
		}
		return false;
}
}
	
	


	
	

	

