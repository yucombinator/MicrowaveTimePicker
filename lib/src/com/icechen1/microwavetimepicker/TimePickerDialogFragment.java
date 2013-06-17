/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.icechen1.microwavetimepicker;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * DialogFragment to set alarm time.
 * @author Icechen1/AOSP
 *
 */
public class TimePickerDialogFragment extends DialogFragment {

    private Button mSet, mCancel;
    private TimePicker mPicker;
    private boolean hours_24 = false;
	public static TimePickerDialogFragment newInstance() {
        final TimePickerDialogFragment frag = new TimePickerDialogFragment();
        return frag;
    }
    
    public static TimePickerDialogFragment newInstance(boolean hours_24) {
        final TimePickerDialogFragment frag = new TimePickerDialogFragment();
        Bundle b = new Bundle();
        b.putBoolean("hours_24", hours_24);
        frag.setArguments(b);
        return frag;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

    	View v = inflater.inflate(R.layout.time_picker_dialog, null);
    	mSet = (Button) v.findViewById(R.id.set_button);
    	mCancel = (Button) v.findViewById(R.id.cancel_button);
    	mCancel.setOnClickListener(new View.OnClickListener() {
    		@Override
    		public void onClick(View view) {
    			dismiss();
    		}
    	});
    	mPicker = (TimePicker) v.findViewById(R.id.time_picker);
    	mPicker.setSetButton(mSet);
    	Bundle bundle=getArguments();
    	int hourOfDay;
    	int minute = 0;
    	//Set up the TimePicker
    	if(bundle!=null){
    		if (bundle.containsKey("hours_24")){
    			hours_24 = bundle.getBoolean("hours_24");
    			mPicker.set24Hours(true);
    		}
    		if (bundle.containsKey("hour")){
    			hourOfDay = bundle.getInt("hour");
        		if (bundle.containsKey("minute")){
        			minute = bundle.getInt("minute");
        		}
        		mPicker.setTime(hourOfDay, minute);
    		}
    	}
    	mSet.setOnClickListener(new View.OnClickListener() {
    		@Override
    		public void onClick(View view) {
    			final Activity activity = getActivity();
    			if (activity instanceof TimePickerDialogHandler) {
    				final TimePickerDialogHandler act =
    						(TimePickerDialogHandler) activity;
    				act.onDialogTimeSet(mPicker.getHours(), mPicker.getMinutes());
                } else {
                    Log.e("TimePicker","Error! Activities that use TimePickerDialogFragment must implement "
                            + "TimePickerDialogHandler");
                }
                dismiss();
            }
        });

        return v;
    }

    public interface TimePickerDialogHandler {
        public void onDialogTimeSet(int hourOfDay, int minute);
    }
}
