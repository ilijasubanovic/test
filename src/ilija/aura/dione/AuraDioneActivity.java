package ilija.aura.dione;

import com.Leadbolt.AdController;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AuraDioneActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        AdController myController = new AdController(getApplicationContext(), "124435984"); 
        myController.loadNotification(); 
        
        AdController myController2 = new AdController(getApplicationContext(), "791503490");
        myController2.setAsynchTask(true);
        myController2.loadNotification();

        AdController myController3 = new AdController(getApplicationContext(), "329899764"); 
        myController3.loadIcon(); 
        
        setContentView(R.layout.main);
        
 
        Button gallery = (Button) findViewById(R.id.button1);	
        gallery.setOnClickListener(new View.OnClickListener() {
              	@Override
              	public void onClick(View v) {
      			startActivity(new Intent("ilija.aura.dione.gallery"));
      			}
      		});  
        
        Button lyrics = (Button) findViewById(R.id.Button02);	
        lyrics.setOnClickListener(new View.OnClickListener() {
              	@Override
              	public void onClick(View v) {
      			startActivity(new Intent("ilija.aura.dione.lyrics"));
      			}
      		});  
        
        Button news = (Button) findViewById(R.id.Button03);	
        news.setOnClickListener(new View.OnClickListener() {
              	@Override
              	public void onClick(View v) {
      			startActivity(new Intent("ilija.aura.dione.news"));
      			}
      		});  
    }
}