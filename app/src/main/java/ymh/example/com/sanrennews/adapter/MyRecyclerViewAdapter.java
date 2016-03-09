package ymh.example.com.sanrennews.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import ymh.example.com.sanrennews.R;
import ymh.example.com.sanrennews.bean.JsonBean;
import ymh.example.com.sanrennews.ui.WebviewActivity;

/**
 * Created by ymh on 2016/3/8.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<JsonBean> list;

    public MyRecyclerViewAdapter(Context context, ArrayList<JsonBean> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.newsitem_layout, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
//        holder.iv_Pic.set;
        holder.newstitle.setText(list.get(position).getTitle());
        holder.content.setText(list.get(position).getH());
        Glide.with(context).load(list.get(position).getImgurl1()).into(holder.iv_Pic);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv_Pic;
        public TextView newstitle, content;

        public MyViewHolder(View view) {
            super(view);
            iv_Pic = (ImageView) view.findViewById(R.id.iv_pic);
            newstitle = (TextView) view.findViewById(R.id.newstitle_TextView);
            content = (TextView) view.findViewById(R.id.content_TextView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Toast.makeText(context,"当前点击的位置"+getLayoutPosition(),Toast.LENGTH_SHORT).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("url", list.get(getLayoutPosition()).getH());
                    bundle.putString("title", list.get(getLayoutPosition()).getTitle());

                    Intent intent = new Intent(context, WebviewActivity.class);
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            });
        }
    }
}
