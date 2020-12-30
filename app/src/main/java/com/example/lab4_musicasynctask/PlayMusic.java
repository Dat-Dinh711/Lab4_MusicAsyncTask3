package com.example.lab4_musicasynctask;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class PlayMusic extends AsyncTask<Void, Void, Void> {
    Activity context;
    Button btnPlay, btnStop;
    ImageView imgDisc;
    Animation animation;
    MediaPlayer mediaPlayer;

    public PlayMusic(Activity context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Toast.makeText(context, "Chuẩn bị phát nhạc!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected Void doInBackground(Void... voids) {

        btnPlay = (Button) context.findViewById(R.id.btn_play);
        btnStop = (Button) context.findViewById(R.id.btn_stop);
        imgDisc = (ImageView) context.findViewById(R.id.img_disc);

        animation = AnimationUtils.loadAnimation(context, R.anim.disc_rotate);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(context, R.raw.songgio);
                mediaPlayer.start();
                imgDisc.startAnimation(animation);
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                imgDisc.clearAnimation();
            }
        });

        return null;
    }

}
