package learn.kelayn.labw2.UI.SplashScreen;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import learn.kelayn.labw2.Data.Technology;
import learn.kelayn.labw2.R;
import learn.kelayn.labw2.UI.MainActivity;

public class SplashScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        SplashScreenVM vM = ViewModelProviders.of(this).get(SplashScreenVM.class); // назначение вьюмодели для этой активности
        vM.getData();

        vM.mTechnologies.observe(this, technologies -> { // observe - позволяет наблюдать за изменениями в technologies,
            if (technologies != null) {
                ArrayList<Technology> no_null_technologies = new ArrayList<>();

                for (Technology t : technologies)
                    if (t.getName() != null)
                        no_null_technologies.add(t);

                Intent main = new Intent(this, MainActivity.class);
                main.putExtra("data", no_null_technologies);
                startActivity(main);
                finish();
            }
        });

    }
}
