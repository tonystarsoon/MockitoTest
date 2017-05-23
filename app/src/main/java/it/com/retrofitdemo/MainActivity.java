package it.com.retrofitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        network();
    }

    public void network() {
        TestService tService = NetManager.getTService();
        Call<BannerBean> call = tService.getInfo("bannerlist.json");
        call.enqueue(new Callback<BannerBean>() {
            @Override
            public void onResponse(Call<BannerBean> call, Response<BannerBean> response) {
                BannerBean bannerBean = response.body();
                Log.i("tag1", "----------------" + bannerBean.getMessage());
                Log.i("tag1", "----------------" + bannerBean.getState());
                Log.i("tag1", "----------------" + bannerBean.getBannerList().toString());
            }

            @Override
            public void onFailure(Call<BannerBean> call, Throwable t) {
                Log.i("tag1", "----------------failure");
            }
        });
    }

}





