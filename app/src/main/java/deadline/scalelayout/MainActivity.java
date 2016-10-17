package deadline.scalelayout;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MultiViewPager mViewPager;
    TextView mTop;
    HorizontalScrollView mBottom;
    ScaleLayout mScaleLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }
        mViewPager = (MultiViewPager) findViewById(R.id.scaleLayout_center);
        List<View> views = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            View v = getLayoutInflater().inflate(R.layout.volite_item_view, null, false);
            FrameLayout frameLayout = (FrameLayout) v.findViewById(R.id.child_view);
            frameLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "viewpager image clicked!", Toast.LENGTH_SHORT).show();
                }
            });
            views.add(v);
        }

        MyPagerAdapter mAdapter = new MyPagerAdapter(views);
        mViewPager.setAdapter(mAdapter);

        mScaleLayout = (ScaleLayout) findViewById(R.id.scalelayout);
        mScaleLayout.setSuggestScaleEnable(true);
        mScaleLayout.setSlideScaleEnable(true);
        mScaleLayout.setSlideUpOrDownEnable(true);
        mScaleLayout.setState(ScaleLayout.STATE_CLOSE);
        mScaleLayout.addOnScaleChangedListener(new ScaleLayout.OnScaleChangedListener() {
            @Override
            public void onScaleChanged(float currentScale) {

            }
        });


        mTop = (TextView) findViewById(R.id.scaleLayout_top);
        mTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "top view clicked!", Toast.LENGTH_SHORT).show();
            }
        });

        mBottom = (HorizontalScrollView) findViewById(R.id.scaleLayout_bottom);
        ((ImageView)findViewById(R.id.bottom_image)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "bottom imageView clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
