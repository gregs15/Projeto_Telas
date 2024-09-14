package com.example.projeto_telas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    //declaração das interfaces que são utilizadas
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        //instanciados os itens de interface em si que serão utilizados, filtrando todos eles pelo id
        // apos isso,  ao clicar no btn_login ele vai ao metodo login e faz a leitura do mesmo.
        editTextEmail = this.findViewById(R.id.editTextEmail);
        editTextPassword = this.findViewById(R.id.editTextPassword);
        buttonLogin = this.findViewById(R.id.btn_login);


       // evento onde ocorre o comportamento do botão ser clicado
        buttonLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                login();
            }

        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    // criando metodo void que irá receber uma string em formato de texto do email e do password
    //apos receber isso ele faz o a mudança(com o uso do Intent) para a outra tela da conversao de moedas
    private void login(){
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        Intent intent  = new Intent(LoginActivity.this, CConvertActivity.class);
        startActivity(intent);

    }
}