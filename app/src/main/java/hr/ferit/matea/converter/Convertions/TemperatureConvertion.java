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

public class TemperatureConvertion extends AppCompatActivity {

    @BindView(R.id.sTemperature) Spinner sTemperature;
    @BindView(R.id.bTemperatureSubmit) Button bTemperatureSubmit;
    @BindView(R.id.etTemperature) EditText etTemperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_convertion);

        ButterKnife.bind(this);

        ArrayAdapter<CharSequence> sTemperatureAdapter = ArrayAdapter.createFromResource(this, R.array.temperature_units, android.R.layout.simple_spinner_item);
        sTemperatureAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sTemperature.setAdapter(sTemperatureAdapter);
    }

    @OnClick(R.id.bTemperatureSubmit)
    public void addListenerOnSubmit() {
        Intent actionToOpenResults = new Intent(this, Results.class);
        String spinnerValue = sTemperature.getSelectedItem().toString();

        double input = Double.parseDouble(etTemperature.getText().toString());

        double result;

        if (spinnerValue.equals("Celsius->Kelvin")) {
            result = input*274.15;
        }
        else {
            result = input/274.15;
        }

        actionToOpenResults.putExtra(Results.RESULT, result);
        startActivity(actionToOpenResults);
    }

}
