package learn.kelayn.labw2.UI.SplashScreen;

import android.annotation.SuppressLint;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import learn.kelayn.labw2.Data.Technology;
import learn.kelayn.labw2.Network.RetrofitFactory;
import learn.kelayn.labw2.Network.RetrofitSetup;

public class SplashScreenVM extends ViewModel {

    public MutableLiveData<ArrayList<Technology>> mTechnologies = new MutableLiveData<>();

    //getTechnologies - метод интерфейса жесон сервис, реализация посредством объекта ретрофит. добавила интерфейс в create - могу использовать запросы
    @SuppressLint("CheckResult")
    public void getData(){
        RetrofitFactory.getRetrofit().create(RetrofitSetup.class)
                .getTechnologies()
                .subscribeOn(Schedulers.io()) // подписываем Schedulers на происходящее при загрузке
                .observeOn(AndroidSchedulers.mainThread()) // устанавливаем объект, который будет наблюдать за происходящим - главный поток
                .subscribe(_mTechnologies -> {
                    this.mTechnologies.postValue(_mTechnologies); // отправка ответа от сервера в MutableLiveData
                }, error -> {
                    Log.e("Network", error.getMessage());
                });
    }
}
