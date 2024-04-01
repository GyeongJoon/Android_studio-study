package org.techtown.parcelable;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

// 메뉴 액티비티 클래스 정의
public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // EdgeToEdge 라이브러리로 화면을 edge-to-edge로 만듦
        EdgeToEdge.enable(this);

        // 레이아웃 설정
        setContentView(R.layout.activity_menu);

        // 버튼 객체 생성 및 클릭 이벤트 설정
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // 액티비티 종료
            }
        });

        // 인텐트 받아오기
        Intent intent = getIntent();
        // 받아온 인텐트 처리
        processIntent(intent);
    }

    // 인텐트 처리 메서드
    public void processIntent(Intent intent) {
        if (intent != null) { // 인텐트가 null이 아닌 경우
            Bundle bundle = intent.getExtras(); // 인텐트로부터 번들 데이터 가져오기
            SimpleData data = bundle.getParcelable("data"); // 번들 데이터로부터 Parcelable 객체 가져오기
            if (data != null) { // Parcelable 객체가 null이 아닌 경우
                // 토스트 메시지로 객체 데이터 출력
                Toast.makeText(this, "전달받은 객체 : "  + data.code + ", " + data.message, Toast.LENGTH_LONG).show();
            }
        }
    }
}