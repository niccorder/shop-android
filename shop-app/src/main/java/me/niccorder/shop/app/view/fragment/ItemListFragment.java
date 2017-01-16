package me.niccorder.shop.app.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.BindView;
import com.airbnb.epoxy.SimpleEpoxyAdapter;
import java.util.Collection;
import javax.inject.Inject;
import me.niccorder.shop.app.R;
import me.niccorder.shop.app.di.compontents.ItemComponent;
import me.niccorder.shop.app.model.ViewItemModel;
import me.niccorder.shop.app.model.ViewModelMapper;
import me.niccorder.shop.app.pres.ItemListPresenter;
import me.niccorder.shop.app.view.ListItemView;
import me.niccorder.shop.app.view.adapter.model.ItemHolder_;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A fragment which will display items in a list. This can, and should be handled by our
 * ItemListPresenter, which should be handling what type of data we want to display. However, in
 * this first draft the ItemListPresenter will do nothing but 'get all items'. This setup is
 * intended to allow the {@link ItemListPresenter} to be extended in such a way that our {@link
 * ItemListFragment} is negligent to how we decided our data will be displayed.
 *
 * For example, we could have a GetPopularListPresenter, GetNewListPresenter,
 * GetPurchasedListPresenter... etc. and we can still reuse this ItemListFragment :-)
 */
public class ItemListFragment extends AbstractFragment implements ListItemView {
  private static final String TAG = ItemListFragment.class.getSimpleName();

  @Inject ItemListPresenter mPresenter;
  @Inject ViewModelMapper mMapper;

  @BindView(R.id.recycler) RecyclerView mRecycler;

  private SimpleEpoxyAdapter mRecyclerAdapter;

  public static ItemListFragment newInstance() {
    return new ItemListFragment();
  }

  @Override protected int provideLayoutId() {
    return R.layout.layout_recycler;
  }

  @Override protected String provideLogTag() {
    return TAG;
  }

  @Override public void addItem(ViewItemModel model) {
    mRecyclerAdapter.addModels(new ItemHolder_().itemId(model.id)
        .description(model.description)
        .price(model.price)
        .name(model.name));
  }

  @Override public void addItems(ViewItemModel... models) {
    Observable.from(models)
        .map(model -> new ItemHolder_().itemId(model.id)
            .description(model.description)
            .price(model.price)
            .name(model.name))
        .toList()
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(mRecyclerAdapter::addModels);
  }

  @Override public void addItems(Collection<ViewItemModel> models) {
    Observable.from(models)
        .map(model -> new ItemHolder_().itemId(model.id)
            .description(model.description)
            .price(model.price)
            .name(model.name))
        .toList()
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(mRecyclerAdapter::addModels);
  }

  @Override public void removeItem(ViewItemModel model) {
    mRecyclerAdapter.removeModel(new ItemHolder_().itemId(model.id)
        .description(model.description)
        .price(model.price)
        .name(model.name));
  }

  @Override public void removeItems(ViewItemModel... models) {
    Observable.from(models)
        .map(mMapper::mapToHolder)
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(mRecyclerAdapter::removeModel);
  }

  @Override public void removeAllItems() {
    Observable.from(mRecyclerAdapter.getModels()).subscribe(mRecyclerAdapter::removeModel);
  }

  @Override public void onDisplayModel(ViewItemModel model) {
    // TODO: 1/16/17 when a model has been clicked we usually want to do something.
  }

  @Override public void showLoading(boolean show) {
    // TODO: 1/16/17 usually we want to show a progressbar when loading data.
  }

  @Override public void showNetworkError(boolean show) {
    // TODO: 1/16/17 if we have bad network, we want to display a contextual message.
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Inject dependencies.
    getComponent(ItemComponent.class).inject(this);

    // Setup adapter.
    mRecyclerAdapter = new SimpleEpoxyAdapter();
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    // Attach our adapter (provides/manages our recycler's data)
    mRecycler.setAdapter(mRecyclerAdapter);

    // Notify the presenter we have been created.
    mPresenter.create();
  }

  @Override public void onResume() {
    super.onResume();

    // Notify the presenter we are resuming.
    mPresenter.resume();
  }

  @Override public void onPause() {
    super.onPause();

    // Notify the presenter we are pausing.
    mPresenter.pause();
  }

  @Override public void onDestroyView() {
    super.onDestroyView();

    // Notify the presenter we are destroying.
    mPresenter.destroy();
  }
}
