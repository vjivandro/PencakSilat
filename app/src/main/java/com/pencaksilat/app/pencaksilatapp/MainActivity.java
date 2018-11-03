package com.pencaksilat.app.pencaksilatapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pencaksilat.app.pencaksilatapp.activity.InfoAplikasi;
import com.pencaksilat.app.pencaksilatapp.activity.KombinasiActivity;
import com.pencaksilat.app.pencaksilatapp.activity.SejarahActivity;
import com.pencaksilat.app.pencaksilatapp.activity.TeknikDasarActivity;
import com.pencaksilat.app.pencaksilatapp.model.MenuModel;
import com.pencaksilat.app.pencaksilatapp.utils.ItemDecorationColumns;

import java.util.List;

import static com.pencaksilat.app.pencaksilatapp.helper.Helper.getMenuDashboard;

public class MainActivity extends AppCompatActivity {

    private static long back_pressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<MenuModel> list = getMenuDashboard();

        RecyclerView listRow = (RecyclerView) findViewById(R.id.recyclerview);

        DasboardAdapter adapter = new DasboardAdapter(list, this);
        listRow.setAdapter(adapter);

        GridLayoutManager manager = new GridLayoutManager(this, 2,
                GridLayoutManager.VERTICAL, false);
        listRow.setLayoutManager(manager);
        listRow.addItemDecoration(new ItemDecorationColumns(2, 2));
    }

    private class DasboardAdapter extends RecyclerView.Adapter<DasboardAdapter.ViewHolder>{

        List<MenuModel> list;
        Context context;

        public DasboardAdapter(List<MenuModel> list, Context context) {
            this.list = list;
            this.context = context;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(context).inflate(R.layout.recycleview_menu, viewGroup,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            viewHolder.title_tv.setText(list.get(i).getTitle());
            viewHolder.imageView.setImageResource(list.get(i).getImage());
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            TextView title_tv;
            ImageView imageView;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                title_tv = (TextView) itemView.findViewById(R.id.tv_title);
                imageView =(ImageView) itemView.findViewById(R.id.iv_imageview);

                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {

                if (getPosition() == 0) {
                    startActivity(new Intent(v.getContext(), SejarahActivity.class));
                } else if (getPosition() == 1) {
                    startActivity(new Intent(v.getContext(), TeknikDasarActivity.class));
                } else if (getPosition() == 2) {
                    startActivity(new Intent(v.getContext(), KombinasiActivity.class));
                } else if (getPosition() == 3) {
                    startActivity(new Intent(v.getContext(), InfoAplikasi.class));
                }
            }
        }
    }

    @Override
    public void onBackPressed() {

        if (back_pressed + 2000 > System.currentTimeMillis()) super.onBackPressed();
        else Toast.makeText(getBaseContext(), "Tekan Sekali Lagi Untuk Keluar", Toast.LENGTH_SHORT).show();
        back_pressed = System.currentTimeMillis();

    }
}
