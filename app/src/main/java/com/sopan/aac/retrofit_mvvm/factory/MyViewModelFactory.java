package com.sopan.aac.retrofit_mvvm.factory;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * Created by Sopan Ahmed
 * on 25-Jan-23
 * copyright: ACI-Mobile Apps
 * email: supan@aci-bd.com
 */
public class MyViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private Application mApplication;
    private Object[] mParams;

    public MyViewModelFactory(Application application, Object... params) {
        mApplication = application;
        mParams = params;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        /*if (modelClass == ArticleViewModel.class) {
            return (T) new ArticleViewModel(mApplication);
        } else if (modelClass == MemberListViewModel.class) {
            return (T) new MemberListViewModel("key", mApplication);
        } else if (modelClass == ViewModel3.class) {
            return (T) new ViewModel3(mApplication, (Integer) mParams[0], (String) mParams[1]);
        } else {
            return super.create(modelClass);
        }*/
        return super.create(modelClass);
    }

}
