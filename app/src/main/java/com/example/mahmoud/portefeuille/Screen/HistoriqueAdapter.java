package com.example.mahmoud.portefeuille.Screen;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mahmoud.portefeuille.R;

import java.util.ArrayList;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * Created by Mahmoud on 25/04/2018.
 */

class HistoriqueAdapter extends ArrayAdapter<Historique>{

    private static final String s = "HistoriqueAdapter";
    private Context mContext;
    int mResource;

    public HistoriqueAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Historique> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        String type = getItem(position).getType();
        int valeur = getItem(position).getValeur();
        String date = getItem(position).getDate();

        Historique historique = new Historique(type, valeur, date);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView =  inflater.inflate(mResource,parent,false);

        TextView tvType = (TextView) convertView.findViewById(R.id.type);
        TextView tvValeur = (TextView) convertView.findViewById(R.id.valeur);
        TextView tvDate = (TextView) convertView.findViewById(R.id.date);

        tvType.setText(type);
        tvValeur.setText(String.valueOf(valeur));
        tvDate.setText(date);

        return convertView;
    }
}