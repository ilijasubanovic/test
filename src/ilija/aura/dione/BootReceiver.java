package ilija.aura.dione;

import android.content.BroadcastReceiver; 
import android.content.Context; 
import android.content.Intent; 
import com.Leadbolt.AdController; 
public class BootReceiver extends BroadcastReceiver { 
   public void onReceive(Context arg0, Intent arg1) { 
   //register the notification on reboot 
AdController mycontroller = new AdController(arg0, 
"791503490"); 
      mycontroller.loadNotification(); 
   } 
} 