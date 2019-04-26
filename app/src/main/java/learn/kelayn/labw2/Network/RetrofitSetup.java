package learn.kelayn.labw2.Network;

import java.util.ArrayList;

import io.reactivex.Single;
import learn.kelayn.labw2.Data.Technology;
import retrofit2.http.GET;

public interface RetrofitSetup {
    @GET("src/data/techs.ruleset.json")
    Single<ArrayList<Technology>> getTechnologies(); // получение сразу объекта, а не потока
}
