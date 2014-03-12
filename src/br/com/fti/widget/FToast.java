package br.com.fti.widget;

import android.content.Context;
import android.widget.Toast;

public class FToast extends Toast {
	
	public FToast(Context context) {
		super(context);
	}

	public static void onShowMessage(Context context, String message) {
		
		int duration = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(context, message, duration);
		toast.show();
		
	}
}
