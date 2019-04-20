package epl.eldaf_electrony.aglan;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.AudioManager;
import android.provider.ContactsContract;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;
import java.lang.reflect.Method;

        public class IncomingCallReceiver extends BroadcastReceiver {
            @Override
            public void onReceive(Context context, Intent intent) {

                ITelephony telephonyService;
                try {
                    String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
                    String number = intent.getExtras().getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
                    AudioManager am;
                    am= (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
                    if (state.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_RINGING)) {
                        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
                        try {
                            Method m = tm.getClass().getDeclaredMethod("getITelephony");

                            m.setAccessible(true);
                            telephonyService = (ITelephony) m.invoke(tm);

                            if ((number != null)) {
                                telephonyService.endCall();
                                Toast.makeText(context, "Ending the call from: " + number, Toast.LENGTH_SHORT).show();
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        Toast.makeText(context, "Ring " + number, Toast.LENGTH_SHORT).show();


//For Normal mode


//For Silent mode
                        am.setRingerMode(AudioManager.RINGER_MODE_SILENT);

//For Vibrate mode


                    }
                    if (state.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_OFFHOOK)) {
                        Toast.makeText(context, "Answered " + number, Toast.LENGTH_SHORT).show();
                        am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                    }
                    if (state.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_IDLE)) {
                        Toast.makeText(context, "Idle " + number, Toast.LENGTH_SHORT).show();
                        am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }