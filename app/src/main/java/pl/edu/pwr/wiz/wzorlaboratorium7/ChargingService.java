package pl.edu.pwr.wiz.wzorlaboratorium7;

import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.annotation.Nullable;

public class ChargingService extends IntentService {
    private Integer chargingTime = 3600/60;
    final static int CHARGING_ID = 2;

    public ChargingService() {
        super("ChargingService");
    };

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        while(true) {
            Intent notificationIntent = new Intent(this, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

            /* Budujemy notyfikację */
            Notification notification = new Notification.Builder(this)
                    .setContentTitle(getText(R.string.charger_title))
                    .setContentText(getText(R.string.charger_body) + chargingTime.toString() + "minut")
                    .setSmallIcon(R.drawable.ic_av_timer_black_24dp)
                    .setContentIntent(pendingIntent)
                    .build();

            /* Startujemy na pierwszym planie, aby nie dało jej się zamknąć */
            startForeground(CHARGING_ID, notification);

            try {
                Thread.sleep(60000);
                chargingTime -= 1;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

    }
}
