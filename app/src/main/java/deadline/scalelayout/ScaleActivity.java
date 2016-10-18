package deadline.scalelayout;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import deadline.scalelayout.scaleViewPager.MultiViewPager;

public class ScaleActivity extends AppCompatActivity {

    TouchImageView touchImageView;
    TextView mTop;
    ScaleLayout mScaleLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_scale_main);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }

        mScaleLayout = (ScaleLayout) findViewById(R.id.scale_layout);
        mScaleLayout.setSuggestScaleEnable(true);
        touchImageView = (TouchImageView) findViewById(R.id.scaleLayout_center);
        mScaleLayout.setOnGetCanScaleListener(new ScaleLayout.OnGetCanScaleListener() {
            @Override
            public boolean onGetCanScale(boolean isScrollDown) {
                return !touchImageView.isZoomed();
            }
        });

        mTop = (TextView) findViewById(R.id.scaleLayout_top);
        mTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mScaleLayout.setState(ScaleLayout.STATE_CLOSE);
            }
        });
    }


    public void showToast(String content){
        Toast.makeText(ScaleActivity.this, content, Toast.LENGTH_SHORT).show();
    }
}
