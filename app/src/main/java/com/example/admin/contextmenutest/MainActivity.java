package com.example.admin.contextmenutest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout linear;
    Button but2;
    ImageView img1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button but1=(Button)findViewById(R.id.but1);
        but2=(Button)findViewById(R.id.but2);
        linear=(LinearLayout)findViewById(R.id.linear);
        but2=(Button)findViewById(R.id.but2);
        img1=(ImageView)findViewById(R.id.img1);
        registerForContextMenu(but1);
        registerForContextMenu(but2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater=getMenuInflater();
        if(v.getId()==R.id.but1){
            menu.setHeaderTitle("배경색 변경");
            menu.setHeaderIcon(R.drawable.pig2);
            menuInflater.inflate(R.menu.menu1,menu);
          }
        if(v.getId()==R.id.but2){
            menuInflater.inflate(R.menu.menu2,menu);
          }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        super.onContextItemSelected(item);
        switch (item.getItemId()){
            case R.id.menu1_item_red:
            linear.setBackgroundColor(Color.RED);
                return true;
            case R.id.menu1_item_pink:
                linear.setBackgroundColor(Color.rgb(255,178,217));
                return true;
            case R.id.menu1_item_yellow:
                linear.setBackgroundColor(Color.YELLOW);
                return true;
            case R.id.menu2_item_rotation:
                img1.setRotation(90);
                return true;
            case R.id.menu2_item_size:
                img1.setScaleX(1.5f);
                img1.setScaleY(1.5f);
                return true;
        }
        return false;
    }
}
