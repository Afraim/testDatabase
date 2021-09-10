package com.example.testdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    String BigData="";
    int count=0;
    EditText name,email;
    Button sub;
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sub = findViewById(R.id.submitButton);
        name = findViewById(R.id.nameTxt);
        email = findViewById(R.id.emailTxt);
        String path = email.getText().toString();
    DatabaseReference myRef = database.getReference("info");

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(name.toString()).isEmpty() && !(email.toString()).isEmpty()){
                    count++;
                    TextView Data = findViewById(R.id.fromDatabase);
                    BigData = BigData + String.valueOf(count) + ") Name : "+ name.getText() + "\n" + "Email : "+ email.getText() + "\n";
                    String NAME = name.getText().toString(), EMAIL = email.getText().toString();;
                    myRef.setValue(NAME,EMAIL);
                    Data.setText(BigData);
                    name.setText("");
                    email.setText("");
                }
            }
        });
    }
}