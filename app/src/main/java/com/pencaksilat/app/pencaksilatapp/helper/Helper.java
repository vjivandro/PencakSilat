package com.pencaksilat.app.pencaksilatapp.helper;

import android.view.Menu;

import com.pencaksilat.app.pencaksilatapp.R;
import com.pencaksilat.app.pencaksilatapp.model.MenuModel;

import java.util.ArrayList;
import java.util.List;

public class Helper {

    // Dashboard
    public static List<MenuModel> getMenuDashboard() {
        List<MenuModel> lisDashboard = new ArrayList<MenuModel>();
        lisDashboard.add(new MenuModel("Sejarah", R.mipmap.ic_sejarah));
        lisDashboard.add(new MenuModel("Teknik Dasar", R.mipmap.ic_basic));
        lisDashboard.add(new MenuModel("Kombinasi", R.mipmap.ic_combine));
        lisDashboard.add(new MenuModel("Info Aplikasi", R.mipmap.ic_info));
        return lisDashboard;
    }

    // Menu Kombinasi
    public static List<MenuModel> getMenuKombinasi() {

        List<MenuModel> lisKombinasi = new ArrayList<MenuModel>();
        lisKombinasi.add(new MenuModel("Cara", R.mipmap.ic_cara));
        lisKombinasi.add(new MenuModel("Video", R.mipmap.ic_video));
        return lisKombinasi;
    }

    // Menu Info
    public static List<MenuModel> getInfoAplikasi(){

        List<MenuModel> listInfo = new ArrayList<MenuModel>();
        listInfo.add(new MenuModel("Profil", R.mipmap.ic_user));
        listInfo.add(new MenuModel("Developer", R.mipmap.ic_dev_mobile));
        listInfo.add(new MenuModel("About", R.mipmap.ic_about_app));
        return listInfo;
    }
}
