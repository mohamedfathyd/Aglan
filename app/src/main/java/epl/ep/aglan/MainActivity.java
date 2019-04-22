package epl.ep.aglan;

import android.Manifest;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static android.os.Build.VERSION_CODES.P;

public class MainActivity extends AppCompatActivity {
    private static final int PERMISSION_REQUEST_READ_PHONE_STATE=1;
    private static final int PERMISSION_MODIFY_PHONE_STATE=1;
    MediaPlayer mediaPlayer = null;
    private final Random mRandom = new Random();
    int delayMillis;
    Handler handler;
    CountDownTimer countDownTimer;
    int x=-1;
   int time=80;
    Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && !notificationManager.isNotificationPolicyAccessGranted()) {

            Intent intent = new Intent(
                    android.provider.Settings
                            .ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS);

            startActivity(intent);
            AudioManager audioManager =
                    (AudioManager) getSystemService(Context.AUDIO_SERVICE);
            audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);

        }
        RadioGroup  group= (RadioGroup) findViewById(R.id.radio);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                View radioButton = radioGroup.findViewById(i);
                int index = radioGroup.indexOfChild(radioButton);
               // Toast.makeText(MainActivity.this,index+"",Toast.LENGTH_LONG).show();
                if(index==0){
                    time=80;
                }
                if(index==1){
                    time=140;
                }
                if(index==2){
                    time=200;
                }
                if(index==3){
                    time=260;
                }
                if(index==4){
                    time=320;
                }
            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            if (checkSelfPermission(Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_DENIED || checkSelfPermission(Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_DENIED &&checkSelfPermission(Manifest.permission.MODIFY_PHONE_STATE) == PackageManager.PERMISSION_DENIED) {
                String[] permissions = {Manifest.permission.READ_PHONE_STATE, Manifest.permission.CALL_PHONE,Manifest.permission.MODIFY_PHONE_STATE};
                requestPermissions(permissions,PERMISSION_REQUEST_READ_PHONE_STATE);
            }

        }

       repeat();
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_READ_PHONE_STATE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permission granted: " + PERMISSION_REQUEST_READ_PHONE_STATE, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Permission NOT granted: " + PERMISSION_REQUEST_READ_PHONE_STATE, Toast.LENGTH_SHORT).show();
                }

            }
            return;
            }
        }


        public void repeat(){
            final int counter=(time)*1000;
            countDownTimer=   new CountDownTimer(counter, 1000) {

                public void onTick(long millisUntilFinished) {
                    long g=(millisUntilFinished / 1000);
                   // Toast.makeText(MainActivity.this , ""+g,Toast.LENGTH_LONG).show();
                    //here you can have your logic to set text to edittext
                    if(g==1){
                        x++;
                        if(x==26){
                            x=0;
                        }
                        startplayer(x);
                    }
                }

                public void onFinish() {

                }

            }.start();
        }
        public void startplayer(int a){
        if(a==0){
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.doaa);
          alarm();
        }
        else if(a==1){
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.e);
            alarm();
            }
        else if(a==2){
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.b);
            alarm();
        }
        else if(a==3){
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.c);
            alarm();
        }
        else if(a==4){
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.d);
            alarm();
        }
        else if(a==5){
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.a);
            alarm();
        }
        else if(a==6){
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.f);
            alarm();
        }
        else if(a==7){
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.g);
            alarm();
        }
        else if(a==8){
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.h);
            alarm();
        }
        else if(a==9){
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.i);
            alarm();
        }
        else if(a==10){
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.j);
            alarm();
        }
        else if(a==11){
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.k);
            alarm();
        }
        else if(a==12){
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.l);
            alarm();
        }
        else if(a==13){
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.m);
            alarm();
        }
        else if(a==14){
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.n);
            alarm();
        }
        else if(a==15){
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.o);
            alarm();
        }
        else if(a==16){
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.p);
            alarm();
        }
        else if(a==17){
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.q);
            alarm();
        }
        else if(a==18){
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.r);
            alarm();
        }
        else if(a==19){
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.s);  alarm();
        }
        else if(a==20){
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.t);   alarm();
        }
        else if(a==21){
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.u);   alarm();
        }
        else if(a==22){
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.v);   alarm();
        }
        else if(a==23){
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.w);   alarm();
        }
        else if(a==24){
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.x);   alarm();
        }
        else if(a==25){
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.y);  alarm();
        }
        else if(a==26){
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.z);  alarm();
        }

            else{
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.e);  alarm();

        }


            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                @Override
                public void onCompletion(MediaPlayer mp) {
                  repeat();
                }
            });
        }
        public void alarm(){
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.tast,
                    (ViewGroup) findViewById(R.id.toast_layout_root));

            ImageView image = (ImageView) layout.findViewById(R.id.image);
            image.setImageResource(R.drawable.logo);
            TextView text = (TextView) layout.findViewById(R.id.text);
            text.setText("حافظ على سلامتك وسلامة غيرك ^_^");

            Toast toast = new Toast(getApplicationContext());
            toast.setGravity(Gravity.TOP, 0, 0);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(layout);
            toast.show();
        }
    @Override
    public void onDestroy()
    {
        super.onDestroy();

    }

}
