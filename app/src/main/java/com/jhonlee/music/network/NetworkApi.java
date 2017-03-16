package com.jhonlee.music.network;

import android.util.Log;

import com.jhonlee.music.network.api.IMusicRequest;
import com.jhonlee.music.util.Const;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by JhoneLee on 2017/3/14.
 */

public class NetworkApi {

    private static NetworkApi networkApi = null;

    private Retrofit retorfit;

    private IMusicRequest imusic;

    public IMusicRequest getImusic() {
        return imusic;
    }

    private NetworkApi() {
        retorfit = getRetrofit(Const.URL);

        imusic = retorfit.create(IMusicRequest.class);
    }
    public synchronized static  NetworkApi getNetworkApi() {

        if (networkApi == null){
            networkApi = new NetworkApi();
        }
        return networkApi;
    }


    private Retrofit getRetrofit(String url){

        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl(url)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(getOkhttpCleient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;

    }

    private OkHttpClient getOkhttpCleient() {

        OkHttpClient okhttpCleient = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                    @Override
                    public void log(String message) {
                        Log.d("<<<<<<网络请求>>>>>",message);
                    }
                })).addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {

                        Request request = chain.request()
                                .newBuilder()
                                .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                                .addHeader("referer","http://music.163.com/")
                                .build();

                        return chain.proceed(request);
                    }
                }).build();
        return okhttpCleient;
    }
}
