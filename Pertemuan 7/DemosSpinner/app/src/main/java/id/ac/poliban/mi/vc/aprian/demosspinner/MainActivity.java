package id.ac.poliban.mi.vc.aprian.demosspinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.daftar_negara, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getAdapter().getItem(i).toString();
                Toast.makeText(MainActivity.this, "Anda Memilih " + item,
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this, "Item belum di klik",
                        Toast.LENGTH_SHORT).show();
            }
        });
        ConstraintLayout layout = findViewById(R.id.contraint_Layout);
        registerForContextMenu(layout);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mc_breakfast:
                displayToast("I'm in breakfasht");
                break;
            case R.id.mc_lunch:
                displayToast("I'm in lunch");
                break;
            case R.id.mc_dinner:
                c_:
                displayToast("I'm in dinner");
                break;
            case R.id.mc_meeting:
                displayToast("I'm in meeting");
                break;
            case R.id.mc_party:
                displayToast("I'm in party");
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void displayToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.context_edit:
                displayToast("edit action");
                break;
            case R.id.context_share:
                displayToast("share action");
                break;
            case R.id.context_delete:
                displayToast("delete action");
                break;
            default:
                return super.onContextItemSelected(item);
        }

        return false;
    }

    public void show_dialog(View view) {
            new AlertDialog.Builder(MainActivity.this)
        .setTitle("Black Coffe")
        .setIcon(R.drawable.ic_coffe)
                .setMessage("Anda Ingin Pesan ?")
                        .setNeutralButton("Bingung",(dialogInterface, i) ->
                                displayToast("Saya Bingung"))
                    .setNegativeButton("Ogah",(dialogInterface, i) ->
                            displayToast("Saya Ogah Pesen"))
                    .setPositiveButton("Pesan",(dialogInterface, i) ->
                            displayToast("Saya Pesan 2"))
                    .show();

    }
    }