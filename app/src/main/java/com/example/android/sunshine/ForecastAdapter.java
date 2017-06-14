package com.example.android.sunshine;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by KV on 9/6/17.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ViewHolder> {
    private ArrayList<String> mWeatherData=new ArrayList<>();
     private ForecastAdapterOnClickHandler mClickHandler;
    ForecastAdapter(ArrayList<String> weatherdata,ForecastAdapterOnClickHandler mClickHandler)
    {
        mWeatherData=weatherdata;
        this.mClickHandler=mClickHandler;
    }




    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.forecast_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Boolean b = MainActivity.prefChanged;

        String s = mWeatherData.get(position);

            holder.tvw.setText(s);




    }

    @Override
    public int getItemCount() {
        if(mWeatherData!=null) {
            Log.d("gsize"," "+mWeatherData.size());
            return mWeatherData.size();

        }
        return 0;
    }
    public interface ForecastAdapterOnClickHandler
    {
        public void onClick(String st);

    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {


        TextView tvw;

        public ViewHolder(View itemView) {
            super(itemView);
            tvw=(TextView) itemView.findViewById(R.id.tv_weather_data);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int adapterpos=getAdapterPosition();
            String itemres=mWeatherData.get(adapterpos);
            mClickHandler.onClick(itemres);




        }
    }
}
