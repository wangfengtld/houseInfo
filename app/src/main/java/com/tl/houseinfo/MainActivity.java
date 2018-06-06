package com.tl.houseinfo;

import android.app.Activity;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.aspsine.irecyclerview.IRecyclerView;
import com.aspsine.irecyclerview.OnLoadMoreListener;
import com.aspsine.irecyclerview.OnRefreshListener;
import com.tl.adapter.ImageAdapter;
import com.tl.adapter.OnItemClickListener;
import com.tl.model.Area;
import com.tl.model.GetAreaList;
import com.tl.model.GetHouseEstatesByProject;
import com.tl.model.GetProjectsByArea;
import com.tl.model.HouseEstate;
import com.tl.model.Image;
import com.tl.model.Project;
import com.tl.network.NetworkAPI;
import com.tl.utils.ListUtils;
import com.tl.views.BannerView;
import com.tl.views.footer.LoadMoreFooterView;

import java.util.ArrayList;
import java.util.List;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class MainActivity extends Activity implements OnItemClickListener<Project>, OnRefreshListener, OnLoadMoreListener {

    private IRecyclerView      iRecyclerView;
    private BannerView         bannerView;
    private LoadMoreFooterView loadMoreFooterView;

    private ImageAdapter mAdapter;

    private int          mPage;
    private LinearLayout linearLayoutH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayoutH = (LinearLayout) findViewById(R.id.linear_layout_h);
        iRecyclerView = (IRecyclerView) findViewById(R.id.iRecyclerView);
        iRecyclerView.setLayoutManager(new LinearLayoutManager(this));

//        bannerView = (BannerView) LayoutInflater.from(this).inflate(R.layout.layout_banner_view, iRecyclerView.getHeaderContainer(), false);
//        iRecyclerView.addHeaderView(bannerView);

        loadMoreFooterView = (LoadMoreFooterView) iRecyclerView.getLoadMoreFooterView();

        mAdapter = new ImageAdapter();
        iRecyclerView.setIAdapter(mAdapter);

        iRecyclerView.setOnRefreshListener(this);
        iRecyclerView.setOnLoadMoreListener(this);

        mAdapter.setOnItemClickListener(this);

        iRecyclerView.setRefreshEnabled(false);
        iRecyclerView.setLoadMoreEnabled(false);

        iRecyclerView.post(new Runnable() {
            @Override
            public void run() {
                iRecyclerView.setRefreshing(true);
            }
        });
    }


    private void loadTabView(GetAreaList<Area> getAreaList) {
        Area area = new Area(-1000, "全部", "北京");
        List<Area> list = new ArrayList<Area>();
        list.add(area);
        list.addAll(getAreaList.getAreaList());

        for (int j = 0; j < list.size(); j++) {
            TextView textView = new TextView(this);
            textView.setText(list.get(j).getName());

            linearLayoutH.addView(textView, new LinearLayout.LayoutParams(WRAP_CONTENT, MATCH_PARENT));
        }

    }

    @Override
    public void onItemClick(int position, Project project, View v) {
//        mAdapter.remove(position);
        Toast.makeText(this, String.valueOf(position), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRefresh() {
//        loadBanner();
        loadMoreFooterView.setStatus(LoadMoreFooterView.Status.GONE);
        refresh();
    }

    @Override
    public void onLoadMore() {
        if (loadMoreFooterView.canLoadMore() && mAdapter.getItemCount() > 0) {
            loadMoreFooterView.setStatus(LoadMoreFooterView.Status.LOADING);
//            loadMore();
        }
    }


    private void loadBanner() {
        NetworkAPI.requestBanners(new NetworkAPI.Callback<List<Image>>() {
            @Override
            public void onSuccess(List<Image> images) {
                if (!ListUtils.isEmpty(images)) {
                    bannerView.setList(images);
                }
            }

            @Override
            public void onFailure(Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void refresh() {
//        mPage = 1;
//        NetworkAPI.requestImages(mPage, new NetworkAPI.Callback<List<Image>>() {
//            @Override
//            public void onSuccess(List<Image> images) {
//                iRecyclerView.setRefreshing(false);
//                if (ListUtils.isEmpty(images)) {
//                    mAdapter.clear();
//                } else {
//                    mPage = 2;
//                    mAdapter.setList(images);
//                }
//            }
//
//            @Override
//            public void onFailure(Exception e) {
//                e.printStackTrace();
//                iRecyclerView.setRefreshing(false);
//                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
//            }
//        });


        NetworkAPI.requestAreaList(new NetworkAPI.Callback<GetAreaList<Area>>() {
            @Override
            public void onSuccess(GetAreaList<Area> getAreaList) {
                loadTabView(getAreaList);
            }

            @Override
            public void onFailure(Exception e) {
                Log.d("message", "failed......");

            }
        });

        NetworkAPI.requestProjectsByArea(new NetworkAPI.Callback<GetProjectsByArea<Project>>() {
            @Override
            public void onSuccess(GetProjectsByArea<Project> projectGetProjectsByArea) {
                Log.d("message", "success......" + projectGetProjectsByArea.getCode());
                iRecyclerView.setRefreshing(false);
                if (ListUtils.isEmpty(projectGetProjectsByArea.getProjects())) {
                    mAdapter.clear();
                } else {
                    mAdapter.setList(projectGetProjectsByArea.getProjects());
                }
            }

            @Override
            public void onFailure(Exception e) {
                Log.d("message", "failed......");
            }
        });

        NetworkAPI.requestHouseEstatesByProject(2, new NetworkAPI.Callback<GetHouseEstatesByProject<HouseEstate>>() {
            @Override
            public void onSuccess(GetHouseEstatesByProject<HouseEstate> getHouseEstatesByProject) {
                Log.d("message", "success......" + getHouseEstatesByProject.getCode());
            }

            @Override
            public void onFailure(Exception e) {
                Log.d("message", "failed......");
            }
        });

    }

//    private void loadMore() {
//        NetworkAPI.requestImages(mPage, new NetworkAPI.Callback<List<Image>>() {
//            @Override
//            public void onSuccess(final List<Image> images) {
//                if (ListUtils.isEmpty(images)) {
//                    loadMoreFooterView.setStatus(LoadMoreFooterView.Status.THE_END);
//                } else {
//
//                    loadMoreFooterView.postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            mPage++;
//                            loadMoreFooterView.setStatus(LoadMoreFooterView.Status.GONE);
//                            mAdapter.append(images);
//                        }
//                    }, 2000);
//                }
//            }
//
//            @Override
//            public void onFailure(Exception e) {
//                e.printStackTrace();
//                loadMoreFooterView.setStatus(LoadMoreFooterView.Status.ERROR);
//                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

}
