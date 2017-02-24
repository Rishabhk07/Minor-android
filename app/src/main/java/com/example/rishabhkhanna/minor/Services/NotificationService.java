package com.example.rishabhkhanna.minor.Services;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

import com.example.rishabhkhanna.minor.R;
import com.example.rishabhkhanna.minor.models.Notifications;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.Map;

public class NotificationService extends FirebaseMessagingService{

    private String TAG = "Service";

    public NotificationService() {
    }
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Map<String, String> data = remoteMessage.getData();

        // [START_EXCLUDE]
        // There are two types of messages data messages and notification messages. Data messages are handled
        // here in onMessageReceived whether the app is in the foreground or background. Data messages are the type
        // traditionally used with GCM. Notification messages are only received here in onMessageReceived when the app
        // is in the foreground. When the app is in the background an automatically generated notification is displayed.
        // When the user taps on the notification they are returned to the app. Messages containing both notification
        // and data payloads are treated as notification messages. The Firebase console always sends notification
        // messages. For more see: https://firebase.google.com/docs/cloud-messaging/concept-options
        // [END_EXCLUDE]

        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d(TAG, remoteMessage.getFrom());

        Log.d("rishabh" , data.get("url"));

        NotificationCompat.BigPictureStyle notiStyle = new NotificationCompat.BigPictureStyle();

        try {
            notiStyle.bigPicture(Picasso.with(getApplicationContext()).load(data.get("url")).get());
        } catch (IOException e) {
            e.printStackTrace();
        }

        String name = data.get("movie_name");
        String price = data.get("price");
        String url = data.get("url");

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.log)
                        .setContentTitle(data.get("title"))
                        .setContentText("New Price of the movie you just viewed "+ data.get("movie_name") + " is " + data.get("price")).setDefaults(Notification.DEFAULT_SOUND).setStyle(notiStyle);







        NotificationManager mgr = (NotificationManager) getSystemService(NotificationService.NOTIFICATION_SERVICE);
        mgr.notify(0 , mBuilder.build());

//        Notifications.notify.add(new Notifications.notification(name , price , url));
//        Log.d(String.valueOf(Notifications.notify), "YO");






        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }



}
