package com.example.mahmoud.portefeuille.Presenters;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
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
        presenter = new HistoriquePresenter(context){
            @Override
            public void onHistoriqueLoaded(List<Historique> historiques) {
                ArrayList<Entry> entries = new ArrayList<>();
                ArrayList<Entry> entries2 = new ArrayList<>();
                ArrayList<Entry> entries3 = new ArrayList<>();
                ArrayList<String> labels = new ArrayList<String>();
                int i=0;
                int revenu=0;
                int depenses=0;
                String chaine="";
                int min=historiques.get(0).getDate();
                //find min
                for (Historique h: historiques)
                {
                    if(min>h.getDate())
                        min=h.getDate();
                }
                //////////////////
                for (Historique h: historiques
                        ) {
                    int indice =h.getDate()-min;
                    if(h.isRevenu()) {
                        revenu += h.getValeur();
                    }
                    else {
                        depenses += h.getValeur();
                    }
                    entries.add(new Entry( revenu,indice));
                    entries2.add(new Entry( depenses,indice));
                    int epargne=revenu-depenses;
                    if(epargne<0)
                        epargne=0;
                    entries3.add(new Entry( epargne,indice));
                    labels.add(h.getDateString());
                    chaine+=String.valueOf(indice)+"  "+revenu+" "+depenses+" "+h.getDateString()+"\n";
                }
                Log.d("ok", chaine);
                //ajouter le graphe a la vue
                ArrayList<LineDataSet> lines = new ArrayList<LineDataSet> ();
                LineDataSet dataset = new LineDataSet(entries, "Revenus (DH)");
                int depenseColor=contextAccueill.getResources().getColor(R.color.depense);
                int revenuColor=contextAccueill.getResources().getColor(R.color.revenu);
                int epargneColor=contextAccueill.getResources().getColor(R.color.epargne);
                dataset.setColor(revenuColor);
                dataset.setCircleColor(revenuColor);
                LineDataSet dataset2 = new LineDataSet(entries2, "Dépenses (DH)");
                dataset2.setColor(depenseColor);
                dataset2.setCircleColor(depenseColor);
                LineDataSet dataset3 = new LineDataSet(entries3, "Epargne (DH)");
                dataset3.setColor(epargneColor);
                dataset3.setCircleColor(epargneColor);
                lines.add(dataset);
                lines.add(dataset2);
                lines.add(dataset3);

                LineChart chart = new LineChart(context);

                LineData data = new LineData(labels,lines);



                chart.setData(data);


                chart.setDescription("Dépenses et revenus");

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
