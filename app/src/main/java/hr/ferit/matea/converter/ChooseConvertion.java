package hr.ferit.matea.converter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChooseConvertion extends AppCompatActivity {

    @BindView(R.id.bCurrency) ImageButton bCurrency;
    @BindView(R.id.bDistance) ImageButton bDistance;
    @BindView(R.id.bTemperature) ImageButton bTemperature;
    @BindView(R.id.bWeight) ImageButton bWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_convertion);

        ButterKnife.bind(this);

    }

    @OnClick({R.id.bWeight, R.id.bTemperature, R.id.bDistance, R.id.bCurrency})
    public void openConvertion(ImageButton imgBtn) {
        Intent actionToOpenConvertion = new Intent(ChooseConvertion.this, Convertion.class);
        startActivity(actionToOpenConvertion);
    }
}
