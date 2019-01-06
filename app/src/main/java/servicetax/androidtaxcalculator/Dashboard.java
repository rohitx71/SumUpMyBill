package servicetax.androidtaxcalculator;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.content.IntentCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class Dashboard extends MainActivity implements MyMediatorIterface{

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

    int[] bannerId= {
            R.drawable.mcd_banner,
            R.drawable.kfc_banner,
            R.drawable.burger_king_banner,
            R.drawable.dominos_banner,
            R.drawable.pizzahut_banner,
            R.drawable.subway_banner,
            R.drawable.mod_banner,
            R.drawable.ccd_banner,
            R.drawable.starbucks_banner,
            R.drawable.mccafe_banner,
            R.drawable.tacobell_banner,

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

   /* int[] imageId = {
            R.drawable.dominos,
            R.drawable.dominos,
            R.drawable.dominos,
            R.drawable.dominos,
            R.drawable.dominos,
            R.drawable.dominos,
            R.drawable.dominos,
            R.drawable.dominos,
            R.drawable.dominos,
            R.drawable.dominos

    };*/

    ListView lstDash;
    RecyclerView recDash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = layoutInflater.inflate(R.layout.activity_dashboard2, null, false);


       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

       /* FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Snackbar.make(v, "What you looking at?", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
                Intent intent = new Intent(Dashboard.this, TaxesList.class);
                startActivity(intent);
            }
        });*/

       /* DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);*/
        drawer.addView(contentView, 0);
        getSupportActionBar().setTitle("Select an Outlet");
        recDash = (RecyclerView) findViewById(R.id.lst_dash2);
        recDash.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(linearLayoutManager.VERTICAL);
        recDash.setLayoutManager(linearLayoutManager);

        RecyclerAdapter recyclerAdapter=new RecyclerAdapter(imageId,web,values);
recDash.setAdapter(recyclerAdapter);


        /*lstDash = (ListView) findViewById(R.id.lst_dash);
        ListAdapter listAdapter = new ListAdapter(Dashboard.this, imageId, web);

        lstDash.setAdapter(listAdapter);
        lstDash.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Dashboard.this, Calculate.class);

                //String name= (String) parent.getItemAtPosition(position);
                String name = web[position];


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

                }
                intent.putExtra("name", name);
                // intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                // overridePendingTransition(R.anim.slidedown, R.anim.slideup);
            }
        });*/


    }

    @Override
    protected void onResume() {
        super.onResume();

        Bundle bundle = getIntent().getExtras();

        // if(bundle!=null);
       /* if (bundle.get("parentActivity").equals(SplashScreen.class.toString())){}
          //  drawer.openDrawer(GravityCompat.START);
            else if(bundle.get("parentActivity").equals(ViewPagerActivity.class.toString()))
           // drawer.openDrawer(GravityCompat.START);
        else{
            //drawer.closeDrawer(GravityCompat.END);
        }*/
    }

    /*@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
           finishAffinity();
           // super.onBackPressed();
        }
    }*/

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press Back again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    @Override
    public void userItemClick(int pos) {
        Toast.makeText(getApplicationContext(), "Clicked User : " + web[pos], Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(Dashboard.this, Calculate.class);

        //String name= (String) parent.getItemAtPosition(position);
        String name = web[pos];


        if (name == "McDonalds") {
            intent.putExtra("img", R.drawable.mcd_banner);

        } else if (name == "KFC") {
            intent.putExtra("img", R.drawable.kfc_banner);
        } else if (name == "Burger King") {
            intent.putExtra("img", R.drawable.burger_king_banner);
        } else if (name == "Dominos") {
            intent.putExtra("img", R.drawable.dominos_banner);
        } else if (name == "Pizza Hut") {
            intent.putExtra("img", R.drawable.pizzahut_banner);
        } else if (name == "Subway") {
            intent.putExtra("img", R.drawable.subway_banner);
        } else if (name == "CCD") {
            intent.putExtra("img", R.drawable.ccd_banner);
        } else if (name == "MOD") {
            intent.putExtra("img", R.drawable.mod_banner);
        } else if (name == "StarBucks") {
            intent.putExtra("img", R.drawable.starbucks_banner);
        } else if (name == "McCafe") {
            intent.putExtra("img", R.drawable.mccafe_banner);
        } else if (name == "TacoBell") {
            intent.putExtra("img", R.drawable.tacobell_banner);
        } else {

        }
        intent.putExtra("name", name);
        // intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        // overridePendingTransition(R.anim.slidedown, R.anim.slideup);
    }


    /* @Override
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
 //        if (id == R.id.action_settings) {
 //            return true;
 //        }

         return super.onOptionsItemSelected(item);
     }

     @SuppressWarnings("StatementWithEmptyBody")
     @Override
     public boolean onNavigationItemSelected(MenuItem item) {
         // Handle navigation view item clicks here.
         int id = item.getItemId();

         if (id == R.id.nav_camera) {
             // Handle the camera action
         } else if (id == R.id.nav_feedback) {
             Intent intent = new Intent(Dashboard.this, Feedback.class);
             startActivity(intent);

         } *//*else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } *//* else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_rate) {
            try {
                Toast.makeText(Dashboard.this, "Dashboard", Toast.LENGTH_SHORT).show();
                Dashboard.this.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.adeebhat.rabbitsvilla")));
                //Intent intent = new Intent("android.Intent.action.VIEW", Uri.parse("market://details?id=com.adeebhat.rabbitsvilla"));
                //startActivity(Intent.createChooser(intent, "dialogTitle"));

            } catch (Exception e) {
                Toast.makeText(Dashboard.this, e.getMessage().toString(), Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
*/
    class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>{
        int[] imgDash;
        String[] txtDash;
        String[] taxes;






        RecyclerAdapter(int[] imgDash, String[] txtDash,String[] taxes) {
            this.imgDash = imgDash;

            this.txtDash = txtDash;
            this.taxes=taxes;

        }

        @Override
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_dashboard,parent,false);

            return new RecyclerViewHolder(itemView,parent.getContext());
        }

        @Override
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {
            holder.txtTitle.setText(txtDash[position]);

            holder.imageView.setImageResource(imageId[position]);

            holder.txtTaxes.setText(taxes[position]);
        }

        @Override
        public int getItemCount() {
            return txtDash.length;
        }
        class RecyclerViewHolder extends RecyclerView.ViewHolder{

            protected TextView txtTitle,txtTaxes;
            protected ImageView imageView;

            public RecyclerViewHolder(View itemView,final Context context) {
                super(itemView);
                txtTitle = (TextView) itemView.findViewById(R.id.txt_dash);

                txtTaxes = (TextView) itemView.findViewById(R.id.txt_value);

                imageView = (ImageView) itemView.findViewById(R.id.img_dash);


                LinearLayout linearLayout=(LinearLayout) itemView.findViewById(R.id.linear_list);
                linearLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ((Dashboard)context).userItemClick(getAdapterPosition());
                    }
                });
            }
        }
    }


    /*class ListAdapter extends BaseAdapter {

        int[] imgDash;
        String[] txtDash;
        Activity context;

        ListAdapter(Activity activity, int[] imgDash, String[] txtDash) {
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
            View view = layoutInflater.inflate(R.layout.list_dashboard, null, true);
            TextView txtTitle = (TextView) view.findViewById(R.id.txt_dash);

            ImageView imageView = (ImageView) view.findViewById(R.id.img_dash);
            txtTitle.setText(txtDash[position]);

            imageView.setImageResource(imageId[position]);

            return view;
        }
    }*/
}
