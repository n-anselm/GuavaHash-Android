package com.anselmdevelopment.guavahash_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;

import java.nio.charset.Charset;

public class MainActivity extends AppCompatActivity {

    EditText etInput;
    TextView tvConvert;
    TextView tvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput = findViewById(R.id.etInput);
        tvConvert = findViewById(R.id.tvConvert);
        tvOutput = findViewById(R.id.tvOutput);

        tvConvert.setOnClickListener(v -> {
            String pass = "activate";
            final HashCode hash = Hashing.sha256().hashString(pass, Charset.defaultCharset());
//            String hash = "200c7e6220036fd90a72b70cf30651c9a4733f1b9afbd878c7f2f692a3ceded1";
            // Print to console
            Log.d("hash", hash.toString());

            // Get input from EditText and convert to string
            String input = etInput.getText().toString();
            // Hash the string
            final HashCode hashCode = Hashing.sha256().hashString(input, Charset.defaultCharset());
//            tvOutput.setText(hashCode.toString());

            // If the hashes are the same, say "Validated", else, say "Not validated"
            if (hash.toString().equals(hashCode.toString())) {
                tvOutput.setText("Validated!");
            } else {
                tvOutput.setText("Not validated!");
            }
        });
    }
}