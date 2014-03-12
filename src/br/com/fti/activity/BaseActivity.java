package br.com.fti.activity;

import br.com.fti.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class BaseActivity extends Activity {

	public static Integer BASE_ACTIVITY = 0;
	
	protected void onCreate(Bundle savedInstanceState, int id) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		startActivityForResult(new Intent(this, CadastreActivity.class), 0);
	}
	
	protected void onActivityResult (int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
	}
	
}
