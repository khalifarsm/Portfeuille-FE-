package com.example.mahmoud.portefeuille.Presenters;

import android.util.Log;
import android.widget.LinearLayout;

import com.example.mahmoud.portefeuille.Models.Historique;
import com.example.mahmoud.portefeuille.R;
import com.example.mahmoud.portefeuille.Screen.AcceuilActivity;
import com.example.mahmoud.portefeuille.Screen.StatistiqueActivity;
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

public class StatistiquePresenter {
    StatistiqueActivity contextStatistique;
    HistoriquePresenter presenter;
    public StatistiquePresenter(StatistiqueActivity context)
    {
        this.contextStatistique=context;
        presenter=new HistoriquePresenter(context){
            @Override
            public void onHistoriqueLoaded(List<Historique> historiques) {
                ArrayList<BarEntry> entries = new ArrayList<>();
                ArrayList<BarEntry> entries2 = new ArrayList<>();
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
                        entries.add(new BarEntry( revenu,indice));
                    }
                    else {
                        depenses += h.getValeur();
                        entries2.add(new BarEntry( depenses,indice));
                    }
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
                ArrayList<BarDataSet> bars = new ArrayList<>();
                ArrayList<BarDataSet> bars2 = new ArrayList<>();
                BarDataSet dataset = new BarDataSet(entries, "Revenus (DH)");
                int depenseColor=contextStatistique.getResources().getColor(R.color.depense);
                int revenuColor=contextStatistique.getResources().getColor(R.color.revenu);
                int epargneColor=contextStatistique.getResources().getColor(R.color.epargne);
                dataset.setColor(revenuColor);
                BarDataSet dataset2 = new BarDataSet(entries2, "Dépenses (DH)");
                dataset2.setColor(depenseColor);
                LineDataSet dataset3 = new LineDataSet(entries3, "Epargne (DH)");
                dataset3.setColor(epargneColor);
                dataset3.setCircleColor(epargneColor);
                bars.add(dataset);
                bars2.add(dataset2);
                lines.add(dataset3);

                LineChart chart3 = new LineChart(context);
                BarChart chart1 = new BarChart(context);
                BarChart chart2 = new BarChart(context);

                LineData data3 = new LineData(labels,lines);
                BarData data1 = new BarData(labels,bars);
                BarData data2 = new BarData(labels,bars2);


                chart1.setData(data1);
                chart2.setData(data2);
                chart3.setData(data3);


                chart1.setDescription("Revenus");
                chart2.setDescription("Dépenses");
                chart3.setDescription("Epargne");

                LinearLayout first = (LinearLayout)contextStatistique.findViewById(R.id.firstLayout);
                LinearLayout secande = (LinearLayout)contextStatistique.findViewById(R.id.secandeLayout);
                LinearLayout third = (LinearLayout)contextStatistique.findViewById(R.id.thirdLayout);

                first.addView(chart1);
                secande.addView(chart2);
                third.addView(chart3);
            }
        };

    }
    public void graphe()
    {
        presenter.getHistoriques(LoginPresenter.user.getEmail(),LoginPresenter.user.getPass());
    }
}
