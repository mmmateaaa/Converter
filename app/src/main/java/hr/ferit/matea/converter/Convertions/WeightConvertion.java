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

public class WeightConvertion extends AppCompatActivity {

    @BindView(R.id.sWeigth) Spinner sWeigth;
    @BindView(R.id.bWeigthSubmit) Button bWeigthSubmit;
    @BindView(R.id.etWeigth) EditText etWeigth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_convertion);

        ButterKnife.bind(this);

        ArrayAdapter<CharSequence> sWeigthAdapter = ArrayAdapter.createFromResource(this, R.array.weight_units, android.R.layout.simple_spinner_item);
        sWeigthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sWeigth.setAdapter(sWeigthAdapter);
    }

    @OnClick(R.id.bWeigthSubmit)
    public void addListenerOnSubmit() {
        Intent actionToOpenResults = new Intent(this, Results.class);
        String spinnerValue = sWeigth.getSelectedItem().toString();

        double input = Double.parseDouble(etWeigth.getText().toString());

        double result;

        if (spinnerValue.equals("Kilogram->Pound")) {
            result = input*2.20462262;
        }
        else {
            result = input/2.20462262;
        }

        actionToOpenResults.putExtra(Results.RESULT, result);
        startActivity(actionToOpenResults);
    }

}
