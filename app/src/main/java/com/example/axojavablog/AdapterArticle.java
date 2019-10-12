package com.example.axojavablog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterArticle extends BaseAdapter {
    private Context context;
    private List<Article> listeArticle;
    private LayoutInflater inflater;

    public AdapterArticle(Context context, List<Article> listeArticle) {
        this.context = context;
        this.listeArticle = listeArticle;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return this.listeArticle.size();
    }

    //renvoi un item
    @Override
    public Article getItem(int position) {
        return this.listeArticle.get(position);
    }

    //renvoi  id de l élément
    @Override
    public long getItemId(int position) {
        return 0;
    }

    //retourne la vue
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = inflater.inflate(R.layout.activity_adapter_article, null);
        Article article = getItem(position);
        TextView txtListIdArticle = convertView.findViewById(R.id.txtListIdArticle);
        txtListIdArticle.setText("" + article.getIdArticle());

        TextView txtListTitreArticle = convertView.findViewById(R.id.txtListTitreArticle);
        txtListTitreArticle.setText(article.getTitreArticle());


        return convertView;
    }
}
