package com.simon.statelayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.simon.statelayoutlib.network.NetChangeObserver;
import com.simon.statelayoutlib.network.NetStateReceiver;
import com.simon.statelayoutlib.network.NetUtils;
import com.simon.statelayoutlib.statelayout.StateReplaceHeplerImpl;
import com.simon.statelayoutlib.statelayout.StateViewHelperController;

public class StateActivity extends AppCompatActivity {

    /**
     * 网络观察者
     */
    protected NetChangeObserver mNetChangeObserver = null;
    private StateViewHelperController mStateViewHelperController;
    private LinearLayout mMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state);
        mMain = (LinearLayout) findViewById(R.id.state_content);
        String type = getIntent().getStringExtra("type");
        if ("Replace".equals(type)) {
            mStateViewHelperController = new StateViewHelperController(new StateReplaceHeplerImpl
                    (mMain));
        } else {
            mStateViewHelperController = new StateViewHelperController(mMain);
        }
        initObserver();
    }

    /**
     * 初始化网络监听
     */
    protected void initObserver() {
        mNetChangeObserver = new NetChangeObserver() {
            @Override
            public void onNetConnected(NetUtils.NetType type) {
                Toast.makeText(StateActivity.this, type.name(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNetDisConnect() {
                Toast.makeText(StateActivity.this, "当前网络不可用", Toast.LENGTH_SHORT).show();
            }
        };

        NetStateReceiver.registerObserver(mNetChangeObserver);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        item.setChecked(true);
        if (id == R.id.action_content) {
            mStateViewHelperController.restore();
            return true;
        } else if (id == R.id.action_loading) {
            mStateViewHelperController.showStateLoading("正在加载...");
            return true;
        } else if (id == R.id.action_empty) {
            mStateViewHelperController.showStateEmpty("什么都没有", null);
            return true;
        } else if (id == R.id.action_error) {
            mStateViewHelperController.showStateError("加载出错了", null);
            return true;
        } else if (id == R.id.action_net_error) {
            mStateViewHelperController.showStateNetworkError(null);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.state, menu);
        return super.onCreateOptionsMenu(menu);
    }

}
