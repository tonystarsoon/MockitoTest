package it.com.demo2;


import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface UserService {
    @GET("ygw/{uid}/user.json")
    Observable<User> loadUser(@Path("uid") int uid);
}