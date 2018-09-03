package com.open.design.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.open.design.PersonBuilder;
import com.open.design.R;
import com.open.design.clone.Prototype;
import com.open.design.observer.Observable;
import com.open.design.observer.Observer;
import com.open.design.observer.Weather;

public class MainActivity extends AppCompatActivity {
    Observable<Weather> observable=new Observable<Weather>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PersonBuilder.Builder builder = new PersonBuilder.Builder();
        builder.age(1)
                .height(1.0)
                .name("11")
                .weight(22);

        Observer<Weather> observer1=new Observer<Weather>() {
            @Override
            public void onUpdate(Observable<Weather> observable, Weather data) {
                System.out.println("观察者1："+data.toString());
            }
        };
        Observer<Weather> observer2=new Observer<Weather>() {
            @Override
            public void onUpdate(Observable<Weather> observable, Weather data) {
                System.out.println("观察者2："+data.toString());
            }
        };

        observable.register(observer1);
        observable.register(observer2);


        Weather weather = new Weather.Builder().description("晴转多云").create();

        observable.notifyObservers(weather);

        Weather weather1= new Weather.Builder().description("多云转阴").create();
        observable.notifyObservers(weather1);
        observable.unregiter(observer1);

        Weather weather2= new Weather.Builder().description("台风").create();
        observable.notifyObservers(weather2);

        Prototype mPrototype = new Prototype();
        mPrototype.setType("1");
        mPrototype.setTypeName("12");

        Prototype newPrototype = (Prototype) mPrototype.clone();
        newPrototype.setType("2");

        Log.d("TAG",mPrototype.toString());
        Log.d("TAG",newPrototype.toString());

    }

    public void onClick(View v){
        Log.e("TAG","click");
    }
}
