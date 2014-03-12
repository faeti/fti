package br.com.fti.database;

import br.com.ftigfin.models.lancamento.BVLancamento;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FSQLiteOpenHelper extends SQLiteOpenHelper {
	
	private static final String DATABASE_NAME = "FTIGFIN";
	
	private static final int DATABASE_VERSION = 14;
	
	public FSQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);  
    }

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(BVLancamento.CREATE_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		this.onCreate(db);
	}
}