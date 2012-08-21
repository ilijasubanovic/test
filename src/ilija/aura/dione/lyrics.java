package ilija.aura.dione;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
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
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class lyrics extends Activity {
	TextView helloTxt;
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
    private Spinner mySpinner;
    private SpinAdapter adapter;

	int[] songsText={
			R.raw.before_the_dinosaurs_1_geronimo,
			R.raw.before_the_dinosaurs_2_reconnect,
			R.raw.before_the_dinosaurs_3_friends,
			R.raw.before_the_dinosaurs_4_in_love_with_the_world,
			R.raw.before_the_dinosaurs_5_what_it_s_like,
			R.raw.before_the_dinosaurs_6_into_the_wild,
			R.raw.before_the_dinosaurs_7_masterpiece,
			R.raw.before_the_dinosaurs_8_where_the_wild_roses_grow_,
			R.raw.before_the_dinosaurs_9_america,
			R.raw.before_the_dinosaurs_10_recipe,
			R.raw.before_the_dinosaurs_11_superhuman,
			R.raw.before_the_dinosaurs_12_before_the_dinosaurs,
			R.raw.columbine_1_glass_bone_crash,
			R.raw.columbine_2_little_louie,
			R.raw.columbine_3_something_from_nothing,
			R.raw.columbine_4_stay_the_same,
			R.raw.columbine_5_picture_of_moon,
			R.raw.columbine_6_you_are_the_reason,
			R.raw.columbine_7_song_for_sophie,
			R.raw.columbine_8_i_will_love_you_monday,
			R.raw.columbine_9_clean_hands,
			R.raw.columbine_10_are_you_for_sale,
			R.raw.columbine_11_antony,
			R.raw.columbine_12_lulla_goodbye
			};
	
	int[] backgrounds={
			R.drawable.background2_1,
			R.drawable.background2_2,
			R.drawable.background2_3,
			R.drawable.background2_4,
			R.drawable.background2_5			
	}; 

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	//	requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.lyrics);
		final Random rgenerator = new Random ();

		Song[] users = new Song[24];

		users[0] = new Song();users[0].setId(1);users[0].setName("Geronimo - Before The Dinosaurs");
		users[1] = new Song();users[1].setId(2);users[1].setName("Reconnect - Before The Dinosaurs");
		users[2] = new Song();users[2].setId(3);users[2].setName("Friends - Before The Dinosaurs");
		users[3] = new Song();users[3].setId(4);users[3].setName("In Love With The World - Before The Dinosaurs");
		users[4] = new Song();users[4].setId(5);users[4].setName("What It S Like - Before The Dinosaurs");
		users[5] = new Song();users[5].setId(6);users[5].setName("Into The Wild - Before The Dinosaurs");
		users[6] = new Song();users[6].setId(7);users[6].setName("Masterpiece - Before The Dinosaurs");
		users[7] = new Song();users[7].setId(8);users[7].setName("Where The Wild Roses Grow - Before The Dinosaurs");
		users[8] = new Song();users[8].setId(9);users[8].setName("America - Before The Dinosaurs");
		users[9] = new Song();users[9].setId(10);users[9].setName("Recipe - Before The Dinosaurs");
		users[10] = new Song();users[10].setId(11);users[10].setName("Superhuman - Before The Dinosaurs");
		users[11] = new Song();users[11].setId(12);users[11].setName("Before The Dinosaurs - Before The Dinosaurs");
		users[12] = new Song();users[12].setId(13);users[12].setName("Glass Bone Crash - Columbine");
		users[13] = new Song();users[13].setId(14);users[13].setName("Little Louie - Columbine");
		users[14] = new Song();users[14].setId(15);users[14].setName("Something From Nothing - Columbine");
		users[15] = new Song();users[15].setId(16);users[15].setName("Stay The Same - Columbine");
		users[16] = new Song();users[16].setId(17);users[16].setName("Picture Of Moon - Columbine");
		users[17] = new Song();users[17].setId(18);users[17].setName("You Are The Reason - Columbine");
		users[18] = new Song();users[18].setId(19);users[18].setName("Song For Sophie");
		users[19] = new Song();users[19].setId(20);users[19].setName("I Will Love You Monday - Columbine");
		users[20] = new Song();users[20].setId(21);users[20].setName("Clean Hands - Columbine");
		users[21] = new Song();users[21].setId(22);users[21].setName("Are You For Sale - Columbine");
		users[22] = new Song();users[22].setId(23);users[22].setName("Antony - Columbine");
		users[23] = new Song();users[23].setId(24);users[23].setName("Lulla Goodbye - Columbine");
        
        
        helloTxt = (TextView)findViewById(R.id.textView1);
        helloTxt.setText(readTxt(1));

        adapter = new SpinAdapter(lyrics.this, android.R.layout.simple_spinner_item, users);
        mySpinner = (Spinner) findViewById(R.id.spinner1);
        mySpinner.setAdapter(adapter);
        mySpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                Song user = adapter.getItem(position);
                Toast.makeText(lyrics.this, "Song: " + user.getName(),
                    Toast.LENGTH_SHORT).show();
                helloTxt.setText(readTxt(position));
                RelativeLayout relLay = (RelativeLayout) findViewById(R.id.rLayLyr);
                relLay.setBackgroundResource(backgrounds[rgenerator.nextInt(backgrounds.length)]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapter) {  }
        });
        

    
	}
	
	
	private String readTxt(int a){

	     InputStream inputStream = getResources().openRawResource(songsText[a]);
	     
	     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	     
	     int i;
	  try {
	   i = inputStream.read();
	   while (i != -1)
	      {
	       byteArrayOutputStream.write(i);
	       i = inputStream.read();
	      }
	      inputStream.close();
	  } catch (IOException e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	  }
	  
	     return byteArrayOutputStream.toString();
	  }
	

	
	public class Song{

	    private int _id;
	    private String _name;

	    public Song(){
	        this._id = 0;
	        this._name = "";
	    }

	    public void setId(int id){
	        this._id = id;
	    }

	    public int getId(){
	        return this._id;
	    }

	    public void setName(String name){
	        this._name = name;
	    }

	    public String getName(){
	        return this._name;
	    }
	}
	
	public class SpinAdapter extends ArrayAdapter<Song>{

	    private Context context;
	    private Song[] values;

	    public SpinAdapter(Context context, int textViewResourceId,
	    		Song[] values) {
	        super(context, textViewResourceId, values);
	        this.context = context;
	        this.values = values;
	    }

	    public int getCount(){
	       return values.length;
	    }

	    public Song getItem(int position){
	       return values[position];
	    }

	    public long getItemId(int position){
	       return position;
	    }


	    @Override
	    public View getView(int position, View convertView, ViewGroup parent) {
	        TextView label = new TextView(context);
	        label.setTextColor(Color.BLACK);
	        label.setText(values[position].getName());
	        return label;
	    }

	    @Override
	    public View getDropDownView(int position, View convertView,
	            ViewGroup parent) {
	        TextView label = new TextView(context);
	        label.setTextColor(Color.BLACK);
	        label.setTextSize(25);
	        label.setGravity(Gravity.CENTER);
	        label.setText(values[position].getName());

	        return label;
	    }
	}
	
	
}