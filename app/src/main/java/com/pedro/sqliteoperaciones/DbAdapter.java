package com.pedro.sqliteoperaciones;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbAdapter {
    dBHelper helper;
    public DbAdapter(Context context){
        helper = new dBHelper(context);
    }
    public long insertarDatos(String usuario, String password){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues contenidoValores = new ContentValues();
        contenidoValores.put(dBHelper.NAME, usuario);
        contenidoValores.put(dBHelper.MyPASSWORD, password);
        long id = db.insert(dBHelper.TABLE_NAME, null, contenidoValores);

    }
    static class dBHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "registrosdb"; //nombre de base de datos
        private static final String TABLE_NAME = "usuarios"; //nombre de tabla
        private static final int DATABASE_version = 1; //version de base de datos
        private static final String UID = "_id"; // columna 1 (primary key)
        private static final String NAME = "Nombre"; // columna 2
        private static final String MyPASSWORD = "Password"; //columna 3

        private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME
                + "("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME + "VARCHAR(255),"+MyPASSWORD+" VARCHAR(255));";

        private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
        private Context context;

        public dBHelper(Context contextRecibido) {
            super(contextRecibido, DATABASE_NAME, null, DATABASE_version);
            this.context = contextRecibido;

        }
        //crea la base de datos
        public void onCreate(SQLiteDatabase db){
            try {
                db.execSQL(CREATE_TABLE);
            }catch(Exception e){
                mensaje.aviso(context, "Error" + e);
            }
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int viejaVersion, int nuevaVersion){
            try {
                db.execSQL(DROP_TABLE);
                onCreate(db);
            }catch (Exception e){
                mensaje.aviso(context, "Error " + e);
            }
        }
    }
    }
