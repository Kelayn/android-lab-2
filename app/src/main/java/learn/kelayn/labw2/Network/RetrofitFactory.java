package learn.kelayn.labw2.Network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {
    public static Retrofit getRetrofit() {
        OkHttpClient client = new OkHttpClient.Builder().build();
        return new Retrofit.Builder() // Builder - объект, возвращающий сконфигурированный ретрофит
                .client(client) // установка стандартного хттп клиента
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // устанока обработчика запросов эрикс джава 2, чтобы не делать убогими методами, реализует паттер реактивного программирования в джаве
                .addConverterFactory(GsonConverterFactory.create()) // автоматический конвертер жесона от гугла
                .baseUrl("https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/")
                .build(); // создать объект с параметрами
    }
}
