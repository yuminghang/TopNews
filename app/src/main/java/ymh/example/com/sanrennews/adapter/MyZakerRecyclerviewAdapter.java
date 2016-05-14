package ymh.example.com.sanrennews.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import ymh.example.com.sanrennews.R;
import ymh.example.com.sanrennews.bean.toutiaobean;
import ymh.example.com.sanrennews.bean.zakerjsonbean;
import ymh.example.com.sanrennews.ui.WebviewActivity;

/**
 * Created by ymh on 2016/5/13.
 */
public class MyZakerRecyclerviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<zakerjsonbean> list;
    private final int SINGLE_PIC = 0;
    private final int NO_PIC = 2;
    private int type = 0;

    public MyZakerRecyclerviewAdapter(Context context, List<zakerjsonbean> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public int getItemViewType(int position) {
        if (list.get(position).getImgnums() == 1) {
            return SINGLE_PIC;
        } else {
            return NO_PIC;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == SINGLE_PIC) {
            View view = LayoutInflater.from(context).inflate(R.layout.newsinglepic_layout, parent, false);
            return new SinglePicViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.newnopic_layout, parent, false);
            return new NoPicViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof SinglePicViewHolder) {
            SinglePicViewHolder singlePicViewHolder = (SinglePicViewHolder) holder;
            singlePicViewHolder.title.setText(list.get(position).getTitle());
            Glide.with(context).load(list.get(position).getImgurl()).into(singlePicViewHolder.iv_Pic);
        } else {
            NoPicViewHolder noPicViewHolder = (NoPicViewHolder) holder;
            noPicViewHolder.title.setText(list.get(position).getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class SinglePicViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv_Pic;
        public TextView title;

        public SinglePicViewHolder(View view) {
            super(view);
            iv_Pic = (ImageView) view.findViewById(R.id.iv_pic);
            title = (TextView) view.findViewById(R.id.newstitle_TextView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putString("url", ((toutiaobean) list).getData().get(getLayoutPosition()).getJsonString().getUrl());
                    bundle.putString("title", ((toutiaobean) list).getData().get(getLayoutPosition()).getJsonString().getTitle());
                    Intent intent = new Intent(context, WebviewActivity.class);
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            });
        }
    }

    class NoPicViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        public NoPicViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.newstitle_TextView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putString("url", ((toutiaobean) list).getData().get(getLayoutPosition()).getJsonString().getUrl());
                    bundle.putString("title", ((toutiaobean) list).getData().get(getLayoutPosition()).getJsonString().getTitle());
                    Intent intent = new Intent(context, WebviewActivity.class);
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            });
        }
    }
}
