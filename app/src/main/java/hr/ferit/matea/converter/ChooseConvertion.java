package hr.ferit.matea.converter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hr.ferit.matea.converter.Convertions.CurrencyConvertion;
import hr.ferit.matea.converter.Convertions.LengthConvertion;
import hr.ferit.matea.converter.Convertions.TemperatureConvertion;
import hr.ferit.matea.converter.Convertions.WeightConvertion;

public class ChooseConvertion extends AppCompatActivity {

    @BindView(R.id.bCurrency) ImageButton bCurrency;
    @BindView(R.id.bLength) ImageButton bLength;
    @BindView(R.id.bTemperature) ImageButton bTemperature;
    @BindView(R.id.bWeight) ImageButton bWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_convertion);

        ButterKnife.bind(this);

    }

    @OnClick({R.id.bWeight, R.id.bTemperature, R.id.bLength, R.id.bCurrency})
    public void openConvertion(ImageButton imgBtn) {
        switch (imgBtn.getId()) {
            case R.id.bCurrency:
                Intent actionToOpenCurrencyConvertion = new Intent(ChooseConvertion.this, CurrencyConvertion.class);
                startActivity(actionToOpenCurrencyConvertion);
                break;
            case R.id.bLength:
                Intent actionToOpenLengthConvertion = new Intent(ChooseConvertion.this, LengthConvertion.class);
                startActivity(actionToOpenLengthConvertion);
                break;
            case R.id.bWeight:
                Intent actionToOpenWeightConvertion = new Intent(ChooseConvertion.this, WeightConvertion.class);
                startActivity(actionToOpenWeightConvertion);
                break;
            case R.id.bTemperature:
                Intent actionToOpenTempConvertion = new Intent(ChooseConvertion.this, TemperatureConvertion.class);
                startActivity(actionToOpenTempConvertion);
                break;
        }

    }
}
