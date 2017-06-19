package studio.dowob.spymsg;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;
import android.widget.RemoteViews;

public class NotificationHelper {
    public static final int REQUEST_CODE = 0;

    public static void send(Context context, String title, String text) {
        send(context, title, text, MainActivity.class);
    }

    public static void send(Context context, String title, String text, Class intentClass) {
        int requestCode = REQUEST_CODE;
        int notificationId = 0;
        Intent intent = new Intent(context, intentClass);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                context,
                requestCode,
                intent,
                PendingIntent.FLAG_ONE_SHOT
        );

        RemoteViews rb = new RemoteViews(context.getPackageName(), R.layout.notification_msg);
        rb.setTextViewText(R.id.tv_notificationMsg_title, title);
        rb.setTextViewText(R.id.tv_notificationMsg_content, text);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context);
        notificationBuilder
                .setContent(rb)
                .setSmallIcon(R.drawable.ic_message_light_green_800_24dp)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent);
        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(notificationId, notificationBuilder.build());
    }
}