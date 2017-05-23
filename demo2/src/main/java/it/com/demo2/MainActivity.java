package it.com.demo2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Activity implements UserView {
    UserPresenter userPresenter;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);

        UserService userService = new Retrofit.Builder()
                .baseUrl("http://192.168.2.110:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(UserService.class);
        userPresenter = new UserPresenterImpl(userService, this);
    }

    @Override
    public void onUserLoaded(User user) {
        textView.setText(user.toString());
    }
}