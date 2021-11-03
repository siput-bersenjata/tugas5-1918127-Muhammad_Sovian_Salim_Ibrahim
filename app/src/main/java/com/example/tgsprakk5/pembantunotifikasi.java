package com.example.tgsprakk5;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class pembantunotifikasi extends ContextWrapper {
    public static final String channelID = "channelID";
    public static final String channelName = "Channel Name";

    private NotificationManager mManager;

    //membuat dan membangun channel notifikasi
    public pembantunotifikasi(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannel();
        }
    }



    //mendeskripsikan channel notifikasi yang akan dibangun
    @TargetApi(Build.VERSION_CODES.O)
    private void createChannel() {
        NotificationChannel channel = new NotificationChannel(
                channelID,
                channelName,
                //tingkat importance = high ( penting sekali )
                NotificationManager.IMPORTANCE_HIGH
        );

        getManager().createNotificationChannel(channel);
    }

    //membuka izin pengaturan dari aplikasi untuk memulai service notifikasi
    public NotificationManager getManager() {
        if (mManager == null) {
            mManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }

        return mManager;
    }

    //builder yang akan membuat notifikasi tampil
    public NotificationCompat.Builder getChannelNotification() {
        return new NotificationCompat.Builder(getApplicationContext(), channelID)
                .setContentTitle("Ini Notifikasi!")
                .setContentText("Ini Isi Notifikasi ")
                .setSmallIcon(R.drawable.ic_notif);
    }

}
