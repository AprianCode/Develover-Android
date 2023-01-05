package id.ac.poliban.mi.vc.aprian.syifaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_open_control:
                startActivity(new Intent(this,InputControlActivity.class));
                break;
            case R.id.action_activity_open_listview:
                startActivity(new Intent(this,ListViewActivity.class));
                break;
            case R.id.action_activty_open_recylerview:
                startActivity(new Intent(this,RecyclerViewActivity.class));
                break;
            case R.id.action_quit:
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}