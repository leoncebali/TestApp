package tg.geeknation.rajkat.activities;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import tg.geeknation.rajkat.models.Profil;
import tg.geeknation.rajkat.models.dao.DaoMaster;
import tg.geeknation.rajkat.models.dao.DaoSession;
import tg.geeknation.rajkat.models.dao.ProfilDao;

public class AddProfilActivity extends AppCompatActivity {

    private Profil profil;
    private ProfilDao profilDao;
    private SQLiteDatabase db;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private String base = "geek_db";

    private Button valider;
    private EditText nom, ed_profil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_profil);

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, base, null);

        db = helper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
        profilDao = daoSession.getProfilDao();

        nom = (EditText) findViewById(R.id.ed_nom);
        ed_profil = (EditText) findViewById(R.id.ed_profil);
        valider = (Button) findViewById(R.id.btn_valider);

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(AddProfilActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    void addProfil(){
        profil = new Profil();
        profil.setNom(nom.getText().toString());
        profil.setCompetence(ed_profil.getText().toString());
        profil.setPhoto(R.drawable.eight);
        profilDao.insert(profil);
        profilDao.refresh(profil);
        db.close();
        Toast.makeText(AddProfilActivity.this, "Enregistrement effectué...", Toast.LENGTH_SHORT).show();

    }
}
