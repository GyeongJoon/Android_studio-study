package org.techtown.progress;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity { // MainActivity 클래스 선언 및 AppCompatActivity를 상속받음
    ProgressBar progressBar; // ProgressBar 변수 선언

    int value = 0; // 정수형 변수 value를 0으로 초기화

    @Override
    protected void onCreate(Bundle savedInstanceState) { // onCreate 메서드 오버라이드
        super.onCreate(savedInstanceState); // 상위 클래스의 onCreate 메서드 호출
        EdgeToEdge.enable(this); // EdgeToEdge 라이브러리를 사용하여 화면을 가장자리까지 확장
        setContentView(R.layout.activity_main); // 화면에 activity_main.xml 레이아웃 표시

        progressBar = findViewById(R.id.progressBar); // XML에서 정의한 프로그래스바를 변수에 할당

        Button button = findViewById(R.id.button); // XML에서 정의한 버튼을 변수에 할당
        button.setOnClickListener(new View.OnClickListener() { // 버튼에 클릭 리스너 설정
            @Override
            public void onClick(View v) { // 클릭 이벤트 처리
                value += 10; // value에 10을 더함
                if (value > 100) { // value가 100을 초과하면
                    value = 0; // value를 0으로 초기화
                }

                progressBar.setProgress(value); // 프로그래스바에 현재 value 값 설정
            }
        });
    }
}
