package com.aigestudio.wheelpicker.widgets;

import android.content.Context;
import android.util.AttributeSet;

import com.aigestudio.wheelpicker.WheelPicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 月份选择器
 * <p>
 * Picker for Months
 *
 * @author AigeStudio 2016-07-12
 * @version 1
 */
public class WheelMonthPicker extends WheelPicker implements IWheelMonthPicker {
    private int mSelectedMonth;
    private int mMonthStart = 1;
    private int mMonthEnd = 12;

    public WheelMonthPicker(Context context) {
        this(context, null);
    }

    public WheelMonthPicker(Context context, AttributeSet attrs) {
        super(context, attrs);

        List<Integer> data = new ArrayList<>();
        for (int i = Math.max(1, mMonthStart); i <= Math.min(12, mMonthEnd); i++)
            data.add(i);
        super.setData(data);

        mSelectedMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
        updateSelectedMonth();
    }

    public void  updateSelectedMonth() {
        setSelectedItemPosition(mSelectedMonth - Math.max(1, mMonthStart));
    }

    @Override
    public void setData(List data) {
        throw new UnsupportedOperationException("You can not invoke setData in WheelMonthPicker");
    }

    @Override
    public void setMonthFrame(int startMonth, int endMonth) {
        this.mMonthStart = startMonth;
        this.mMonthEnd = endMonth;
        if (mSelectedMonth > endMonth) {
            mSelectedMonth = endMonth;
        } else if (mSelectedMonth < startMonth) {
            mSelectedMonth = startMonth;
        }
        List<Integer> data = new ArrayList<>();
        for (int i = startMonth; i <= endMonth; i++)
            data.add(i);
        super.setData(data);
    }

    @Override
    public void setMonthStart(int startMonth) {
        this.mMonthStart = startMonth;
    }

    @Override
    public void setMonthEnd(int endMonth) {
        this.mMonthEnd = endMonth;
    }

    @Override
    public int getMonthStart() {
        return mMonthStart;
    }

    @Override
    public int getMonthEnd() {
        return mMonthEnd;
    }

    @Override
    public int getSelectedMonth() {
        return mSelectedMonth;
    }

    @Override
    public void setSelectedMonth(int month) {
        if (month > mMonthEnd) {
            mSelectedMonth = mMonthEnd;
        } else if (month < mMonthStart) {
            mSelectedMonth = mMonthStart;
        } else {
            mSelectedMonth = month;
        }
        updateSelectedMonth();
    }

    @Override
    public int getCurrentMonth() {
        return Integer.valueOf(String.valueOf(getData().get(getCurrentItemPosition())));
    }

    public int getmSelectedMonth() {
        return mSelectedMonth;
    }
}