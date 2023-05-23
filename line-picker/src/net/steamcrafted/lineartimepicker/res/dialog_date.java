package net.steamcrafted.lineartimepicker.res;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import net.steamcrafted.lineartimepicker.view.LinearDatePickerView;

public class dialog_date extends FrameLayout {

    public dialog_date(Context context) {
        super(context);
        createLayout(context);
    }

    private void createLayout(Context context) {
        setId(View.generateViewId());
        setTag("dataContainer");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );
        setLayoutParams(layoutParams);

        // dialog_toolbar
        dialog_toolbar toolbar = new dialog_toolbar(context);
        addView(toolbar);

        // LinearDatePickerView
        LinearDatePickerView linearDatePickerView = new LinearDatePickerView(context);
        linearDatePickerView.setId(View.generateViewId());
        linearDatePickerView.setTag("ltp");
        FrameLayout.LayoutParams datePickerParams = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );
        datePickerParams.topMargin = dialog_toolbar.getActionBarHeight(context);
        linearDatePickerView.setLayoutParams(datePickerParams);
        addView(linearDatePickerView);
    }
}
