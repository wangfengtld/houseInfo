package com.tl.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aspsine.irecyclerview.IViewHolder;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.tl.houseinfo.R;
import com.tl.model.Area;
import com.tl.model.Image;
import com.tl.model.Project;


import java.util.ArrayList;
import java.util.List;


public class ImageAdapter extends RecyclerView.Adapter<IViewHolder> {

    private List<Project> mlists;

    private OnItemClickListener<Project> mOnItemClickListener;

    public ImageAdapter() {
        mlists = new ArrayList<>();
    }

    public void setOnItemClickListener(OnItemClickListener<Project> listener) {
        this.mOnItemClickListener = listener;
    }

    public void setList(List<Project> list) {
        mlists.clear();
        append(list);
    }

    public void append(List<Project> list) {
        int positionStart = mlists.size();
        int itemCount = list.size();
        mlists.addAll(list);
        if (positionStart > 0 && itemCount > 0) {
            notifyItemRangeInserted(positionStart, itemCount);
        } else {
            notifyDataSetChanged();
        }
    }

    public void remove(int position) {
        mlists.remove(position);
        notifyItemRemoved(position);
    }

    public void clear() {
        mlists.clear();
        notifyDataSetChanged();
    }

    @Override
    public IViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.project_item, parent, false);

        final ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final int position = holder.getIAdapterPosition();
                final Project project = mlists.get(position);
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(position, project, v);
                }
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(IViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        Project project = mlists.get(position);

//        // 创建DisplayImageOptions对象并进行相关选项配置
//        DisplayImageOptions options = new DisplayImageOptions.Builder()
//            .showImageOnLoading(R.mipmap.ic_launcher)
//            .showImageForEmptyUri(R.mipmap.ic_launcher)// 设置图片Uri为空或是错误的时候显示的图片
//            .showImageOnFail(R.mipmap.ic_launcher)// 设置图片加载或解码过程中发生错误显示的图片
//            .cacheInMemory(true)// 设置下载的图片是否缓存在内存中
//            .cacheOnDisk(true)// 设置下载的图片是否缓存在SD卡中
////                    .displayer(new RoundedBitmapDisplayer(20))// 设置成圆角图片
//            .build();
//        ImageLoader.getInstance().displayImage(image.image, imageView, options);

        viewHolder.projectName.setText(project.getName());


    }

    @Override
    public int getItemCount() {
        return mlists.size();
    }

    static class ViewHolder extends IViewHolder {

        ImageView iv;
        TextView  projectName;
        TextView  isEnd;

        public ViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.imageView);
            projectName = (TextView) itemView.findViewById(R.id.tv_project);
            isEnd = (TextView) itemView.findViewById(R.id.tv_isEnd);

        }
    }
}
