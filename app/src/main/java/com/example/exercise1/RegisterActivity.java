package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class RegisterActivity extends AppCompatActivity {

    //Deklarasi variabel dengan tipe data EditText
    EditText edtNama, edtEmail, edtPassword, edtrepass;

    //deklarasi variabel dengan tipe data Floating action button
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtNama = findViewById(R.id.edName);
        edtEmail = findViewById(R.id.edEmail);
        edtPassword = findViewById(R.id.edPass);
        edtrepass = findViewById(R.id.edrepas);

        fab = findViewById(R.id.fabSimpan);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Membuat kondisi untuk mengecheck apakah EditText kosong atau tidak
                if (edtNama.getText().toString().isEmpty() ||
                            edtEmail.getText().toString().isEmpty() ||
                            edtPassword.getText().toString().isEmpty() ||
                            edtrepass.getText().toString().isEmpty())
                {
                    //Menampilkan pesan notifikasi jika seluruh EditText wajib diisi
                    Snackbar.make(view, "Please Complete the Data!", Snackbar.LENGTH_LONG).show();
                }
                else{
                    //Membuat kondisi untuk mengecheck apakah isi dari EditText password dan EditText repassword
                    //sama atau tidak
                    if (edtPassword.getText().toString().equals(edtrepass.getText().toString()))
                    {
                        //Menampilkan pesan notifikasi jika pendafataran berhasil
                        Toast.makeText(getApplicationContext(), "Register Successfully!",
                                Toast.LENGTH_LONG).show();

                        //Method untuk kembali ke activity Main
                        Intent i = new Intent(getApplicationContext(), MenuAwal.class);
                        startActivity(i);
                    }
                    else{
                        //jika password dan re-pass tidak sama
                        Snackbar.make(view, "Please Re-enter the correct password!",
                                Snackbar.LENGTH_LONG).show();
                    }
                }

            }
        });
    }
}