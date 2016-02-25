package com.example.qingwen_li.imageloader.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.example.qingwen_li.imageloader.R;
import com.example.qingwen_li.imageloader.Utils.BitmapCache;

public class MainActivity extends AppCompatActivity {
    private Button btn_loadImage;
    private ImageView iv_showImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initnet();

    }

    private void initnet() {


    }

    private void initView() {
        btn_loadImage= (Button) findViewById(R.id.btn_loadImage);
        iv_showImage= (ImageView) findViewById(R.id.iv_show);

        btn_loadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RequestQueue mQueue= Volley.newRequestQueue(MainActivity.this);

                ImageLoader mImageLoader = new ImageLoader(mQueue, new BitmapCache(
                        BitmapCache.getCacheSize(MainActivity.this)));

                ImageLoader.ImageListener listener = ImageLoader.getImageListener(
                        iv_showImage,R.drawable.icon_loading, R.drawable.icon_fail_loading);
                mImageLoader.get(
                        "http://img.my.csdn.net/uploads/201404/13/1397393290_5765.jpeg", listener);
            }
        });
    }
}
