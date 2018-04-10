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

public class LengthConvertion extends AppCompatActivity {

    @BindView(R.id.sLength) Spinner sLength;
    @BindView(R.id.bLengthSubmit) Button bLengthSubmit;
    @BindView(R.id.etLength) EditText etLength;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length_convertion);

        ButterKnife.bind(this);

        ArrayAdapter<CharSequence> sLengthAdapter = ArrayAdapter.createFromResource(this, R.array.length_units, android.R.layout.simple_spinner_item);
        sLengthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sLength.setAdapter(sLengthAdapter);
    }

    @OnClick(R.id.bLengthSubmit)
    public void addListenerOnSubmit() {
        Intent actionToOpenResults = new Intent(this, Results.class);
        String spinnerValue = sLength.getSelectedItem().toString();

        double input = Double.parseDouble(etLength.getText().toString());

        double result;

        if (spinnerValue.equals("Inch->Centimeter")) {
            result = input*2.54;
        }
        else {
            result = input/2.54;
        }

        actionToOpenResults.putExtra(Results.RESULT, result);
        startActivity(actionToOpenResults);
    }

}
