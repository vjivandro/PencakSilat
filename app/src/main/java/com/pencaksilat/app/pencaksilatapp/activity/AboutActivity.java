package com.pencaksilat.app.pencaksilatapp.activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.pencaksilat.app.pencaksilatapp.R;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener {

    public String Url_UM = "http://www.um.ac.id";
    public String Url_Fik = "http://www.um.ac.id/page/fakultas-ilmu-keolahragaan";
    public String kode_um = "0";
    public String kode_fik = "1";

    TextView versionTv, tv_link_um, tv_link_fik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        versionTv = (TextView) findViewById(R.id.tv_versi);
        tv_link_um = (TextView) findViewById(R.id.link_um);
        tv_link_fik = (TextView) findViewById(R.id.link_fik);

//        tv_link_um.setText(Url_UM);
//        tv_link_fik.setText(Url_Fik);

        //versi
        String versionName = "";
        int versionCode = -1;
        try {
            PackageInfo packageInfo = this.getPackageManager().
                    getPackageInfo(this.getPackageName(), 0);
            versionName = packageInfo.versionName;
            versionCode = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();

        }

        versionTv.setText("Versi : "+String.format(versionName));

        tv_link_um.setOnClickListener(this);
        tv_link_fik.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.link_um:
                Intent um = new Intent(this, WebViewActivity.class);
                um.putExtra("kode", kode_um);
                um.putExtra("um", Url_UM);
                startActivity(um);
                break;
            case R.id.link_fik:
                Intent fik = new Intent(this, WebViewActivity.class);
                fik.putExtra("kode", kode_fik);
                fik.putExtra("fik", Url_Fik);
                startActivity(fik);
                break;
            default:
                break;
        }

    }
}
