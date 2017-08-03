package com.test.loginsample.presentation.view;


import com.test.loginsample.presentation.model.TownshipModel;

import java.util.List;



public interface TownshipListView extends LoadDataView {
    void renderTownshipList(List<TownshipModel> townshipModels);
}
