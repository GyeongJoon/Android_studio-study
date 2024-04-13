package org.techtown.m7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this); // EdgeToEdge 라이브러리 활성화
        setContentView(R.layout.activity_main); // 화면을 activity_main 레이아웃으로 설정

        // 버튼 객체를 찾아옵니다.
        Button button = findViewById(R.id.button);
        // 버튼에 클릭 이벤트 리스너를 설정합니다.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // MenuActivity로 이동하는 Intent를 생성합니다.
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                // Intent를 통해 MenuActivity를 시작합니다.
                startActivity(intent);
            }
        });
    }
}