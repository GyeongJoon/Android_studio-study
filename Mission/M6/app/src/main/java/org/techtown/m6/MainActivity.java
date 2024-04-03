package org.techtown.m6;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ProgressBar progressBar = findViewById(R.id.progressBar); // ID가 progressBar인 ProgressBar 객체를 찾아서 변수에 할당합니다.
        EditText editText = findViewById(R.id.editText); // ID가 editText인 EditText 객체를 찾아서 변수에 할당합니다.

        SeekBar seekBar = findViewById(R.id.seekBar); // ID가 seekBar인 SeekBar 객체를 찾아서 변수에 할당합니다.
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // SeekBar의 상태 변경을 감지하기 위한 리스너를 설정합니다.
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { // SeekBar의 진행 상태가 변경되었을 때 호출됩니다.
                progressBar.setProgress(progress); // ProgressBar의 진행 상태를 SeekBar의 현재 진행 상태로 설정합니다.
                editText.setText(String.valueOf(progress)); // EditText에 SeekBar의 현재 진행 상태 값을 텍스트로 설정합니다.
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { // SeekBar에 터치가 시작될 때 호출됩니다. (여기서는 구현하지 않음)

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { // SeekBar에 터치가 끝날 때 호출됩니다. (여기서는 구현하지 않음)

            }
        });

    }
}