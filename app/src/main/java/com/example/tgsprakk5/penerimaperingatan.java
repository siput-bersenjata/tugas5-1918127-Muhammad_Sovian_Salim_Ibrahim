package com.example.tgsprakk5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

public class penerimaperingatan extends BroadcastReceiver {
    //ketika menerima broadcast dari alarm, maka akan segera memunculkan notifikasi
    @Override
    public void onReceive(Context context, Intent intent) {
        com.example.tgsprakk5.pembantunotifikasi notificationHelper = new com.example.tgsprakk5.pembantunotifikasi(context);
        NotificationCompat.Builder nb = notificationHelper.getChannelNotification();
        notificationHelper.getManager().notify(1, nb.build());
    }
}

