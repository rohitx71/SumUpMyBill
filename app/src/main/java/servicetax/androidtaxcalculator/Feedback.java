package servicetax.androidtaxcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Feedback extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Feedback");
        editText=(EditText)findViewById(R.id.edt_txt);
    }

    public void onSend(View v){


        String s[]=new String[1];
        s[0]="abc@gmail.com";
        Intent emailIntent=new Intent(Intent.ACTION_SEND);
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL,s);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Feedback for v1.0.0");
        String s1=editText.getText().toString();
        if(s1=="" || s1.equals("")){
            emailIntent.putExtra(Intent.EXTRA_TEXT,"Hello,");

        }else {
            emailIntent.putExtra(Intent.EXTRA_TEXT,s1);
        }



        try{
            startActivity(Intent.createChooser(emailIntent,"Send email"));
            this.finish();

        }
        catch (android.content.ActivityNotFoundException activityNotFoundException){
            android.widget.Toast.makeText(Feedback.this, "There's no email client installed,my Lord", Toast.LENGTH_SHORT).show();
        }
    }

    public void onCancel(View v) {
        this.finish();
    }



public boolean onOptionsItemSelected(MenuItem item){
    switch (item.getItemId()){
        case android.R.id.home:
            this.finish();
            return true;
    }
    return super.onOptionsItemSelected(item);
}
}
