package com.example.thamirysrsantos.todo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;

import com.example.thamirysrsantos.todo.Banco.ControlaBanco;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void listar(View view) {
    Intent intent = new Intent(this, ListaActivity.class);
    startActivity(intent);
    }

    public void cadrastro(View view) {
        Intent intent = new Intent(this, CadastrarActivity.class);
        startActivity(intent);
    }
}
