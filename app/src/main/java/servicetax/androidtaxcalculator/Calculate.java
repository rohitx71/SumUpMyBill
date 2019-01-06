package servicetax.androidtaxcalculator;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Calculate extends AppCompatActivity {

    Button btnCalculate;
    EditText edt_amount;
    float total_amount;
    TextView txt_total,txt_service,txt_vat,txt_other,txt_kss,txt_service_label,txt_vat_label,txt_other_label,txt_kss_label;
    float service_tax,vat,other_tax,krishi_kalyan;
    ImageView img_calculate,img_back;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        //overridePendingTransition(R.anim.slidedown,R.anim.slideup);
       // setDisplayHomeAsUpEnabled(true);
       // getSupportActionBar().setTitle("Calculate Bill");


        final Drawable upArrow = getResources().getDrawable(R.drawable.material_back);
        upArrow.setColorFilter(getResources().getColor(android.R.color.white), PorterDuff.Mode.SRC_ATOP);


        edt_amount = (EditText) findViewById(R.id.edt_amt);
        txt_total = (TextView) findViewById(R.id.txt_total);
        btnCalculate = (Button) findViewById(R.id.btn_calculate);
        img_calculate = (ImageView) findViewById(R.id.img_calculate);
        img_back = (ImageView) findViewById(R.id.back_button);
        txt_service = (TextView) findViewById(R.id.txt_service);
        txt_vat = (TextView) findViewById(R.id.txt_vat);
        txt_kss = (TextView) findViewById(R.id.txt_kkc);
        txt_other = (TextView) findViewById(R.id.txt_other);

        txt_service_label = (TextView) findViewById(R.id.txt_service_label);
        txt_vat_label  = (TextView) findViewById(R.id.txt_vat_label);
        txt_kss_label  = (TextView) findViewById(R.id.txt_kkc_label);
        txt_other_label  = (TextView) findViewById(R.id.txt_other_label);

        img_back.setImageDrawable(upArrow);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calculate.this.finish();
            }
        });
        //scrollView = (ScrollView) findViewById(R.id.scroll_view);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String name = extras.getString("name");
            int img = extras.getInt("img");
            taxesRate(name);
            img_calculate.setImageResource(img);
        }


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String data = edt_amount.getText().toString();
                if (data == "" || data.equals("") || data.equals("0")) {
                    edt_amount.setError("Enter a valid range");

                } else {

                    int entered_amt = Integer.parseInt(data);

                    float service,vatt,other,kkc;

                    service= Float.parseFloat(new DecimalFormat("##.###").format(entered_amt * service_tax / 100));
                    vatt=Float.parseFloat (new DecimalFormat("##.###").format(entered_amt * vat / 100));
                    other=Float.parseFloat (new DecimalFormat("##.###").format(entered_amt * other_tax / 100));
                    kkc= Float.parseFloat (new DecimalFormat("##.###").format(entered_amt * krishi_kalyan / 100));

                    txt_service.setText("Rs. "+service);
                    txt_vat.setText("Rs."+vatt);
                    txt_other.setText("Rs. "+other);
                    txt_kss.setText("Rs. "+kkc);


                    total_amount = entered_amt +
                            service +
                            vatt +
                            other +
                            kkc;

                    total_amount=Float.parseFloat(new DecimalFormat("##.###").format(total_amount));

                    txt_total.setText("Rs. " + total_amount);
                  /*  scrollView.post(new Runnable() {

                        @Override
                        public void run() {
                            scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                        }
                    });*/

                }
            }
        });
    }


    void taxesRate(String name){
        if(name.equals("McDonalds")){
            service_tax=10f;
            vat=12.5f;
            other_tax=5.8f;
            krishi_kalyan=0.2f;

        }
        else if(name.equals("KFC")){
            service_tax=10f;
            vat=12.5f;
            other_tax=5.8f;
            krishi_kalyan=0.2f;
        }
        else if(name.equals("Burger King")){
            service_tax=10f;
            vat=12.5f;
            other_tax=5.8f;
            krishi_kalyan=0.2f;
        }
        else if(name.equals("Dominos")){
            service_tax=10f;
            vat=12.5f;
            other_tax=5.8f;
            krishi_kalyan=0.2f;
        }
        else if(name.equals("Pizza Hut")){
            service_tax=10f;
            vat=12.5f;
            other_tax=5.8f;
            krishi_kalyan=0.2f;
        }
        else if(name.equals("Subway")){
            service_tax=10f;
            vat=12.5f;
            other_tax=5.8f;
            krishi_kalyan=0.2f;
        }
        else if(name.equals("CCD")){
            service_tax=10f;
            vat=12.5f;
            other_tax=5.8f;
            krishi_kalyan=0.2f;
        }
        else if(name.equals("MOD")){
            service_tax=10f;
            vat=12.5f;
            other_tax=5.8f;
            krishi_kalyan=0.2f;
        }
        else if(name.equals("StarBucks")){
            service_tax=10f;
            vat=12.5f;
            other_tax=5.8f;
            krishi_kalyan=0.2f;
        }
        else if(name.equals("McCafe")){
            service_tax=10f;
            vat=12.5f;
            other_tax=5.8f;
            krishi_kalyan=0.2f;
        }
        else if(name.equals("TacoBell")){
            service_tax=10f;
            vat=12.5f;
            other_tax=5.8f;
            krishi_kalyan=0.2f;
        }
        else{
            service_tax=10f;
            vat=12.5f;
            other_tax=5.8f;
            krishi_kalyan=0.2f;
        }
        setTaxesLabels();
    }

    void setTaxesLabels(){
        txt_service_label.setText("Service Taxes ("+service_tax+"%)");
        txt_vat_label.setText("VAT ("+vat+"%)");
        txt_other_label.setText("Other Taxes ("+other_tax+"%)");
        txt_kss_label.setText("Krishi Kalyan Cess ("+krishi_kalyan+"%)");


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
