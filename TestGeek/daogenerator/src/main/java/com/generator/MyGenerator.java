package com.generator;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class MyGenerator {

    private static final int SCHEMA_VERSION = 1;
    private static final String MODEL = "tg.geeknation.rajkat.models";
    private static final String DAO = "tg.geeknation.rajkat.models.dao";
    private static final String TEST = "tg.geeknation.rajkat.models.test";
    private static final String JAVA = "app/src/main/java";

    public static void main(String args[]) throws Exception {
        Schema schema = new Schema(SCHEMA_VERSION, MODEL);

        schema.setDefaultJavaPackageDao(DAO);
        schema.setDefaultJavaPackageTest(TEST);

        addEntity(schema);

        new DaoGenerator().generateAll(schema, JAVA);
    }

    private static void addEntity(Schema schema) {

        /*Création de l'entité PROFIL*/
        Entity profil = schema.addEntity("Profil");
        profil.implementsSerializable();
        profil.addIdProperty();
        profil.addStringProperty("nom");
        profil.addStringProperty("competence");
        profil.addIntProperty("photo");
    }
}
