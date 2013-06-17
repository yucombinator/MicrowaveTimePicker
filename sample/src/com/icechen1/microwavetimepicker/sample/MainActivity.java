package com.icechen1.microwavetimepicker.sample;

import com.icechen1.microwavetimepicker.TimePickerDialogFragment;

import android.os.Bundle;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements TimePickerDialogFragment.TimePickerDialogHandler {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void viewonly(View v){
	    Intent intent = new Intent(this, FullSizePickerActivity.class);
	    startActivity(intent);
	}
	
	/**
	 * Opens a DialogFragment with a AM/PM(12 Hours) TimePicker
	 * @param v
	 */
	public void opendialog_am(View v){
		FragmentManager manager = getSupportFragmentManager();
        final FragmentTransaction ft = manager.beginTransaction();
        //Close pre-existing dialogs if any
        final Fragment prev = manager.findFragmentByTag("time_dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        final TimePickerDialogFragment fragment = TimePickerDialogFragment.newInstance();
        fragment.show(ft, "time_dialog");
	}
	/**
	 * Opens a DialogFragment with a 24 Hours TimePicker
	 * @param v
	 */
	public void opendialog(View v){
		FragmentManager manager = getSupportFragmentManager();
        final FragmentTransaction ft = manager.beginTransaction();
        //Close pre-existing dialogs if any
        final Fragment prev = manager.findFragmentByTag("time_dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        final TimePickerDialogFragment fragment = TimePickerDialogFragment.newInstance();
        Bundle b = new Bundle();
        b.putBoolean("hours_24", true);
        fragment.setArguments(b);
        fragment.show(ft, "time_dialog");
	}
	
	/**
	 * Opens a DialogFragment with a preset time
	 * @param v
	 */
	public void opendialog_preset(View v){
		FragmentManager manager = getSupportFragmentManager();
        final FragmentTransaction ft = manager.beginTransaction();
        //Close pre-existing dialogs if any
        final Fragment prev = manager.findFragmentByTag("time_dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        final TimePickerDialogFragment fragment = TimePickerDialogFragment.newInstance();
        Bundle b = new Bundle();
        b.putBoolean("hours_24", true);
        b.putInt("hour", 12);
        b.putInt("minute", 12);
        fragment.setArguments(b);
        fragment.show(ft, "time_dialog");
	}
	
	@Override
	public void onDialogTimeSet(int hourOfDay, int minute) {
		Toast.makeText(getApplicationContext(), hourOfDay+":" +minute, Toast.LENGTH_LONG).show();

		
	}
	

}
