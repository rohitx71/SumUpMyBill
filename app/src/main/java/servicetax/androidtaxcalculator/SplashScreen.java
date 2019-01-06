package servicetax.androidtaxcalculator;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class SplashScreen extends AppCompatActivity {

    /**
     * Duration of wait
     **/
    private final int SPLASH_DISPLAY_LENGTH = 1000;


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Window window=getWindow();

        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(SplashScreen.this.getResources().getColor(R.color.colorToolbar));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Intent intent = new Intent(SplashScreen.this, Dashboard.class);
                Intent intent = new Intent(SplashScreen.this, ViewPagerActivity.class);
                intent.putExtra("parentActivity", SplashScreen.class.toString());
                startActivity(intent);
                SplashScreen.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
        //this.finish();

    }
}
