package net.hockeyapp.demo.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.distribute.Distribute;
import com.microsoft.appcenter.push.Push;

import net.hockeyapp.android.UpdateManager;

public class MainActivity extends AppCompatActivity {

    private boolean mScreenshotActivitySet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        {
            final Button updateButton = (Button) findViewById(R.id.ha_update_button);
            updateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    UpdateManager.register(MainActivity.this);
                }
            });
        }
        {
            final Button acUpdateButton = (Button) findViewById(R.id.ac_update_button);
            acUpdateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppCenter.start(getApplication(), "e3d6960f-42d2-4cda-980c-a917c7516819", Push.class, Distribute.class);
                }
            });
        }
        {
            final EditText versionText = findViewById(R.id.label_version);
            versionText.setText(BuildConfig.VERSION_NAME + " (" + BuildConfig.VERSION_CODE + ")");
        }
    }
}
