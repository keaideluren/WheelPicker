package com.aigestudio.wheelpicker;

/**
 * Created by Administrator 拇指/可爱的路人 on 2018/12/12 0012.
 * Email:513421345@qq.com
 * TODO
 */
public interface IWheelDataTransformer<T> {
    /**
     * 将指定数据转换为string用来显示
     *
     * @return 展示在界面中的数据
     */
    String transform(T data);
}
