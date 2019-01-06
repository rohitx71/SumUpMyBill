package servicetax.androidtaxcalculator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class TaxesList extends MainActivity {

    String[] web = {
            "McDonalds",
            "KFC",
            "Burger King",
            "Dominos",
            "Pizza Hut",
            "Subway",
            "MOD",
            "CCD",
            "StarBucks",
            "McCafe",
            "TacoBell"
    };
    int[] imageId = {
            R.drawable.mcd,
            R.drawable.kfc,
            R.drawable.burger_king_logo,
            R.drawable.dominos,
            R.drawable.pizzahut,
            R.drawable.subway,
            R.drawable.mod,
            R.drawable.ccd,
            R.drawable.starbucks,
            R.drawable.mccafe,
            R.drawable.tacobell,

    };
    String[] values = {
            "20.45%",
            "20.45%",
            "20.45%",
            "19.88%",
            "32.11%",
            "12.33%",
            "21.66%",
            "20.45%",
            "11.99%",
            "22.11%",
            "19.54%",

    };



    ListView lstDash2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       LayoutInflater layoutInflater=(LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView=layoutInflater.inflate(R.layout.activity_taxes_list,null,false);
//fab.setVisibility(View.INVISIBLE);
        //overridePendingTransition(R.anim.slideup,R.anim.slidedown);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
*/      drawer.addView(contentView,0);
        getSupportActionBar().setTitle("List of Taxes");
        lstDash2 = (ListView) findViewById(R.id.lst_dash2);

        ListAdapter2 listAdapter2 = new ListAdapter2(TaxesList.this, imageId, values);

        lstDash2.setAdapter(listAdapter2);
        lstDash2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TaxesList.this, Calculate.class);

                //String name= (String) parent.getItemAtPosition(position);
                String name = web[position];

                //Toast.makeText(TaxesList.this, "gello", Toast.LENGTH_SHORT).show();
                if (name == "McDonalds") {
                    intent.putExtra("img", R.drawable.mcd);

                } else if (name == "KFC") {
                    intent.putExtra("img", R.drawable.kfc);
                } else if (name == "Burger King") {
                    intent.putExtra("img", R.drawable.burger_king_logo);
                } else if (name == "Dominos") {
                    intent.putExtra("img", R.drawable.dominos);
                } else if (name == "Pizza Hut") {
                    intent.putExtra("img", R.drawable.pizzahut);
                } else if (name == "Subway") {
                    intent.putExtra("img", R.drawable.subway1);
                } else if (name == "CCD") {
                    intent.putExtra("img", R.drawable.ccd);
                } else if (name == "MOD") {
                    intent.putExtra("img", R.drawable.mod);
                } else if (name == "StarBucks") {
                    intent.putExtra("img", R.drawable.starbucks);
                } else if (name == "McCafe") {
                    intent.putExtra("img", R.drawable.mccafe);
                } else if (name == "TacoBell") {
                    intent.putExtra("img", R.drawable.tacobell);
                } else {
                    Toast.makeText(TaxesList.this, "Wrong one bro", Toast.LENGTH_SHORT).show();
                }
                intent.putExtra("name", name);
               // intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                // overridePendingTransition(R.anim.slidedown, R.anim.slideup);
            }
        });

    }

    /*@Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       *//* if (id == R.id.action_settings) {
            return true;
        }*//*

        return super.onOptionsItemSelected(item);
    }*/

   /* @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_feedback) {
            Intent intent=new Intent(TaxesList.this,Feedback.class);
            startActivity(intent);

        }*//* else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        }*//* else if (id == R.id.nav_rate) {
            try {
                Intent intent = new Intent("android.Intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.adeebhat.rabbitsvilla"));
                startActivity(intent);
            }catch (Exception e){
                Toast.makeText(TaxesList.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }*/
    class ListAdapter2 extends BaseAdapter {

        int[] imgDash;
        String[] txtDash;
        Activity context;

        ListAdapter2(Activity activity, int[] imgDash, String[] txtDash) {
            this.imgDash = imgDash;
            this.context = activity;
            this.txtDash = txtDash;

        }

        @Override
        public int getCount() {
            return txtDash.length;
        }

        @Override
        public Object getItem(int position) {
            return txtDash;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater layoutInflater = context.getLayoutInflater();
            View view = layoutInflater.inflate(R.layout.list_taxes_list, null, true);
            TextView txtTitle = (TextView) view.findViewById(R.id.txt_dash);

            ImageView imageView = (ImageView) view.findViewById(R.id.img_dash);
            txtTitle.setText(txtDash[position]);

            imageView.setImageResource(imageId[position]);

            return view;
        }
    }
}
