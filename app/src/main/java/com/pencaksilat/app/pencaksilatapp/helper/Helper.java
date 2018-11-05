package com.pencaksilat.app.pencaksilatapp.helper;

import android.view.Menu;

import com.pencaksilat.app.pencaksilatapp.R;
import com.pencaksilat.app.pencaksilatapp.model.MenuModel;
import com.pencaksilat.app.pencaksilatapp.model.RuleModel;

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
        listInfo.add(new MenuModel("Deskripsi", R.mipmap.ic_descript));
        listInfo.add(new MenuModel("Developer", R.mipmap.ic_dev_mobile));
        listInfo.add(new MenuModel("Editor", R.mipmap.ic_editor));
        listInfo.add(new MenuModel("About", R.mipmap.ic_about_app));
        return listInfo;
    }

    // Menu Petunjuk
    public static List<RuleModel> getRuleApp() {

        List<RuleModel> ruleModels = new ArrayList<RuleModel>();
        ruleModels.add(new RuleModel(R.string.rule_pertama, "Menu berisi Materi tentang Sejarah Pencak Silat", R.mipmap.ic_sejarah));
        ruleModels.add(new RuleModel(R.string.rule_kedua, "Menu kumpulan teknik - teknik dasar Pencak Silat", R.mipmap.ic_basic));
        ruleModels.add(new RuleModel(R.string.rule_ketiga, "Menu yang memiliki dua submenu", R.mipmap.ic_combine));
        ruleModels.add(new RuleModel(R.string.rule_ketiga_satu, "Submenu berisi tentang variasi latihan beberapa kombinasi", R.mipmap.ic_cara));
        ruleModels.add(new RuleModel(R.string.rule_ketiga_dua, "submenu berisi video yang terintegrasi dengan youtube", R.mipmap.ic_video));
        ruleModels.add(new RuleModel(R.string.rule_keempat, "Menu yang memiliki dua Submenu dan dua AlertDialog", R.mipmap.ic_info));
        ruleModels.add(new RuleModel(R.string.rule_keempat_satu, "Submenu tentang profile pemilik aplikasi", R.mipmap.ic_user));
        ruleModels.add(new RuleModel(R.string.rule_keempat_dua, "Submenu deskripsi aplikasi", R.mipmap.ic_descript));
        ruleModels.add(new RuleModel(R.string.rule_keempat_tiga, "AlertDialog Developer Mobile Android", R.mipmap.ic_dev_mobile));
        ruleModels.add(new RuleModel(R.string.rule_keempat_empat, "AlertDialog Designer", R.mipmap.ic_editor));
        ruleModels.add(new RuleModel(R.string.rule_keempat_lima, "Submenu berisi Tentang Aplikasi", R.mipmap.ic_about_app));
        return ruleModels;
    }
}
