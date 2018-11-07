package com.pencaksilat.app.pencaksilatapp.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pencaksilat.app.pencaksilatapp.MainActivity;
import com.pencaksilat.app.pencaksilatapp.R;
import com.pencaksilat.app.pencaksilatapp.helper.Helper;
import com.pencaksilat.app.pencaksilatapp.model.RuleModel;

import java.util.List;

public class PetunjukActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petunjuk);

        List<RuleModel> ruleModelList = Helper.getRuleApp();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        RuleAdapter adapter = new RuleAdapter(ruleModelList, this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private class RuleAdapter extends RecyclerView.Adapter<RuleAdapter.ViewHolder>{

        List<RuleModel> listRule;
        Context context;
        String kode, content;

        public RuleAdapter(List<RuleModel> listRule, Context context) {
            this.listRule = listRule;
            this.context = context;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.recylcerview_rule, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.imageView.setImageResource(listRule.get(position).getImage());
            holder.kode_tv.setText(listRule.get(position).getKode());
            holder.title_tv.setText(listRule.get(position).getTitle());
            holder.content_tv.setText(listRule.get(position).getContent());
        }

        @Override
        public int getItemCount() {
            return listRule.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            TextView kode_tv, title_tv, content_tv;
            ImageView imageView;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                kode_tv = (TextView) itemView.findViewById(R.id.tv_kode);
                title_tv = (TextView) itemView.findViewById(R.id.tv_title);
                content_tv = (TextView) itemView.findViewById(R.id.tv_content);
                imageView = (ImageView) itemView.findViewById(R.id.iv_imageview);

                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                content = content_tv.getText().toString();
                kode = kode_tv.getText().toString();

                System.out.println(content);

//                AlertDialog.Builder builder = new AlertDialog.Builder(itemView.getContext())
//                        .setMessage(content)
//                        .setCancelable(true)
//                        .setPositiveButton("tutup", null);
//                builder.create();
//                builder.show();

                AlertDialog.Builder alertadd = new AlertDialog.Builder(itemView.getContext());
                LayoutInflater factory = LayoutInflater.from(itemView.getContext());
                View view = factory.inflate(R.layout.image_dialog, null);
                ImageView myImage = (ImageView) view.findViewById(R.id.imageview);
                if (kode.equals("1")) {
                    myImage.setImageResource(R.mipmap.ic_sejarah);
                } else if (kode.equals("2")) {
                    myImage.setImageResource(R.mipmap.ic_basic);
                }

                alertadd.setView(view);
                alertadd.setCancelable(true);
                alertadd.show();

            }
        }

    }
}
