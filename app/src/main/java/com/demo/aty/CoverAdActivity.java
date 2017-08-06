package com.demo.aty;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.blog.www.guideview.GuideBuilder;
import com.blog.www.guideview.cover.CoverGuide;
import com.demo.guide.R;

public class CoverAdActivity extends Activity {

    private Button header_imgbtn;
    CoverGuide guide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_guide_view);
        header_imgbtn = (Button) findViewById(R.id.header_imgbtn);
        header_imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CoverAdActivity.this, "show", Toast.LENGTH_SHORT).show();
            }
        });
        header_imgbtn.post(new Runnable() {
            @Override
            public void run() {
                showGuideView();
            }
        });
    }

    public void showGuideView() {
        GuideBuilder builder = new GuideBuilder();
        builder
//                .setTargetView(header_imgbtn)
//                .setAlpha(150)
//                .setHighTargetCorner(20)
//                .setHighTargetPadding(10)
//                .setOverlayTarget(false)
                .setOutsideTouchable(false);

        builder.setOnVisibilityChangedListener(new GuideBuilder.OnVisibilityChangedListener() {
            @Override
            public void onShown() {
            }

            @Override
            public void onDismiss() {
            }
        });

//        builder.addComponent(new SimpleComponent());
        guide = builder.createCoverGuide();
        guide.setShouldCheckLocInWindow(true);

        guide.showCover(this);
    }


}