package com.aigestudio.wheelpicker.widgets;

import android.content.Context;
import android.util.AttributeSet;

import com.aigestudio.wheelpicker.WheelPicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 日期选择器
 * <p>
 * Picker for Day
 *
 * @author AigeStudio 2016-07-12
 * @version 1
 */
public class WheelDayPicker extends WheelPicker implements IWheelDayPicker {
    private static final Map<Integer, List<Integer>> DAYS = new HashMap<>();

    private Calendar mCalendar;

    private int mYear, mMonth;
    private int mSelectedDay;
    private int startDay = 1, endDay = 31;

    public WheelDayPicker(Context context) {
        this(context, null);
    }

    public WheelDayPicker(Context context, AttributeSet attrs) {
        super(context, attrs);

        mCalendar = Calendar.getInstance();

        mYear = mCalendar.get(Calendar.YEAR);
        mMonth = mCalendar.get(Calendar.MONTH);

        updateDays();

        mSelectedDay = mCalendar.get(Calendar.DAY_OF_MONTH);

        updateSelectedDay();
    }

    private void updateDays() {
        mCalendar.set(Calendar.YEAR, mYear);
        mCalendar.set(Calendar.MONTH, mMonth);

        int days = mCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        ArrayList<Integer> data = new ArrayList<>();
        for (int i = Math.max(1, startDay); i <= Math.min(days, endDay); i++) {
            data.add(i);
        }

        super.setData(data);
    }

    private void updateSelectedDay() {
        setSelectedItemPosition(mSelectedDay - Math.max(1, startDay));
    }

    @Override
    public void setData(List data) {
        throw new UnsupportedOperationException("You can not invoke setData in WheelDayPicker");
    }

    @Override
    public void setDayFrame(int startDay, int endDay) {
        this.startDay = startDay;
        this.endDay = endDay;
        if (mSelectedDay > endDay) {
            mSelectedDay = endDay;
        } else if (mSelectedDay < startDay) {
            mSelectedDay = startDay;
        }
    }

    public void setmSelectedDay(int selectedDay) {
        if (mSelectedDay > endDay) {
            mSelectedDay = endDay;
        } else if (mSelectedDay < startDay) {
            mSelectedDay = startDay;
        }
    }

    @Override
    public void setDayStart(int startDay) {
        this.startDay = startDay;
    }

    @Override
    public void setDayEnd(int endDay) {
        this.endDay = endDay;
    }

    @Override
    public int getDayStart() {
        return startDay;
    }

    @Override
    public int getDayEnd() {
        return endDay;
    }

    @Override
    public int getSelectedDay() {
        return mSelectedDay;
    }

    @Override
    public void setSelectedDay(int day) {
        if (day > endDay) {
            mSelectedDay = endDay;
        } else if (day < startDay) {
            mSelectedDay = startDay;
        } else {
            mSelectedDay = day;
        }
        updateSelectedDay();
    }

    @Override
    public int getCurrentDay() {
        return Integer.valueOf(String.valueOf(getData().get(getCurrentItemPosition())));
    }

    @Override
    public void setYearAndMonth(int year, int month) {
        mYear = year;
        mMonth = month - 1;
        updateDays();
    }

    @Override
    public int getYear() {
        return mYear;
    }

    @Override
    public void setYear(int year) {
        mYear = year;
        updateDays();
    }

    @Override
    public int getMonth() {
        return mMonth;
    }

    @Override
    public void setMonth(int month) {
        mMonth = month - 1;
        updateDays();
    }
}