package com.example.projeto_telas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {

    //declaração das interfaces que são utilizadas, nome, email, senha, contra-senha, e botão de registro
    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextRepeatPassword;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        //instanciados os itens de interface em si que serão utilizados, filtrando todos eles pelo id
        // apos isso,  ao clicar no btn_register ele vai ao metodo register e faz a leitura do mesmo.
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextRepeatPassword = findViewById(R.id.editTextRepeatPassword);
        buttonRegister = findViewById(R.id.btn_register);


        //definindo o comportamento, após ser efetuado o click,
        // será efetuado a mudança de tela para o login.
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    //criando um método void, onde irá processar o nome, email, senha, contra-senha.
    //após isso, irá verificar se as senhas são iguais, caso foram iguais, irá efetuar a mudança de tela
    // efetuando a mudança de tela para o login
    // caso não aconteça isso, irá setar todos os campos em branco,
    // retornando uma mensagem  que as senhas não coincidem
    //com isso recriando a tela novamente
    private void register(){
        String name = editTextName.getText().toString();
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();
        String password2 = editTextRepeatPassword.getText().toString();

        if(password.equals(password2)){
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();


        }
        else{

            editTextName.setText("");
            editTextEmail.setText("");
            editTextPassword.setText("");
            editTextRepeatPassword.setText("");

            Toast.makeText(RegisterActivity.this, "As senhas não coincidem", Toast.LENGTH_SHORT).show();
            recreate();
        }
    }
}