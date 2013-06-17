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

See the sample project for more information

To Do
=====
-A Light Theme that works in Holo.Light
-Auto Locale Detection
