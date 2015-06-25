package com.dygame.mycustombutton;

import android.content.ClipData;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Sample for CustomButton and GridView.
 */
public class MainActivity extends AppCompatActivity
{
    protected Button pButton1 ;
    protected Button pButton2 ;
    protected Button pButton3 ;
    protected GridView pGridView ;
    protected ImageView pMainImageView ;
    protected ArrayList<ClipData.Item> gridArray = new ArrayList<ClipData.Item>() ;
    protected GridViewAdapter customGridViewAdapter ;
    protected String TAG = "MyCrashHandler" ;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Uncaught Exception Handler(Crash Exception)
        MyCrashHandler pCrashHandler = MyCrashHandler.getInstance();
        pCrashHandler.init(getApplicationContext());
        TAG = pCrashHandler.getTag() ;
        //find resource
        pButton1 = (Button)findViewById(R.id.button) ;
        pButton2 = (Button)findViewById(R.id.button2) ;
        pButton3 = (Button)findViewById(R.id.button3) ;
        pGridView = (GridView) findViewById(R.id.gridView);
        pMainImageView = (ImageView)findViewById(R.id.imageView) ;
        //OnClickListener
        pButton1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                pButton1.setSelected(true);
                pButton2.setSelected(false);
                pButton3.setSelected(false);
                pGridView.setItemChecked(3,true) ;
            }
        });
        pButton2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                pButton1.setSelected(false);
                pButton2.setSelected(true);
                pButton3.setSelected(false);
            }
        });
        pButton3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                pButton1.setSelected(false);
                pButton2.setSelected(false);
                pButton3.setSelected(true);
            }
        });
        pMainImageView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Log.e(TAG, "ImageView OnClickListener ");
            }
        });
        //gridview Adapter
        customGridViewAdapter = new GridViewAdapter(MainActivity.this);
        pGridView.setAdapter(customGridViewAdapter);
        // 為GridView設定監聽器
        pGridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Log.e(TAG, "GridView OnItemClickListene "+position);
                ImageView iv = (ImageView)customGridViewAdapter.getView( position , null , null );
                pMainImageView.setImageDrawable(iv.getDrawable());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
