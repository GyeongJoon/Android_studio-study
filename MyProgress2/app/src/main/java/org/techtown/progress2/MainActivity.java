package org.techtown.progress2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    AlertDialog dialog; // AlertDialog로 변경

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProgressBar progressBar = findViewById(R.id.progressBar);
        progressBar.setIndeterminate(false);
        progressBar.setProgress(80);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // AlertDialog.Builder를 사용하여 AlertDialog 생성
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                // LayoutInflater를 사용하여 layout을 inflate
                LayoutInflater inflater = getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.progress_dialog, null); // progress_dialog.xml 필요
                builder.setView(dialogView); // AlertDialog에 추가
                builder.setMessage("데이터를 확인하는 중입니다."); // 메시지 설정

                dialog = builder.create(); // AlertDialog 생성
                dialog.show(); // AlertDialog 표시
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss(); // AlertDialog가 표시되고 있는지 확인 후 닫기
                }
            }
        });
    }
}


