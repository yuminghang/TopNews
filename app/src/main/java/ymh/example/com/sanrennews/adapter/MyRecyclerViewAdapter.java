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
import ymh.example.com.sanrennews.R;
import ymh.example.com.sanrennews.bean.toutiaobean;
import ymh.example.com.sanrennews.ui.WebviewActivity;

/**
 * Created by ymh on 2016/3/8.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private toutiaobean list;
    private final int THREE_PIC = 1;
    private final int NO_PIC = 0;

    public MyRecyclerViewAdapter(Context context, toutiaobean list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public int getItemViewType(int position) {
        if (list.getData().get(position).getJsonString().getImage_list().size() == 3) {
            return THREE_PIC;
        } else {
            return NO_PIC;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == THREE_PIC) {
            View view = LayoutInflater.from(context).inflate(R.layout.newsitem_layout, parent, false);
            return new ThreePicViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.newnopic_layout, parent, false);
            return new NoPicViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ThreePicViewHolder) {
            ThreePicViewHolder threePicViewHolder = (ThreePicViewHolder) holder;
            threePicViewHolder.title.setText(list.getData().get(position).getJsonString().getTitle());
            Glide.with(context).load(list.getData().get(position).getJsonString().getImage_list().get(0).get("url")).into(threePicViewHolder.iv_Pic1);
            Glide.with(context).load(list.getData().get(position).getJsonString().getImage_list().get(1).get("url")).into(threePicViewHolder.iv_Pic2);
            Glide.with(context).load(list.getData().get(position).getJsonString().getImage_list().get(2).get("url")).into(threePicViewHolder.iv_Pic3);
        } else {
            NoPicViewHolder noPicViewHolder = (NoPicViewHolder) holder;
            noPicViewHolder.title.setText(list.getData().get(position).getJsonString().getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return list.getData().size();
    }

    class ThreePicViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv_Pic1, iv_Pic2, iv_Pic3;
        public TextView title, content;

        public ThreePicViewHolder(View view) {
            super(view);
            iv_Pic1 = (ImageView) view.findViewById(R.id.iv_pic1);
            iv_Pic2 = (ImageView) view.findViewById(R.id.iv_pic2);
            iv_Pic3 = (ImageView) view.findViewById(R.id.iv_pic3);
            title = (TextView) view.findViewById(R.id.newstitle_TextView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putString("url", list.getData().get(getLayoutPosition()).getJsonString().getUrl());
                    bundle.putString("title", list.getData().get(getLayoutPosition()).getJsonString().getTitle());
                    Intent intent = new Intent(context, WebviewActivity.class);
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            });
        }
    }

    //    class SinglePicViewHolder extends RecyclerView.ViewHolder {
//        public ImageView iv_Pic;
//        public TextView title;
//
//        public SinglePicViewHolder(View view) {
//            super(view);
//            iv_Pic = (ImageView) view.findViewById(R.id.iv_pic);
//            title = (TextView) view.findViewById(R.id.newstitle_TextView);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Bundle bundle = new Bundle();
//                    bundle.putString("url", list.getData().get(getLayoutPosition()).getJsonString().getUrl());
//                    bundle.putString("title", list.getData().get(getLayoutPosition()).getJsonString().getTitle());
//                    Intent intent = new Intent(context, WebviewActivity.class);
//                    intent.putExtras(bundle);
//                    context.startActivity(intent);
//                }
//            });
//        }
//    }
    class NoPicViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        public NoPicViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.newstitle_TextView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putString("url", list.getData().get(getLayoutPosition()).getJsonString().getUrl());
                    bundle.putString("title", list.getData().get(getLayoutPosition()).getJsonString().getTitle());
                    Intent intent = new Intent(context, WebviewActivity.class);
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            });
        }
    }
}
