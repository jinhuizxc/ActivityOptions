package com.example.jh.activityoptions;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * 这个demo主要测试ActivityOptions的转场动画效果
 * 1.makeCustomAnimation
 * 2.makeScaleUpAnimation
 * 3.makeThumbnailScaleUpAnimation
 * 4. 单一的makeSceneTransitionAnimation
 * 5.多个view的协作 makeSceneTransitionAnimation
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    ActivityOptionsCompat compat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        button.setOnClickListener(this);
        imageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                compat = ActivityOptionsCompat.makeCustomAnimation(this,
                        R.anim.translate_out, R.anim.translate_in);
                Intent intent = new Intent(this, SecondActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                ActivityCompat.startActivity(getApplicationContext(), intent, compat.toBundle());
                break;
            case R.id.imageView:
                compat = ActivityOptionsCompat.makeScaleUpAnimation(view,
                        view.getWidth() / 2, view.getHeight() / 2, 0, 0);
                ActivityCompat.startActivity(this, new Intent(this, SecondActivity.class),
                        compat.toBundle());
                break;
        }


//        Intent intent = new Intent(this, SecondActivity.class);
//        startActivity(intent);
//        overridePendingTransition(R.anim.translate_out, R.anim.translate_in);
    }
}
