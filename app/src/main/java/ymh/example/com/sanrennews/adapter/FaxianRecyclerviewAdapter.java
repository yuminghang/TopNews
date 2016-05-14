package ymh.example.com.sanrennews.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import ymh.example.com.sanrennews.R;
import ymh.example.com.sanrennews.bean.faxianbean;

/**
 * Created by ymh on 2016/3/11.
 */
public class FaxianRecyclerviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private faxianbean list;
    private final int THREE_PIC = 1;
    private final int SINGL_EPIC = 0;

    public FaxianRecyclerviewAdapter(Context context, faxianbean list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.faxianitem_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
//        if (list.getData().get(position).getType() == 0) {
        myViewHolder.title.setText(list.getData().get(position).getTitle());
        Glide.with(context).load(list.getData().get(position).getImgsmall()).into(myViewHolder.iv_Pic);
//        }
    }

    @Override
    public int getItemCount() {
        return list.getData().size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv_Pic;
        public TextView title;

        public MyViewHolder(View view) {
            super(view);
            iv_Pic = (ImageView) view.findViewById(R.id.iv_Pic);
            title = (TextView) view.findViewById(R.id.title);
        }
    }
}
