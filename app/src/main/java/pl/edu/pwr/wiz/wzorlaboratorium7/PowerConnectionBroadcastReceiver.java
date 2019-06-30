package pl.edu.pwr.wiz.wzorlaboratorium7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class PowerConnectionBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)) {
            Intent charging = new Intent(context, ChargingService.class);
            context.startService(charging);
        } else {
            Intent charging = new Intent(context, ChargingService.class);
            context.stopService(charging);
        }
    }
}
