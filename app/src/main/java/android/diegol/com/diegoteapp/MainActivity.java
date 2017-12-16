package android.diegol.com.diegoteapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.diegol.com.diegoteapp.EntityDetail.REQUEST_CODE;

public class MainActivity extends AppCompatActivity {

    private RecyclerView dataSoruce;
    private EntityAdapter adapter;

    private List<Entity> entityList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bindViews();

        entityList = new ArrayList<>();
        adapter = new EntityAdapter(entityList);

        dataSoruce.setLayoutManager(new LinearLayoutManager(this));
        dataSoruce.setAdapter(adapter);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(MainActivity.this, EntityDetail.class);
               startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    private void bindViews() {
        dataSoruce = findViewById(R.id.lista);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_CODE: {
                if (resultCode == RESULT_OK) {
                    Entity createdEntity = (Entity) data.getSerializableExtra("entity");
                    entityList.add(0, createdEntity);
                    adapter.notifyItemInserted(0);

                }
                break;
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
