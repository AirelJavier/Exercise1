package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Deklarasi variabel untuk button
    Button btnLogin;

    //Deklarasi variabel untuk EditText
    EditText edemail, edpassword;

    //Deklarasi variabel untuk menyimpan email dan password
    String nama, password;

    //Deklarasi variabel register
    TextView regist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghubungkan variabel btnLogin dengan komponen button pada layout
        btnLogin = findViewById(R.id.btSignin);

        //Menghubungkan variabel edemail dengan komponen button pada layout
        edemail = findViewById(R.id.edMail);

        //Menghubungkan variabel edpassword dengan komponen button pada layout
        edpassword = findViewById(R.id.edPassword);

        regist = findViewById(R.id.Register);

        //Membuat fungsi onclick pada button btnLogin
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Menyimpan input user di edittext email kedalam variabel nama
                nama = edemail.getText().toString();

                //Menyimpan input user di edittext password kedalam variabel password
                password = edpassword.getText().toString();

                //Mengset email yang benar
                String email = "Airel";

                //Mengset password yang benar
                String pass = "password";

                //Mengecek apakah edittext email dan password terdapat isi atau tidak
                if (nama.isEmpty() || password.isEmpty()) {

                    //Membuat variabel toast dan menampilkan pesan "edittext tidak boleh kosong"
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Name and Password can not be empty!!!",
                            Toast.LENGTH_LONG);
                    edemail.setError("Email can not be empty");
                    edpassword.setError("Password can not be empty!");

                    //Menampilkan Toast
                    t.show();

                } else if (!nama.equals(email) && password.equals(pass)) {

                    Toast t = Toast.makeText(getApplicationContext(),
                            "Incorrect Email",
                            Toast.LENGTH_LONG);
                    t.show();

                } else if (nama.equals(email) && !password.equals(pass)) {

                    Toast t = Toast.makeText(getApplicationContext(),
                            "incorrect Password",
                            Toast.LENGTH_LONG);
                    t.show();

                } else if (!nama.equals(email) && !password.equals(pass)) {

                    Toast t = Toast.makeText(getApplicationContext(),
                            "Incorrect Email and Password",
                            Toast.LENGTH_LONG);
                    t.show();

                }else

                    //Mengecek apakah isi dari email dan password anda sudah sama dengan email dan
                    // password yang sudah di set

                    if (nama.equals(email) && password.equals(pass)) {
                        //membuat variabel toast dan menampilkan pesan "Login sukses"
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Succesfully",
                                Toast.LENGTH_LONG);

                        //Menampilkan toast
                        t.show();

                        Intent intent = new Intent(MainActivity.this, MenuAwal.class);
                        startActivity(intent);

                    } else {
                        //Membuat variabel toast dan membuat toast dan menampilkan pesan login gagal

                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Failed",
                                Toast.LENGTH_LONG);
                        //Menampilkan Toast
                        t.show();
                    }

            }
        });
        regist.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

    ;}