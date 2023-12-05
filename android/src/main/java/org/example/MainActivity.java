package org.example;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import example.Example;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView text = new TextView(this);

        text.setText(Example.info1());

        setContentView(text);
    }
}
