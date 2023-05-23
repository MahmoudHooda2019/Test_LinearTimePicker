package com.aemo.linepicker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.widget.FrameLayout;
import androidx.core.content.res.ResourcesCompat;
import com.aemo.linepicker.addon.ColorAdapter;
import com.aemo.linepicker.addon.GradientColorAdapter;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.AndroidViewComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.errors.YailRuntimeError;
import com.google.appinventor.components.runtime.util.YailList;
import net.steamcrafted.lineartimepicker.adapter.DateAdapter;
import net.steamcrafted.lineartimepicker.adapter.LinearPickerAdapter;
import net.steamcrafted.lineartimepicker.adapter.TimeAdapter;
import net.steamcrafted.lineartimepicker.dialog.LinearDatePickerDialog;
import net.steamcrafted.lineartimepicker.dialog.LinearTimePickerDialog;
import net.steamcrafted.lineartimepicker.view.LinearDatePickerView;
import net.steamcrafted.lineartimepicker.view.LinearPickerView;
import net.steamcrafted.lineartimepicker.view.LinearTimePickerView;

public class LinePicker extends AndroidNonvisibleComponent {

  private ComponentContainer container;
  private LinearTimePickerDialog timePickerDialog;
  private LinearDatePickerDialog datePickerDialog;


    /*
    private LinearTimePickerView timePickerView;
    private LinearDatePickerView datePickerView;

    final int backgroundDark = ResourcesCompat.getColor(Resources.getSystem(), android.R.color.background_dark, form.getTheme());
    final int foregroundDark  = ResourcesCompat.getColor(Resources.getSystem(), Color.parseColor("#212121"), form.getTheme());
    final int colorAccent  = ResourcesCompat.getColor(Resources.getSystem(), Color.parseColor("#FF4081"), form.getTheme());
*/
    public LinePicker(ComponentContainer container) {
    super(container.$form());
    this.container = container;
  }

  @SimpleFunction
  public void ShowTimePickerDialog(){
    timePickerDialog.show();
  }

  @SimpleFunction
  public void CreateTimePickerDialog(){
    timePickerDialog = LinearTimePickerDialog.Builder.with((Context) container)
            .setButtonCallback(new LinearTimePickerDialog.ButtonCallback() {
              @Override
              public void onPositive(DialogInterface dialog, int hour, int minutes) {
                OnTimePickerPositive(hour,minutes);
              }

              @Override
              public void onNegative(DialogInterface dialog) {
                OnTimePickerNegative();
              }
            })
            .build();

  }

  @SimpleEvent
  public void OnTimePickerPositive(int hour, int minutes) {
    EventDispatcher.dispatchEvent(this,"OnTimePickerPositive",hour,minutes);
  }

  @SimpleEvent
  public void OnTimePickerNegative() {
    EventDispatcher.dispatchEvent(this,"OnTimePickerNegative");
  }



  /////////////////////////////////////////////////////////////////////

  @SimpleFunction
  public void ShowDatePickerDialog(){
    datePickerDialog.show();
  }



  @SimpleFunction
  public void CreateDatePickerDialog(){
    datePickerDialog = LinearDatePickerDialog.Builder.with((Context) container)
            .setButtonCallback(new LinearDatePickerDialog.ButtonCallback() {
              @Override
              public void onPositive(DialogInterface dialog, int year, int month, int day) {
                OnDatePickerPositive(year,month,day);
              }

              @Override
              public void onNegative(DialogInterface dialog) {
                OnDatePickerNegative();
              }
            })
            .build();

  }

  @SimpleEvent
  public void OnDatePickerPositive(int year,int month,int day) {
    EventDispatcher.dispatchEvent(this,"OnDatePickerPositive",year,month,day);
  }

  @SimpleEvent
  public void OnDatePickerNegative() {
    EventDispatcher.dispatchEvent(this,"OnDatePickerNegative");
  }


   /*

    @SimpleFunction
    public void TimerAddToView(AndroidViewComponent view, int color){
        LinearPickerView v = new LinearPickerView((Context) container);
        Paint textPaint = new Paint();
        textPaint.setColor(color);
        LinearPickerAdapter dateAdap = new DateAdapter((Context) container,textPaint);
        LinearPickerAdapter timeAdap = new TimeAdapter((Context) container,textPaint);
        LinearPickerAdapter colorAdap = new ColorAdapter((Context) container,textPaint);
        LinearPickerAdapter graColorAdap = new GradientColorAdapter((Context) container,textPaint);
        v.setAdapter(dateAdap);

        FrameLayout fm = (FrameLayout) view.getView();
        fm.addView(v, new FrameLayout.LayoutParams(-1,-1));

        v.setBackgroundColor(Color.parseColor("#3F51B5"));
        v.setLineColor(Color.GRAY);
        v.setActiveLineColor(Color.WHITE);
        v.setHandleBackgroundColor(Color.parseColor("#303F9F"));


    }

    */









}
