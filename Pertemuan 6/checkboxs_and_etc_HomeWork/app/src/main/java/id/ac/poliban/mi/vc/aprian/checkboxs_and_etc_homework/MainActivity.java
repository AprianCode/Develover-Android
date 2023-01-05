package id.ac.poliban.mi.vc.aprian.checkboxs_and_etc_homework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 CheckBox ck1, ck2, ck3, ck4, ck5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ck1 = findViewById(R.id.ck_CS);
        ck2 = findViewById(R.id.ck_S);
        ck3 = findViewById(R.id.ck_CN);
        ck4 = findViewById(R.id.ck_C);
        ck5 = findViewById(R.id.ck_OCC);
        }

    public void showTOAS(View view) {
        StringBuilder result = new StringBuilder();
        result.append("Toppings :");
        if (ck1.isChecked()){
            result.append("\bChocolate Syrup");
        }if (ck2.isChecked()){
            result.append("\bSpringkles");
        }if (ck3.isChecked()){
            result.append("\bCrushed nuts");
        }if (ck4.isChecked()){
            result.append("\bCherries");
        }if (ck5.isChecked()){
            result.append("\bOrio Cookie Crumbles");
        }
        Toast.makeText(this,result.toString(),Toast.LENGTH_SHORT).show();
    }
}
