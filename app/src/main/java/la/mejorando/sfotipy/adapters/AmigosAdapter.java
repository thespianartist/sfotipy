package la.mejorando.sfotipy.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import la.mejorando.sfotipy.R;
import la.mejorando.sfotipy.models.Amigo;

/**
 * Created by thespianartist on 24/09/14.
 */
public class AmigosAdapter extends RecyclerView.Adapter<AmigosAdapter.ViewHolder>{

    private ArrayList<Amigo> amigos;
    private  int itemLayout;


    public  AmigosAdapter( ArrayList<Amigo>  amigos, int itemLayout){
        this.amigos = amigos;
        this.itemLayout = itemLayout;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(itemLayout, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        Amigo amigo = amigos.get(i);

        viewHolder.amigoNombre.setText(amigo.getNombre());
        viewHolder.amigoTwitter.setText(amigo.getTwitter());
        viewHolder.ultimacancion.setText(amigo.getUltimaCancion());

    }

    @Override
    public int getItemCount() {
        return amigos.size();
    }


    public  class ViewHolder extends RecyclerView.ViewHolder{

        public TextView amigoNombre;
        public TextView amigoTwitter;
        public TextView ultimacancion;

        public ViewHolder(View itemView) {
            super(itemView);

            amigoNombre = (TextView) itemView.findViewById(R.id.nombre_amigo);
            amigoTwitter = (TextView) itemView.findViewById(R.id.twitter_amigo);
            ultimacancion = (TextView) itemView.findViewById(R.id.ultimacancion_amigo);


        }
    }

}


