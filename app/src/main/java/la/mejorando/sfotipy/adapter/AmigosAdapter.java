package la.mejorando.sfotipy.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import la.mejorando.sfotipy.Models.Amigo;
import la.mejorando.sfotipy.R;

/**
 * Created by thespianartist on 24/09/14.
 */
public class AmigosAdapter extends RecyclerView.Adapter<AmigosAdapter.ViewHolder> {


    private ArrayList<Amigo> amigos;
    private int itemLayout;


    public  AmigosAdapter(ArrayList<Amigo> data,  int itemLayout){

        this.amigos = data;
        this.itemLayout = itemLayout;
    }



    @Override
    public AmigosAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(itemLayout, viewGroup, false);
        return new ViewHolder(v);
    }



    @Override
    public void onBindViewHolder(AmigosAdapter.ViewHolder viewHolder, int i) {

        Amigo amigo = amigos.get(i);

        viewHolder.name.setText(amigo.getNombre());
        viewHolder.twitter.setText(amigo.getTwitter());
        viewHolder.ultima.setText(amigo.getUltimacanción());

    }

    @Override
    public int getItemCount() {
        return amigos.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView ultima;
        public TextView name;
        public TextView twitter;

        public ViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            twitter = (TextView) itemView.findViewById(R.id.twitter);
            ultima = (TextView) itemView.findViewById(R.id.ultima_canción);
        }



    }




}
