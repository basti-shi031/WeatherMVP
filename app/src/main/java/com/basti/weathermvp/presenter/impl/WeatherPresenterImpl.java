package com.basti.weathermvp.presenter.impl;

import com.basti.weathermvp.model.Weather;
import com.basti.weathermvp.model.WeatherModel;
import com.basti.weathermvp.presenter.OnWeatherListener;
import com.basti.weathermvp.presenter.WeatherPresenter;
import com.basti.weathermvp.view.WeatherView;


/**
 * Created by Bowen on 2016-06-13.
 */
public class WeatherPresenterImpl implements WeatherPresenter {
    private WeatherView weatherView;
    private WeatherModel weatherModel;

    public WeatherPresenterImpl(WeatherView weatherView,WeatherModel weatherModel){
        this.weatherView = weatherView;
        this.weatherModel = weatherModel;
    }

    @Override
    public void getWeather(String cityNo) {
        if (weatherView != null){
            weatherView.showLoading();
            weatherModel.fetchWeatherInfo(cityNo, new OnWeatherListener() {
                @Override
                public void onSuccess(Weather weather) {
                    weatherView.hideLoading();
                    weatherView.setWeatherInfo(weather);
                }

                @Override
                public void onFailure(String message) {
                    weatherView.hideLoading();
                    weatherView.showError();
                }
            });
        }
    }
}
