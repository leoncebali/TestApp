package tg.geeknation.rajkat.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import tg.geeknation.rajkat.models.Profil;
import tg.geeknation.rajkat.models.dao.DaoMaster;
import tg.geeknation.rajkat.models.dao.DaoSession;
import tg.geeknation.rajkat.models.dao.ProfilDao;
import tg.geeknation.rajkat.activities.R;

/**
 * Created by rajkat on 11/25/16.
 */
public class Util {

    public Util() {
    }

    public static void dataP(Context context){

        SQLiteDatabase db;
        DaoMaster daoMaster;
        DaoSession daoSession;
        Profil profil;
        ProfilDao profilDao;

        String base = "geek_db";

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, base, null);

        db = helper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
        profilDao = daoSession.getProfilDao();

        if (profilDao.loadAll().isEmpty()) {

            /**
             * Insertion dans la table profil
             */
            profil = new Profil();
            profil.setNom("Rajkat Design");
//            profil.setNote(R.drawable.notation);
            profil.setCompetence("Design");
            profil.setPhoto(R.drawable.one);
            profilDao.insert(profil);

            profil = new Profil();
            profil.setNom("Prime prime");
//            profil.setNote(R.drawable.notation);
            profil.setCompetence("Programmer");
            profil.setPhoto(R.drawable.two);
            profilDao.insert(profil);

            profil = new Profil();
            profil.setNom("Eight Togo");
//            profil.setNote(R.drawable.notation);
            profil.setCompetence("Developer Designer");
            profil.setPhoto(R.drawable.three);
            profilDao.insert(profil);

            profil = new Profil();
            profil.setNom("3. Trees");
//            profil.setNote(R.drawable.notation);
            profil.setCompetence("Developer");
            profil.setPhoto(R.drawable.four);
            profilDao.insert(profil);

            profil = new Profil();
            profil.setNom("Phareal Design");
//            profil.setNote(R.drawable.notation);
            profil.setCompetence("Web Designer");
            profil.setPhoto(R.drawable.five);
            profilDao.insert(profil);

            profil = new Profil();
            profil.setNom("Del Bonboy");
//            profil.setNote(R.drawable.notation);
            profil.setCompetence("Mannequin");
            profil.setPhoto(R.drawable.six);
            profilDao.insert(profil);

            profil = new Profil();
            profil.setNom("Res Bernardo");
//            profil.setNote(R.drawable.notation);
            profil.setCompetence("Graphic Designer");
            profil.setPhoto(R.drawable.seven);
            profilDao.insert(profil);

            profilDao.refresh(profil);
            db.close();
        }

    }
}
