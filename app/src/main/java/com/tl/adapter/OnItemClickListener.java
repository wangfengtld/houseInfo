package com.tl.adapter;

import android.view.View;


public interface OnItemClickListener<T> {
    void onItemClick(int position, T t, View v);
}
