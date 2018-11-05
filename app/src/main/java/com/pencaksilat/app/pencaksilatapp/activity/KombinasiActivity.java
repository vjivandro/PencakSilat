package com.pencaksilat.app.pencaksilatapp.activity;

import android.content.Context;
import android.content.Intent;
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

import com.pencaksilat.app.pencaksilatapp.R;
import com.pencaksilat.app.pencaksilatapp.helper.Helper;
import com.pencaksilat.app.pencaksilatapp.model.MenuModel;
import com.pencaksilat.app.pencaksilatapp.utils.ItemDecorationColumns;

import java.util.List;

import static com.pencaksilat.app.pencaksilatapp.helper.Helper.getMenuKombinasi;

public class KombinasiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kombinasi);

        List<MenuModel> list = Helper.getMenuKombinasi();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        KombinasiAdapter adapter = new KombinasiAdapter(list, this);
        recyclerView.setAdapter(adapter);

        GridLayoutManager manager = new GridLayoutManager(this, 2,
                GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new ItemDecorationColumns(2, 2));
    }

    private class KombinasiAdapter extends RecyclerView.Adapter<KombinasiAdapter.ViewHolder>{

        List<MenuModel> list;
        Context context;

        public KombinasiAdapter(List<MenuModel> list, Context context) {
            this.list = list;
            this.context = context;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.recycleview_menu, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.title_tv.setText(list.get(position).getTitle());
            holder.imageView.setImageResource(list.get(position).getImage());
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
                imageView = (ImageView) itemView.findViewById(R.id.iv_imageview);

                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                if (getPosition() == 0) {
                    startActivity(new Intent(v.getContext(), CaraActivity.class));
                } else if (getPosition() == 1) {
                    startActivity(new Intent(v.getContext(), VideoActivity.class));
                }
            }
        }
    }
}
