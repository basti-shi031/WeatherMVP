package com.basti.weathermvp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.basti.weathermvp.model.Weather;
import com.basti.weathermvp.model.impl.WeatherModelImpl;
import com.basti.weathermvp.presenter.impl.WeatherPresenterImpl;
import com.basti.weathermvp.view.WeatherView;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private Button getWeatherBt;

    private WeatherPresenterImpl weatherPresenter;
    private WeatherModelImpl weatherModel;
    private WeatherView weatherView;

    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initPresenter();

        initEvent();
    }

    private void initPresenter() {
        weatherModel = new WeatherModelImpl();
        weatherView = new WeatherView() {
            @Override
            public void showLoading() {
                progressDialog = ProgressDialog.show(MainActivity.this,"","正在加载");
            }

            @Override
            public void hideLoading() {
                if (progressDialog != null){
                    progressDialog.hide();
                }
            }

            @Override
            public void showError() {
                Toast.makeText(getApplicationContext(),"网络错误",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void setWeatherInfo(Weather weather) {

            }
        };

        weatherPresenter = new WeatherPresenterImpl(weatherView,weatherModel);

    }

    private void initEvent() {

        getWeatherBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weatherPresenter.getWeather("");
            }
        });

    }

    private void initView() {
        resultTextView = (TextView) findViewById(R.id.result_tv);
        getWeatherBt = (Button) findViewById(R.id.getweather);
    }
}
