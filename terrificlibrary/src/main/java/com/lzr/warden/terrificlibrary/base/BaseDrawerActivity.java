package com.lzr.warden.terrificlibrary.base;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.lzr.warden.terrificlibrary.R;
import com.lzr.warden.terrificlibrary.constant.Config;


/**
 * <pre>
 *     author: Blankj
 *     editor: Warden
 *     blog  : http://blankj.com
 *     time  : 2017/06/27
 *     desc  : base about drawer activity
 * </pre>
 */
public abstract class BaseDrawerActivity extends BaseActivity {

    protected DrawerLayout rootLayout;
    protected FrameLayout flActivityContainer;
    private int drawerRes = -1;

    NavigationView.OnNavigationItemSelectedListener mListener = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int i = item.getItemId();
            if (i == R.id.action_git_hub) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Config.GITHUB)));

            } else if (i == R.id.action_blog) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Config.BLOG)));

            }

            return false;
        }
    };

    public void setDrawer(@LayoutRes int layoutId){
        drawerRes = layoutId;
    }
    public void setItemListener(NavigationView.OnNavigationItemSelectedListener listener){
        mListener = listener;
    }

    @Override
    protected void setBaseView(@LayoutRes int layoutId) {
        if (drawerRes == -1) {
            drawerRes = R.layout.activity_drawer;
        }
        mContentView = LayoutInflater.from(this).inflate(drawerRes, null);
        setContentView(mContentView);
        rootLayout = findViewById(R.id.root_layout);
        flActivityContainer = findViewById(R.id.activity_container);
        flActivityContainer.addView(LayoutInflater.from(this).inflate(layoutId, flActivityContainer, false));
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(mListener);
    }
}
