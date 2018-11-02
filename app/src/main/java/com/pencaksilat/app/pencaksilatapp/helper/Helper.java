package com.pencaksilat.app.pencaksilatapp.helper;

import com.pencaksilat.app.pencaksilatapp.R;
import com.pencaksilat.app.pencaksilatapp.model.DashboardModel;

import java.util.ArrayList;
import java.util.List;

public class Helper {
    public static List<DashboardModel> getDashboard() {
        List<DashboardModel> lisDashboard = new ArrayList<DashboardModel>();
        lisDashboard.add(new DashboardModel("Sejarah", R.mipmap.ic_sejarah));
        lisDashboard.add(new DashboardModel("Teknik Dasar", R.mipmap.ic_basic));
        lisDashboard.add(new DashboardModel("Kombinasi", R.mipmap.ic_combine));
        lisDashboard.add(new DashboardModel("Info Aplikasi", R.mipmap.ic_info));
        return lisDashboard;
    }
}
