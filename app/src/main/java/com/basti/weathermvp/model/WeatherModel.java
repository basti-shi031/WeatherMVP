package com.basti.weathermvp.model;

import com.basti.weathermvp.presenter.OnWeatherListener;

/**
 * Created by Bowen on 2016-06-13.
 */
public interface WeatherModel {

    void fetchWeatherInfo(String city, OnWeatherListener listener);
}
