package la.mejorando.sfotipy;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Outline;
import android.os.Bundle;
import android.widget.ImageButton;

import la.mejorando.sfotipy.fragment.AmigosFragment;
import la.mejorando.sfotipy.fragment.DestacadosFragment;
import la.mejorando.sfotipy.fragment.PerfilFragment;


public class Music extends Activity implements ActionBar.TabListener{


    private Fragment[] fragments= new Fragment[]{ new DestacadosFragment(), new AmigosFragment(), new PerfilFragment()};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_main);

        SetUpTabs();

        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        for (Fragment frag : fragments) {
            transaction.add(R.id.main, frag);
            transaction.hide(frag);
        }

        transaction.show(fragments[0]).commit();

        int size = getResources().getDimensionPixelSize(R.dimen.fab_size);
        Outline outline = new Outline();
        outline.setOval(0, 0, size, size);
        ImageButton imageButton = (ImageButton) findViewById(R.id.fab_1);
        imageButton.setOutline(outline);

    }



    public void SetUpTabs(){

        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        actionBar.addTab( actionBar.newTab()
                .setText("Musica")
                .setTabListener(this));

        actionBar.addTab( actionBar.newTab()
                .setText("Amigos")
                .setTabListener(this));

        actionBar.addTab( actionBar.newTab()
                .setText("Perfil")
                .setTabListener(this));
    }


    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

        for (Fragment frag : fragments) {
            fragmentTransaction.hide(frag);
        }

        fragmentTransaction.show(fragments[tab.getPosition()]);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }
}
