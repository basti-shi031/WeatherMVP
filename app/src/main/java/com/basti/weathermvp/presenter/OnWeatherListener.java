package com.basti.weathermvp.presenter;

import com.basti.weathermvp.model.Weather;

/**
 * Created by Bowen on 2016-06-13.
 */
public interface OnWeatherListener {

    void onSuccess(Weather weather);

    void onFailure(String message);
}
