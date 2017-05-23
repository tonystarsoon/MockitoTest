package it.com.retrofitdemo;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by tony on 2017/5/19.
 */

public interface TestService {
    @GET("{path}")
    Call<ResponseBody> getBook(@Path("path") String path);

    //HTTP的方式可以替换任何其他的方式
    @HTTP(method = "GET", path = "{path}", hasBody = false)
    Call<BannerBean> getInfo(@Path("path") String path);

    @GET("{path}")
    Observable<BannerBean> getInfo2(@Path("path") String path);
}
