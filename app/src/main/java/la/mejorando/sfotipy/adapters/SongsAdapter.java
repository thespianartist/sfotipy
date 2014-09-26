package la.mejorando.sfotipy.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

import la.mejorando.sfotipy.R;
import la.mejorando.sfotipy.models.Song;

/**
 * Created by thespianartist on 25/09/14.
 */

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.ViewHolder>{

    ArrayList<Song> songs;
    int itemLayout;


    public SongsAdapter(ArrayList<Song> songs,int itemLayout ){
        this.itemLayout = itemLayout;
        this.songs = songs;
    }


    @Override
    public SongsAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(itemLayout,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(SongsAdapter.ViewHolder viewHolder, int i) {

        Song song = songs.get(i);

        viewHolder.namesong.setText(song.getSongName());
        viewHolder.artist.setText(song.getSongArtist());
        viewHolder.stars.setNumStars(song.getStars());

    }

    @Override
    public int getItemCount() {
        return songs.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView namesong;
        TextView artist ;
        RatingBar stars;


        public ViewHolder(View itemView) {
            super(itemView);

         namesong = (TextView) itemView.findViewById(R.id.name_song);
         artist  = (TextView) itemView.findViewById(R.id.artist);
         stars = (RatingBar) itemView.findViewById(R.id.ratingBar);


        }
    }

}
