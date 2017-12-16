package android.diegol.com.diegoteapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by fheiland on 12/15/17.
 */

public class EntityDetail extends AppCompatActivity implements View.OnClickListener{

    public final static int REQUEST_CODE = 1;
    private EditText nameText;
    private EditText lastNameText;
    private Button saveButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        bindViews();


    }

    private void bindViews() {
        nameText = findViewById(R.id.name_input);
        lastNameText = findViewById(R.id.lastname_input);
        saveButton = findViewById(R.id.save_data);

        saveButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String name = nameText.getText().toString();
        String lastName = lastNameText.getText().toString();

        if (!name.isEmpty() && !lastName.isEmpty()) {
            Intent intent = getIntent();
            intent.putExtra("entity", new Entity(name, lastName));
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
