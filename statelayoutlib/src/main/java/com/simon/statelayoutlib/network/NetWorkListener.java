package com.simon.statelayoutlib.network;


/**
 * Created by: Simon
 * Email: simon.han0220@gmail.com
 * Created on: 2015/11/20 14:17
 */

public interface NetWorkListener {
    void onNetWorkConnected(NetUtils.NetType type);

    void onNetWorkDisConnect();
}
