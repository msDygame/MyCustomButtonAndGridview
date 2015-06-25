package com.dygame.mycustombutton;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Administrator on 2015/6/24.
 */
public class GridViewAdapter extends BaseAdapter
{
    protected Integer[] pData={R.drawable.android,
            R.drawable.android_arc_welder,
            R.drawable.android_platform_icon,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher_2,
            R.drawable.imageview_msn,
            R.drawable.imageview_tv,
            R.drawable.app_icon,
            R.drawable.sample_bear,
            R.drawable.dy_badminton_app_icon,
            R.drawable.dy_basketball_app_icon,
            R.drawable.dy_bowling_app_icon,
            R.drawable.dy_fishrush_app_icon,
            R.drawable.dy_kingofboxing_app_icon,
            R.drawable.dy_motionarcher_app_icon,
            R.drawable.dy_waverider_app_icon,
            R.drawable.dy_rushhours_app_icon,
            R.drawable.sample_ic_launcher_3,
            R.drawable.sample_unity_app_icon,
            R.drawable.dy_256_256
    } ;
    protected Context context;
    protected String TAG = "MyCrashHandler" ;

    public GridViewAdapter(Context context)
    {
        this.context = context;
    }

    @Override
    public int getCount()
    {
        return pData.length;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ImageView image;
        if(convertView==null)
        {
            image = new ImageView(context);
            image.setLayoutParams(new GridView.LayoutParams(120, 120));
            image.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        else
        {
            image = (ImageView)convertView;
        }
        image.setImageResource(pData[position]);
        return image;

    }

    @Override
    public Object getItem(int position)
    {
        return pData[position];
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }
}
