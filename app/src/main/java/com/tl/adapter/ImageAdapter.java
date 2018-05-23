package com.tl.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.aspsine.irecyclerview.IViewHolder;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.tl.houseinfo.R;
import com.tl.model.Image;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by aspsine on 16/4/5.
 */
public class ImageAdapter extends RecyclerView.Adapter<IViewHolder> {

    private List<Image> mImages;

    private OnItemClickListener<Image> mOnItemClickListener;

    public ImageAdapter() {
        mImages = new ArrayList<>();
    }

    public void setOnItemClickListener(OnItemClickListener<Image> listener) {
        this.mOnItemClickListener = listener;
    }

    public void setList(List<Image> images) {
        mImages.clear();
        append(images);
    }

    public void append(List<Image> images) {
        int positionStart = mImages.size();
        int itemCount = images.size();
        mImages.addAll(images);
        if (positionStart > 0 && itemCount > 0) {
            notifyItemRangeInserted(positionStart, itemCount);
        } else {
            notifyDataSetChanged();
        }
    }

    public void remove(int position) {
        mImages.remove(position);
        notifyItemRemoved(position);
    }

    public void clear(){
        mImages.clear();
        notifyDataSetChanged();
    }

    @Override
    public IViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ImageView imageView = (ImageView) LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_image_item, parent, false);

        final ViewHolder holder = new ViewHolder(imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * Note:
                 * in order to get the right position, you must use the method with i- prefix in
                 * {@link IViewHolder} eg:
                 * {@code IViewHolder.getIPosition()}
                 * {@code IViewHolder.getILayoutPosition()}
                 * {@code IViewHolder.getIAdapterPosition()}
                 */
                final int position = holder.getIAdapterPosition();
                final Image image = mImages.get(position);
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(position, image, v);
                }
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(IViewHolder holder, int position) {
        ImageView imageView = (ImageView) holder.itemView;
        Image image = mImages.get(position);
//        Glide.with(imageView.getContext()).load(image.image).dontAnimate().into(imageView);
        // 创建DisplayImageOptions对象并进行相关选项配置
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher)
                .showImageForEmptyUri(R.mipmap.ic_launcher)// 设置图片Uri为空或是错误的时候显示的图片
                    .showImageOnFail(R.mipmap.ic_launcher)// 设置图片加载或解码过程中发生错误显示的图片
                    .cacheInMemory(true)// 设置下载的图片是否缓存在内存中
                    .cacheOnDisk(true)// 设置下载的图片是否缓存在SD卡中
//                    .displayer(new RoundedBitmapDisplayer(20))// 设置成圆角图片
                .build();
        ImageLoader.getInstance().displayImage(image.image, imageView, options);
    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }

    static class ViewHolder extends IViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
