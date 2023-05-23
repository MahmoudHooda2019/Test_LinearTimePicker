package net.steamcrafted.lineartimepicker.res;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import net.steamcrafted.lineartimepicker.view.LinearTimePickerView;

public class dialog_time extends FrameLayout {

    public dialog_time(Context context) {
        super(context);
        createLayout(context);
    }

    private void createLayout(Context context) {
        setId(View.generateViewId());
        setTag("timeContainer");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );
        setLayoutParams(layoutParams);

        // dialog_toolbar
        dialog_toolbar toolbar = new dialog_toolbar(context);
        addView(toolbar);

        // LinearTimePickerView
        LinearTimePickerView linearTimePickerView = new LinearTimePickerView(context);
        linearTimePickerView.setId(View.generateViewId());
        linearTimePickerView.setTag("ltp");
        FrameLayout.LayoutParams timePickerParams = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );
        timePickerParams.topMargin = dialog_toolbar.getActionBarHeight(context);
        linearTimePickerView.setLayoutParams(timePickerParams);
        addView(linearTimePickerView);
    }
}
