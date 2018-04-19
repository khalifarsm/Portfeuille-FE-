package com.example.mahmoud.portefeuille.Presenters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.mahmoud.portefeuille.Models.Historique;
import com.example.mahmoud.portefeuille.R;
import com.example.mahmoud.portefeuille.Screen.AcceuilActivity;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mahmoud on 02/04/2018.
 */

public class AcceuilPresenter {
    AcceuilActivity contextAccueill;
    HistoriquePresenter presenter;
    public AcceuilPresenter(AcceuilActivity context)
    {
        this.contextAccueill=context;
        presenter=new HistoriquePresenter(context){
            @Override
            public void onHistoriqueLoaded(List<Historique> historiques) {
                ArrayList<Entry> entries = new ArrayList<>();
                ArrayList<Entry> entries2 = new ArrayList<>();
                ArrayList<String> labels = new ArrayList<String>();
                int i=0;
                int epargne=0;
                for (Historique h: historiques
                        ) {
                    //epargne+=h.getValeur();
                    //entries.add(new BarEntry(h.getDate(), epargne));
                    //labels.add(h.getDateString());
                }
                for(i=0;i<100;i++)
                {
                    entries.add(new BarEntry(i+5, i));
                    entries2.add(new BarEntry(i+10, i));
                    labels.add(String.valueOf(i+3));
                    i++;
                }

                //
                //
                //ajouter le graphe a la vue
                ArrayList<LineDataSet> lines = new ArrayList<LineDataSet> ();
                LineDataSet dataset = new LineDataSet(entries, "Revenu");
                int depenseColor=contextAccueill.getColor(R.color.depense);
                int revenuColor=contextAccueill.getColor(R.color.revenu);
                dataset.setColor(revenuColor);
                dataset.setCircleColor(revenuColor);
                LineDataSet dataset2 = new LineDataSet(entries2, "Depenses");
                dataset2.setColor(depenseColor);
                dataset2.setCircleColor(depenseColor);
                lines.add(dataset);
                lines.add(dataset2);

                LineChart chart = new LineChart(context);

                LineData data = new LineData(labels,lines);



                chart.setData(data);


                chart.setDescription("# of times Alice called Bob");

                LinearLayout top = (LinearLayout)contextAccueill.findViewById(R.id.layout);
                top.addView(chart);
            }
        };

    }
    public void graphe()
    {
        presenter.getHistoriques(LoginPresenter.user.getEmail(),LoginPresenter.user.getPass());
    }
}
