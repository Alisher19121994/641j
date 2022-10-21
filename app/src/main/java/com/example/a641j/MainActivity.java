package com.example.a641j;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button save_button;
    Button delete_button;

    boolean isPersistant = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    public void initViews() {
        editText = findViewById(R.id.et_btn);
        save_button = findViewById(R.id.save_file_btn);
        delete_button = findViewById(R.id.delete_file_btn);


        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString().trim();
                createFile(text);
            }
        });


        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString().trim();
                deleteThisFile(text);
            }
        });
    }


    public void createFile(String edit) {
        String fileName = edit + ".txt";
        File file;
        if (isPersistant) {
            file = new File(getFilesDir(), fileName);
        } else {
            file = new File(getCacheDir(), fileName);
        }

        if (!file.exists()) {
            try {
                file.createNewFile();

                Toast.makeText(this, "File created", Toast.LENGTH_LONG).show();

            } catch (IOException e) {
                Toast.makeText(this, "File not created", Toast.LENGTH_LONG).show();
            }
        }
    }


    public void deleteThisFile(String editText) {
        String fileName = editText + ".txt";

            File file1 = new File(getFilesDir(), fileName);
            if (file1.exists()) {
                file1.delete();
                Toast.makeText(this, "File deleted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "File not deleted", Toast.LENGTH_SHORT).show();
            }
    }
}