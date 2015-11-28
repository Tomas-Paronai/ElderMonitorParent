package sk.cassomedia.eldermonitor;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckNewUser newUser = new CheckNewUser();
        label = (TextView) findViewById(R.id.signinlabel);

        if(newUser.userExists()) {
            Intent intent = new Intent(this,ExistingUserActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this,NewUserActivity.class);
            startActivity(intent);
        }
    }
}
