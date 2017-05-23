package it.com.demo2;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class UserPresenterImpl implements UserPresenter {
    private UserService mUserService;
    private UserView mUserView;

    public UserPresenterImpl(UserService userService, UserView userView) {
        mUserView = userView;
        mUserService = userService;
    }

    @Override
    public void loadUser(int uid) {
        // 异步网络请求User数据，并在onNext(user)返回
        mUserService.loadUser(uid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<User>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(User user) {
                        mUserView.onUserLoaded(user);
                    }
                });
    }
}