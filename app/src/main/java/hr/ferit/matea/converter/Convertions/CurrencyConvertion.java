package hr.ferit.matea.converter.Convertions;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hr.ferit.matea.converter.R;
import hr.ferit.matea.converter.Results;

public class CurrencyConvertion extends AppCompatActivity {

    @BindView(R.id.sCurrency) Spinner sCurrency;
    @BindView(R.id.bCurrencySubmit) Button bCurrencySubmit;
    @BindView(R.id.etCurrency) EditText etCurrency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_convertion);

        ButterKnife.bind(this);

        ArrayAdapter<CharSequence> sCurrencyAdapter = ArrayAdapter.createFromResource(this, R.array.currency_units, android.R.layout.simple_spinner_item);
        sCurrencyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sCurrency.setAdapter(sCurrencyAdapter);

    }

    @OnClick(R.id.bCurrencySubmit)
    public void addListenerOnSubmit() {
        Intent actionToOpenResults = new Intent(this, Results.class);
        String spinnerValue = sCurrency.getSelectedItem().toString();

        double input = Double.parseDouble(etCurrency.getText().toString());

        double result;

        if (spinnerValue.equals("HRK->EUR")) {
            result = input*7.43183187;
        }
        else {
            result = input/7.43183187;
        }

        actionToOpenResults.putExtra(Results.RESULT, result);
        startActivity(actionToOpenResults);
    }
}
