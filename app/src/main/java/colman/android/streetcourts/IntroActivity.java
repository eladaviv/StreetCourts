package colman.android.streetcourts;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import colman.android.streetcourts.R;

import colman.android.streetcourts.feed.MainDrawerActivity;
import colman.android.streetcourts.login.LoginActivity;
import colman.android.streetcourts.model.Model;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        Model.instance.executor.execute(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (Model.instance.isSignedIn()) {
                Model.instance.mainThread.post(() -> {
                    toFeedActivity();
                });
            } else {
                Model.instance.mainThread.post(() -> {
                    toLoginActivity();
                });
            }
        });
    }

    private void toLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void toFeedActivity() {
        Intent intent = new Intent(this, MainDrawerActivity.class);
        startActivity(intent);
        finish();
    }
}