package sg.edu.rp.c347.id19007966.demoalarmmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button buttonSetAlarm;
    AlarmManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonSetAlarm = findViewById(R.id.buttonAlarm);

        buttonSetAlarm.setOnClickListener(view -> {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.SECOND, 5);
            Intent intent = new Intent(MainActivity.this, AlarmReceiverActivity.class);
            int requestCode = 12345;
            PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, requestCode, intent, PendingIntent.FLAG_CANCEL_CURRENT);
            manager = (AlarmManager) getSystemService(Activity.ALARM_SERVICE);
            manager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
        });


    }
}