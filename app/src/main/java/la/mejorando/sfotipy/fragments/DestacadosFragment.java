package la.mejorando.sfotipy.fragments;



import android.app.ProgressDialog;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import la.mejorando.sfotipy.R;
import la.mejorando.sfotipy.adapters.AmigosAdapter;
import la.mejorando.sfotipy.adapters.SongsAdapter;
import la.mejorando.sfotipy.models.Song;

/**
 * A simple {@link android.app.Fragment} subclass.
 *
 */
public class DestacadosFragment extends Fragment {


    ArrayList<Song> dataset;

    public DestacadosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_destacados, container, false);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        String URL = "https://script.google.com/macros/s/AKfycbxYMVeK_mfrW0vZs7z6BsrHLSuFcB8H4L7bcYaoqo4AumyXOdw/exec";

        RequestQueue queue = Volley.newRequestQueue(getActivity());

        final ProgressDialog progressDialog = ProgressDialog.show(getActivity(),"Espere por favor","estamos atendiendo su solocitud");

        JsonArrayRequest req = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                Log.e("mirespuesta",response.toString());
                dataset = new ArrayList<Song>();
                dataset= parser(response);

                progressDialog.cancel();

            }
        }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.cancel();

            }
        });



        queue.add(req);


        ArrayList<Song> songs = new ArrayList<Song>();
        Song song  = new Song();
        song.setStars(3);
        song.setSongName("GerLucky");
        song.setSongArtist("DaftPunk");
        songs.add(song);

        Song song2  = new Song();
        song2.setStars(3);
        song2.setSongName("GerLucky");
        song2.setSongArtist("DaftPunk");
        songs.add(song2);


        RecyclerView recyclerView = (RecyclerView) getActivity().findViewById(R.id.my_recycler_view_song);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new SongsAdapter(songs, R.layout.row_songs));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }


    public ArrayList<Song> parser (JSONArray response){

        ArrayList<Song> songsAux = new ArrayList<Song>();

        for(int i = 0; i<response.length(); i++){

            Song song = new Song();

            try {

                JSONObject jsonObject = (JSONObject) response.get(i);

                song.setSongName(jsonObject.getString("cancion"));
                song.setSongArtist(jsonObject.getString("artista"));
                song.setStars(jsonObject.getInt("estrellas"));

                Log.e("dato",song.getSongName().toString());

               songsAux.add(song);

            } catch (JSONException e) {
                e.printStackTrace();
            }


        }


        return songsAux;
    }

}
