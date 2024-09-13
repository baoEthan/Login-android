package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HeadImageActivity extends AppCompatActivity {
    private int[] imageId = new int[]{R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4,
            R.drawable.img5, R.drawable.img6,R.drawable.img7, R.drawable.img8, R.drawable.img9};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.head_select);
        GridView image = (GridView) findViewById(R.id.gridview);
        BaseAdapter adapter = new BaseAdapter(){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView imageView;
                if (convertView == null){
                    imageView = new ImageView(HeadImageActivity.this);
                    imageView.setAdjustViewBounds(true);
                    imageView.setMaxHeight(200);
                    imageView.setMaxWidth(200);
                    imageView.setPadding(5,5,5,5);
                }else {
                    imageView = (ImageView) convertView;
                }
                imageView.setImageResource(imageId[position]);
                return imageView;
            }

            @Override
            public int getCount() {
                return imageId.length;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }
        };
        image.setAdapter(adapter);
        image.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.putExtra("imageId", position);
                setResult(0x718,intent);
                finish();
            }
        });
    }
}
