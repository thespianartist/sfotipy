package la.mejorando.sfotipy.fragments;



import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import la.mejorando.sfotipy.R;

/**
 * A simple {@link android.app.Fragment} subclass.
 *
 */
public class DestacadosFragment extends Fragment {

    public DestacadosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_destacados, container, false);
    }


    private void onclick(View v){

    }
}
