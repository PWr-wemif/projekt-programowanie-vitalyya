package com.project.schedule.views;


import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.project.schedule.R;


public class HourView extends ConstraintLayout {

    TextView hourTV;
    TextView min015;
    TextView min1530;
    TextView min3045;
    TextView min4560;

    public TextView getHourTV() {
        return hourTV;
    }

    public TextView getMin015() {
        return min015;
    }

    public TextView getMin1530() {
        return min1530;
    }

    public TextView getMin3045() {
        return min3045;
    }

    public TextView getMin4560() {
        return min4560;
    }

    private int hourInt =0;

    public int getHourInt() {
        return hourInt;
    }

    public HourView(Context context) {
        super(context);
        initUI(context);
    }

    private void initUI(Context context) {
        View  view = inflate(context, R.layout.hour_view, this);

        hourTV = view.findViewById(R.id.hour_id);
        min015 = view.findViewById(R.id.min015);
        min1530 = view.findViewById(R.id.min1530);
        min3045 = view.findViewById(R.id.min3045);
        min4560 = view.findViewById(R.id.min4560);


    }

    public HourView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initUI(context);
        setParams(context, attrs);
    }


    public HourView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initUI(context);
        setParams(context, attrs);

    }

    public HourView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initUI(context);
        setParams(context, attrs);
    }


    private void setParams(Context context, AttributeSet attrs) {
        //находим наш параметер в файле attrs
        TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.HourView);
        //берем его что бы дальше передать по умолчанию
        hourInt = arr.getInt(R.styleable.HourView_hourInt,0);
        String hoursString = arr.getString(R.styleable.HourView_hourTime);
        hourTV.setText(hoursString);
        arr.recycle();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }
}
