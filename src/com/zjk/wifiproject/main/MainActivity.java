package com.zjk.wifiproject.main;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;

import com.zjk.wifiproject.app.AppFragment;
import com.zjk.wifiproject.drawer.DrawerFragment;
import com.zjk.wifiproject.file.FileFragment;
import com.zjk.wifiproject.music.MusicFragment;
import com.zjk.wifiproject.picture.PictureFragment;
import com.zjk.wifiproject.presenters.BasePresenterActivity;
import com.zjk.wifiproject.vedio.VedioFragment;

public class MainActivity extends BasePresenterActivity<MainVu> {

    private List<Fragment> list = new ArrayList<Fragment>();

    @Override
    protected void onBindVu() {
        // 侧滑菜单
        DrawerFragment drawerMenu = new DrawerFragment();
        vu.setDrawerMenu(getFragmentManager(), drawerMenu);
        // 主界面
        list.add(new AppFragment());
        list.add(new MusicFragment());
        list.add(new PictureFragment());
        list.add(new VedioFragment());
        list.add(new FileFragment());
        vu.setViewPager(list);
    }

    @Override
    protected Class<MainVu> getVuClass() {
        return MainVu.class;
    }
}