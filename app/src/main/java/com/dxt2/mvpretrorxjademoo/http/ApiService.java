package com.dxt2.mvpretrorxjademoo.http;

import com.dxt2.mvpretrorxjademoo.bean.HotData;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2018/4/28 0028.
 */

public interface ApiService {
//    @GET("top250")
//    Observable<Movie> getTopMovie(@Query("start") int start, @Query("count") int count);
    @Headers({"User-Agent: Apache-HttpClient/UNAVAILABLE (java 1.4)"})
    @GET(value ="index.php?_p=api&_a=carousel")
    Observable<HotData> getHotListData();
}
