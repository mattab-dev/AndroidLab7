package pl.edu.pwr.wiz.wzorlaboratorium7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class NotificationBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        /* TODO Pobierać dane z intencji i wyświetlać notyfikację systemową z przesłanym tekstem */
        String text = intent.getStringExtra("text");
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }
}