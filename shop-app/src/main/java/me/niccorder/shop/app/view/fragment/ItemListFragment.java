package me.niccorder.shop.app.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.BindView;
import me.niccorder.shop.app.R;
import me.niccorder.shop.app.model.ViewItemModel;
import me.niccorder.shop.app.view.adapter.ItemAdapter;
import me.niccorder.shop.domain.model.DomainItemModel;

public class ItemListFragment extends AbstractFragment {
  private static final String TAG = ItemListFragment.class.getSimpleName();

  private ViewItemModel[] models = new ViewItemModel[] {
      new ViewItemModel("0", "cheese", "mmm cheesy", 24.0f),
      new ViewItemModel("0", "cheese", "mmm cheesy", 24.0f),
      new ViewItemModel("0", "cheese", "mmm cheesy", 24.0f),
      new ViewItemModel("0", "cheese", "mmm cheesy", 24.0f),
      new ViewItemModel("0", "cheese", "mmm cheesy", 24.0f)
  };


  @BindView(R.id.recycler) RecyclerView mRecycler;

  private ItemAdapter mRecyclerAdapter;

  @Override protected int provideLayoutId() {
    return R.layout.layout_recycler;
  }

  @Override protected String provideLogTag() {
    return TAG;
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mRecyclerAdapter = new ItemAdapter();
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    mRecycler.setAdapter(mRecyclerAdapter);
    mRecyclerAdapter.addItems(models);
  }
}
