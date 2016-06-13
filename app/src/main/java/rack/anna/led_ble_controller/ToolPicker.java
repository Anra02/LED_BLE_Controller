package rack.anna.led_ble_controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ToolPicker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_picker);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView textView = new TextView(this);
        textView.setTextSize(35);
        textView.setText(message);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.content);
        layout.addView(textView);
    }


    public void loadColorPicker(View view) {
        Intent intent = new Intent(this, ColorPicker.class);
        startActivity(intent);
    }

    public void loadAnimationPicker(View view) {
        Intent intent = new Intent(this, AnimationPicker.class);
        startActivity(intent);
    }

    public void loadPlaylistController(View view){
        Intent intent = new Intent(this, PlaylistController.class);
        startActivity(intent);
    }

}
