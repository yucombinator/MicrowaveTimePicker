MicrowaveTimePicker
===================

Backport of the new "Microwave-style" TimePicker found in the AlarmClock app in Android 4.2+.
It's easier to use than the old TimePicker, and looks awesome, too.

![TimePickerDialogFragment](/ss1.png "TimePickerDialogFragment")![TimePicker](/ss2.png "TimePicker")

Use
====
Import the library project to your app, then

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

<b>true</b>: 24H format

<b>false</b>: 12H format(AM/PM)

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
If you are experiencing crashes, you may have to copy the /assets/fonts folder from the library to the root of your project.
(your_root/assets/fonts/).



See the sample project for more information

To Do
=====
- [x] Make it work on Android 2.1+
- [ ] Light theme support
- [ ] Support for different locales
- [ ] There is a weird issue with the padding on the bold font in Android 2.1 - 2.3, I haven't been able to fix it, but if anyone wants to take a look...

Released under the Apache License
