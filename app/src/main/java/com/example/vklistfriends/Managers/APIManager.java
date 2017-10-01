package com.example.vklistfriends.Managers;

import com.example.vklistfriends.RequestInterface;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by админ on 01.10.2017.
 */

public class APIManager {

    private final String baseURL = "https://api.vk.com/";
    private static  APIManager instance;

    private final RequestInterface requestInterface;

    public static APIManager getInstance(){
        if(instance == null){
            instance = new APIManager();
        }
            return instance;
    }

    private APIManager(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Retrofit api = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        this.requestInterface = api.create(RequestInterface.class);

    }

    public RequestInterface getRequestInterface(){
        return requestInterface;
    }
}
