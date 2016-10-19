package com.simon.statelayoutlib.statelayout;

import android.content.Context;
import android.view.View;

/**
 * Created by: Simon
 * Email: simon.han0220@gmail.com
 * Created on: 2015/8/28 10:42
 */

public interface StateViewHelper {
    View getCurrentLayout();

    void restoreView();

    void showLayout(View view);

    View inflate(int layoutId);

    Context getContext();

    View getView();
}
