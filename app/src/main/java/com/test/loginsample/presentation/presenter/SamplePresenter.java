package com.test.loginsample.presentation.presenter;


import com.test.loginsample.domain.interactor.DefaultObserver;
import com.test.loginsample.domain.interactor.GetTownshipList;
import com.test.loginsample.domain.model.Township;
import com.test.loginsample.presentation.model.TownshipModel;
import com.test.loginsample.presentation.model.mapper.TownshipModelMapper;
import com.test.loginsample.presentation.view.TownshipListView;

import java.util.List;



public class SamplePresenter implements Presenter{
    private TownshipListView townshipListView;
    private final GetTownshipList getTownshipList;
    private final TownshipModelMapper townshipModelMapper;

    public SamplePresenter(GetTownshipList getTownshipList, TownshipModelMapper townshipModelMapper){
        this.getTownshipList = getTownshipList;
        this.townshipModelMapper = townshipModelMapper;
    }

    public void setTownshipListView(TownshipListView townshipListView){
        this.townshipListView = townshipListView;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        this.getTownshipList.dispose();
        this.townshipListView = null;
    }

    public void initialize(){
        this.loadTownshipList();
    }

    private void loadTownshipList() {
        this.showViewLoading();
        this.getTownshipList();
    }

    private void showViewLoading() {
        this.townshipListView.showLoading();
    }

    private void hideViewLoading() {
        this.townshipListView.hideLoading();
    }

    private void showErrorMessage(String errorMessage) {
        this.townshipListView.showError(errorMessage);
    }

    private void showTownshipListInView(List<Township> townships) {
        final List<TownshipModel> townshipModelList =
                this.townshipModelMapper.transformList(townships);
        this.townshipListView.renderTownshipList(townshipModelList);
    }

    private void getTownshipList() {
        this.getTownshipList.execute(new TownshipListObserver(), null);
    }

    private final class TownshipListObserver extends DefaultObserver<List<Township>> {

        @Override
        public void onComplete() {
            SamplePresenter.this.hideViewLoading();
        }

        @Override
        public void onError(Throwable e) {
            e.printStackTrace();
            SamplePresenter.this.hideViewLoading();
            SamplePresenter.this.showErrorMessage(e.getLocalizedMessage());
        }

        @Override
        public void onNext(List<Township> townships) {
            SamplePresenter.this.showTownshipListInView(townships);
        }
    }
}
