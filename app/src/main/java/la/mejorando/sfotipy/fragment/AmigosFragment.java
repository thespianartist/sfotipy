package la.mejorando.sfotipy.fragment;



import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import la.mejorando.sfotipy.Models.Amigo;
import la.mejorando.sfotipy.R;
import la.mejorando.sfotipy.adapter.AmigosAdapter;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class AmigosFragment extends Fragment {


    public AmigosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_amigos, container, false);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<Amigo> amigoArrayList = new ArrayList<Amigo>();

        Amigo  juanPablo = new Amigo();
        juanPablo.setNombre("Juan Palbo");
        juanPablo.setTwitter("f@unmalnick");
        juanPablo.setUltimacanción("Baby");
        amigoArrayList.add(juanPablo);


        Amigo  juanPablo2 = new Amigo();
        juanPablo2.setNombre("Juan Palbo");
        juanPablo2.setTwitter("@unmalnick");
        juanPablo2.setUltimacanción("Baby");
        amigoArrayList.add(juanPablo2);

        Amigo  juanPablo3 = new Amigo();
        juanPablo3.setNombre("Juan Palbo");
        juanPablo3.setTwitter("@unmalnick");
        juanPablo3.setUltimacanción("Baby");
        amigoArrayList.add(juanPablo3);

        Amigo  juanPablo4 = new Amigo();
        juanPablo4.setNombre("Juan Palbo");
        juanPablo4.setTwitter("@unmalnick");
        juanPablo4.setUltimacanción("Baby");
        amigoArrayList.add(juanPablo4);

        RecyclerView recyclerView = (RecyclerView) getActivity().findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new AmigosAdapter(amigoArrayList, R.layout.amigos_row));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }
}
