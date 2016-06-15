package com.basti.weathermvp.view;

import com.basti.weathermvp.model.Weather;

/**
 * Created by Bowen on 2016-06-13.
 */
public interface WeatherView {

    void showLoading();
    void hideLoading();
    void showError();
    void setWeatherInfo(Weather weather);

}
