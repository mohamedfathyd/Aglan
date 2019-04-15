package epl.eldaf_electrony.aglan;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final int PERMISSION_REQUEST_READ_PHONE_STATE=1;
    MediaPlayer mediaPlayer = null;
    private final Random mRandom = new Random();
    int delayMillis;
    Handler handler;
    CountDownTimer countDownTimer;
    int x=-1;
    Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Toast.makeText(MainActivity.this,"sdgf",Toast.LENGTH_LONG).show();
            if (checkSelfPermission(Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_DENIED || checkSelfPermission(Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_DENIED) {
                String[] permissions = {Manifest.permission.READ_PHONE_STATE, Manifest.permission.CALL_PHONE};


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

                return;
            }
        }
    }

        public void repeat(){
            final int counter=(40+1)*1000;
            countDownTimer=   new CountDownTimer(counter, 1000) {

                public void onTick(long millisUntilFinished) {
                    long g=(millisUntilFinished / 1000);
                   // Toast.makeText(MainActivity.this , ""+g,Toast.LENGTH_LONG).show();
                    //here you can have your logic to set text to edittext
                    if(g==1){
                        x++;
                        if(x==2){
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
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.ass);
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.tast,
                    (ViewGroup) findViewById(R.id.toast_layout_root));

            ImageView image = (ImageView) layout.findViewById(R.id.image);
            image.setImageResource(R.drawable.logo);
            TextView text = (TextView) layout.findViewById(R.id.text);
            text.setText("Hello! This is a custom toast!");

            Toast toast = new Toast(getApplicationContext());
            toast.setGravity(Gravity.TOP, 0, 0);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(layout);
            toast.show();
        }
        else if(a==1){
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.doaa);
            }
            else{
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.ass);

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
}
