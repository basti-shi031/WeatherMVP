package com.basti.weathermvp.model.impl;

import com.alibaba.fastjson.JSON;
import com.basti.weathermvp.model.Weather;
import com.basti.weathermvp.model.WeatherModel;
import com.basti.weathermvp.presenter.OnWeatherListener;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Bowen on 2016-06-13.
 */
public class WeatherModelImpl implements WeatherModel {

    private static final String WEATHERURL = "http://www.weather.com.cn/data/sk/101010100.html";

    @Override
    public void fetchWeatherInfo(String city, final OnWeatherListener listener) {
        AsyncHttpClient client = new AsyncHttpClient();

        client.get(WEATHERURL, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                if (responseBody != null) {

                    try {
                        String result = new String(responseBody, "UTF-8");
                        Weather weather = JSON.parseObject(result, Weather.class);

                        listener.onSuccess(weather);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }


                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                listener.onFailure("网络错误");
            }
        });
    }
}
