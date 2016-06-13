package rack.anna.led_ble_controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.larswerkman.holocolorpicker.ColorPicker;
import com.larswerkman.holocolorpicker.SaturationBar;
import com.larswerkman.holocolorpicker.ValueBar;

public class ColorPickerActivity extends AppCompatActivity implements ColorPicker.OnColorChangedListener {


    // UI
    private ColorPicker mColorPicker;
    private SaturationBar mSaturationBar;
    private ValueBar mValueBar;
    private View mRgbColorView;
    private TextView mRgbTextView;

    private int mSelectedColor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // UI
        mRgbColorView = findViewById(R.id.rgbColorView);
        mRgbTextView = (TextView) findViewById(R.id.rgbTextView);

        mSaturationBar = (SaturationBar) findViewById(R.id.saturationbar);
        mValueBar = (ValueBar) findViewById(R.id.valuebar);
        mColorPicker = (ColorPicker) findViewById(R.id.colorPicker);
        mColorPicker.addSaturationBar(mSaturationBar);
        mColorPicker.addValueBar(mValueBar);
        mColorPicker.setOnColorChangedListener(this);

        String[] ringIDs = new String[] {"1","2","3","4","all"};

        Spinner ringSpinner = (Spinner) findViewById(R.id.ringIDSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, ringIDs);
        ringSpinner.setAdapter(adapter);

    }

    @Override
    public void onColorChanged(int color) {
        // Save selected color
        mSelectedColor = color;

        // Update UI
        mRgbColorView.setBackgroundColor(color);

        int r = (color >> 16) & 0xFF;
        int g = (color >> 8) & 0xFF;
        int b = (color >> 0) & 0xFF;
        String text = String.format(getString(R.string.colorpicker_rgbformat), r, g, b);
        mRgbTextView.setText(text);

    }

}
