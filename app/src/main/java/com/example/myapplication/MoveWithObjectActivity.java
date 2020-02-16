package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MoveWithObjectActivity extends AppCompatActivity {
    public static final String EXTRA_PERSON = "extra_person";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);

        TextView tvObject = findViewById(R.id.tv_object_received);

        Person person = getIntent().getParcelableExtra(EXTRA_PERSON);
        String text = "Name: " + person.getName()+ ", \n Email : " + person.getEmail() + ", \n Age : " + person.getAge() + " , \n City : " + person.getCity();
        tvObject.setText(text);
    }
}
