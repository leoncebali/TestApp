package tg.geeknation.rajkat.activities;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import tg.geeknation.rajkat.adapters.ProfilAdapter;
import tg.geeknation.rajkat.models.Profil;
import tg.geeknation.rajkat.models.dao.DaoMaster;
import tg.geeknation.rajkat.models.dao.DaoSession;
import tg.geeknation.rajkat.models.dao.ProfilDao;
import tg.geeknation.rajkat.utils.Util;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProfilFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProfilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfilFragment extends Fragment {
    private ProfilDao profilDao;
    private SQLiteDatabase db;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private final String base = "geek_db";
    private ProfilAdapter adapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Profil> profils = new ArrayList<>();

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(getContext(), base, null);

        db = helper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
        profilDao = daoSession.getProfilDao();

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        databindProfil();
    }

    private void databindProfil() {

        Util.dataP(getContext());
        profils.addAll(profilDao.loadAll());
        Log.i("Profil size", String.valueOf(profils.size()));
        adapter = new ProfilAdapter(getContext(), profils);

        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profil, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.activity_profil_recycler_);
        return v;
    }
}
