package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int REQUEST_CODE = 100;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMoveActivity = findViewById(R.id.btn_move_activity);
        Button btnMoveWithData = findViewById(R.id.btn_move_activity_data);
        Button btnDialNumber = findViewById(R.id.btn_dial_number);
        Button btnMoveResult = findViewById(R.id.btn_move_result);


        btnMoveActivity.setOnClickListener(this);
        btnMoveWithData.setOnClickListener(this);
        btnDialNumber.setOnClickListener(this);
        btnMoveResult.setOnClickListener(this);

        Button btnMoveWithObject = findViewById(R.id.btn_move_activity_object);
        btnMoveWithObject.setOnClickListener(this);

        tvResult = findViewById(R.id.tv_result);



    }

    //habis di klik masuk ke activity baru untuk ngapain
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_move_activity:
                Intent pindahActivity = new Intent(MainActivity.this, MoveActivity.class);
                startActivity(pindahActivity);
                break;
            case R.id.btn_move_activity_object:
                Person person = new Person();
                person.setName("DicodingAcademy");
                person.setAge(5);
                person.setEmail("academy@dicoding.com");
                person.setCity("Bandung");

                Intent moveWithObjectIntent = new Intent(MainActivity.this, MoveWithObjectActivity.class);
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person);
                startActivity(moveWithObjectIntent);
                break;

            case R.id.btn_move_activity_data:
                Intent moveWithDataIntent = new Intent(MainActivity.this, MoveWithDataActivity.class);
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Afada Arugia \n");
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 20);
                startActivity(moveWithDataIntent);
                break;

            case R.id.btn_dial_number:
                String phoneNumber = "082289462004";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+phoneNumber));
                startActivity(dialPhoneIntent);
                break;

            case R.id.btn_move_result:
                Intent moveResult = new Intent(MainActivity.this, MoveForResultActivity.class);
                startActivityForResult(moveResult, REQUEST_CODE);
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == MoveForResultActivity.RESULT_CODE){
            String value = data.getStringExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE);
/*            if (resultCode == MoveForResultActivity.RESULT_CODE){
                int selectedValue = data.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0);*/
                        tvResult.setText(String.format("Nama : " +value));
            }
        }
    }

