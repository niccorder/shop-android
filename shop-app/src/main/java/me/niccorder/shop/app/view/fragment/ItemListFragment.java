package me.niccorder.shop.app.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.BindView;
import java.util.Collection;
import javax.inject.Inject;
import me.niccorder.shop.app.R;
import me.niccorder.shop.app.model.ViewItemModel;
import me.niccorder.shop.app.pres.ItemListPresenter;
import me.niccorder.shop.app.view.ListItemView;
import me.niccorder.shop.app.view.adapter.ItemAdapter;

public class ItemListFragment extends AbstractFragment implements ListItemView {
  private static final String TAG = ItemListFragment.class.getSimpleName();

  @Inject ItemListPresenter mPresenter;

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

  @Override public void addItem(ViewItemModel model) {

  }

  @Override public void addItems(ViewItemModel... models) {

  }

  @Override public void addItems(Collection<ViewItemModel> models) {

  }

  @Override public void removeItem(ViewItemModel model) {

  }

  @Override public void removeItems(ViewItemModel... models) {

  }

  @Override public void removeAllItems() {

  }

  @Override public void onDisplayModel(ViewItemModel model) {

  }

  @Override public void showLoading(boolean show) {

  }

  @Override public void showNetworkError(boolean show) {

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
