MicrowaveTimePicker
===================

Backport of the new TimePicker found in the AlarmClock app in Android 4.2+

Use
====
Import the library project to your app
Insert in the layout file:
```xml
    <com.icechen1.microwavetimepicker.TimePicker 
        xmlns:timepicker="http://schemas.android.com/apk/res-auto"
        android:id="@+id/time_picker"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        timepicker:format_24="true" />
```

where
timepicker:format_24="true|false"
true: 24H format
false: 12H format(AM/PM)

To use the view as a dialog, do the following:

```java
public class MainActivity extends FragmentActivity implements TimePickerDialogFragment.TimePickerDialogHandler {
//...
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

//...
    @Override
	public void onDialogTimeSet(int hourOfDay, int minute) {
    	//code goes here
    }
//...
		
	}

}
```




See the sample project for more information

To Do
=====
-A Light Theme that works in Holo.Light

-Auto Locale Detection
