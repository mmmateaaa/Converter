package hr.ferit.matea.converter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Results extends AppCompatActivity {

    public static final String RESULT = "";
    private static final double DEFAULT_SIZE = 1;

    @BindView(R.id.tvCurrencyResults) TextView tvCurrencyResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        ButterKnife.bind(this);

        Intent startingIntent = getIntent();
        handleStartingIntent(startingIntent);
    }

    private void handleStartingIntent(Intent startingIntent) {
        if (startingIntent != null) {
            if(startingIntent.hasExtra(RESULT)) {
                double result = startingIntent.getDoubleExtra(RESULT, DEFAULT_SIZE);
                tvCurrencyResults.setText(String.valueOf(result));

            }
        }
    }
}
