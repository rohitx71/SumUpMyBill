package servicetax.androidtaxcalculator;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class ViewPagerActivity extends AppCompatActivity {

    Animation animation;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        Window window=getWindow();

        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ViewPagerActivity.this.getResources().getColor(R.color.colorToolbar));
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new CustomPagerAdapter(this));

        animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slideup);

    }

    class CustomPagerAdapter extends PagerAdapter {

        private Context mContext;
        int values[] ={
                R.drawable.pager1,
                R.drawable.slider_2v2,
                R.drawable.pager3,
                R.drawable.slider_4_v2,
        };

        CustomPagerAdapter(Context context) {
            mContext = context;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            ViewGroup layout=(ViewGroup)layoutInflater.inflate(R.layout.fragment_viewpager,container,false);
            ImageView imageView= (ImageView) layout.findViewById(R.id.img_pager);
         //   ImageButton imgNext=(ImageButton)layout.findViewById(R.id.imgbtn_next);
            ImageButton imgClose=(ImageButton)layout.findViewById(R.id.imgbtn_close);
            final Button btnNext=(Button)layout.findViewById(R.id.btn_next);

            if(position==0)
            imageView.setImageResource(values[0]);
            else if(position==1)
                imageView.setImageResource(values[1]);
            else if(position==2)
                imageView.setImageResource(values[2]);
            else {
                //btnNext.startAnimation(animation);
                btnNext.setVisibility(View.VISIBLE);
                imageView.setImageResource(values[3]);


                btnNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent=new Intent(ViewPagerActivity.this,Dashboard.class);
                        intent.putExtra("parentActivity",ViewPagerActivity.class.toString());

                        startActivity(intent);
                        ViewPagerActivity.this.finish();
                    }
                });

            }
            container.addView(layout);

            imgClose.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Toast1", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(ViewPagerActivity.this,Dashboard.class);
                    intent.putExtra("parentActivity",ViewPagerActivity.class.toString());
                    startActivity(intent);

                    ViewPagerActivity.this.finish();
                }
            });
            return layout;
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);

        }


        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return  String.valueOf(values[position]);
        }
    }
}
