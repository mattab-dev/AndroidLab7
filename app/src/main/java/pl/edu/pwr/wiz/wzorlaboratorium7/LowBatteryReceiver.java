package pl.edu.pwr.wiz.wzorlaboratorium7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class LowBatteryReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Podłącz ładowarkę!", Toast.LENGTH_LONG).show();
    }
}
