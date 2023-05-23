package net.steamcrafted.lineartimepicker.res;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;

public class dialog_toolbar extends FrameLayout {

    public dialog_toolbar(Context context) {
        super(context);
        createLayout(context);
    }

    private void createLayout(Context context) {
        setId(View.generateViewId());
        setTag("toolbarContainer");
        FrameLayout.LayoutParams toolbarParams = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                getActionBarHeight(context)
        );
        toolbarParams.gravity = Gravity.TOP;
        toolbarParams.height = getActionBarHeight(context);
        setLayoutParams(toolbarParams);
        setElevation(dpToPx(context, 4));

        FrameLayout.LayoutParams imageParams = new FrameLayout.LayoutParams(
                getActionBarHeight(context),
                ViewGroup.LayoutParams.MATCH_PARENT
        );

        ImageView btn_cancel = new ImageView(context);
        btn_cancel.setId(View.generateViewId());
        btn_cancel.setTag("btn_cancel");
        btn_cancel.setLayoutParams(imageParams);
        //btn_cancel.setImageResource(R.drawable.ic_action_close);
        Bitmap bmp_cancel = BitmapFactory.decodeFile("ic_action_close");
        btn_cancel.setImageBitmap(bmp_cancel);

        btn_cancel.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        btn_cancel.setBackground(ContextCompat.getDrawable(context, android.R.attr.selectableItemBackground));
        imageParams.gravity = Gravity.LEFT;
        btn_cancel.setLayoutParams(imageParams);

        ImageView btn_apply = new ImageView(context);
        btn_apply.setId(View.generateViewId());
        btn_apply.setTag("btn_apply");
        btn_apply.setLayoutParams(imageParams);
        //btn_apply.setImageResource(R.drawable.ic_action_check);
        Bitmap bmp_apply = BitmapFactory.decodeFile("ic_action_check");
        btn_apply.setImageBitmap(bmp_apply);


        btn_apply.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        btn_apply.setBackground(ContextCompat.getDrawable(context, android.R.attr.selectableItemBackground));
        imageParams.gravity = Gravity.RIGHT;
        btn_apply.setLayoutParams(imageParams);

        addView(btn_cancel);
        addView(btn_apply);
    }


    public static int getActionBarHeight(Context context) {
        TypedValue typedValue = new TypedValue();
        int[] actionBarHeightAttr = new int[]{android.R.attr.actionBarSize};
        int indexOfAttrActionbarSize = 0;
        TypedArray typedArray = context.obtainStyledAttributes(typedValue.data, actionBarHeightAttr);
        int actionBarHeight = typedArray.getDimensionPixelSize(indexOfAttrActionbarSize, -1);
        typedArray.recycle();
        return actionBarHeight;
    }

    public static int dpToPx(Context context, float dp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int) (dp * displayMetrics.density + 0.5f);
    }


}