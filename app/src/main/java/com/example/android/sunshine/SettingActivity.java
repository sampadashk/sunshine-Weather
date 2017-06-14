package com.example.android.sunshine;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * Created by KV on 13/6/17.
 */

public class SettingActivity extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState)
    {
       super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_fragment);
        ActionBar actionBar=this.getSupportActionBar();
        if(actionBar!=null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        super.onOptionsItemSelected(item);
        int id=item.getItemId();
        if(id==android.R.id.home)
        {
            NavUtils.navigateUpFromSameTask(this);
        }
        return false;
    }
}
