package com.example.projeto_telas;

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

public class CConvertActivity extends AppCompatActivity {

    //declaração das interfaces que são utilizadas, valor real, valor da cotação do dolar,
    //resultado, botão de converter e botão de resetar

    private EditText editTextValueReal;
    private EditText editTextValueDolar;
    private EditText editTextResult;
    private Button buttonConvert;
    private Button buttonClean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cconvert);

        //instanciados os itens de interface em si que serão utilizados, filtrando todos eles pelo id
        // apos isso, terá dois botões para serem clicados, o primeiro botão que irá limpar,
        // e o segundo botão é o da conversão.
        editTextValueReal = this.findViewById(R.id.editTextValueReal);
        editTextValueDolar = this.findViewById(R.id.editTextValueDolar);
        editTextResult = this.findViewById(R.id.editTextResult);
        buttonClean = this.findViewById(R.id.btn_clean);
        buttonConvert = this.findViewById(R.id.btn_convert);

        //primeiro botão, onde ao ser clicado irá para o metódo "clear"
        buttonClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
            }
        });

        //segundo botão , onde ao ser clicado irá para o método "convert"
        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convert();
            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    // principal função desse método é resetar todos os campos,
    private void clear(){
        editTextValueReal.setText("");
        editTextValueDolar.setText("");
        editTextResult.setText("");
    }

    // método convert, recebe um bloco try-catch, onde primeiro irá efetuar uma tentativa no bloco, caso
    //esteja errado irá dar um erro,
    //os valores digitados recebem uma string,
    // após isso efetua-se uma verficação  se eles estão vazios, caso estiverem o usuario recebe uma mensagem para preencher os campos
    // em seguida,  os valores são modificados para a variavel double
    // seguindo, verifica-se se o valor do dolar é diferente do 0, ai entra dentro do bloco e faz a multiplicação
    // efetuando a multiplicação e ai o resultado em duas casas decimais.
    //caso o valor foi 0, entramos no else onde o usuario recebe a mensagem que o valor não pode ser 0
    // por fim, caso tudo o que for escrito acima não der certo, ai entramos no catch, transmitindo uma mensagem de erro
    private void convert(){
        try {
            String valueRealString = editTextValueReal.getText().toString();
            String valueDolarString = editTextValueDolar.getText().toString();


            if (valueRealString.isEmpty() || valueDolarString.isEmpty()) {
                Toast.makeText(CConvertActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                return;
            }

            double valueReal = Double.parseDouble(valueRealString);
            double valueDolar = Double.parseDouble(valueDolarString);


            if (valueDolar != 0) {
                double result = valueReal * valueDolar;
                editTextResult.setText(String.format("%.2f", result));
            } else {
                Toast.makeText(CConvertActivity.this, "Cotação deve ser maior que zero", Toast.LENGTH_SHORT).show();
            }
        } catch (NumberFormatException e) {
            Toast.makeText(CConvertActivity.this, "Formato de número inválido", Toast.LENGTH_SHORT).show();
        }
    }

}