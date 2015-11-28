package sk.cassomedia.eldermonitor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NewUserActivity extends AppCompatActivity {

    TextView text;
    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        name = (EditText) findViewById(R.id.name);
        text = (TextView) findViewById(R.id.signinlabel);
    }

    public void buttonOnClick(View view) {
        String input = name.getText().toString();

        CheckNewUser newUser = new CheckNewUser();

        newUser.userCreate(input);

        Intent intent = new Intent(this,ExistingUserActivity.class);
        startActivity(intent);
    }
}
