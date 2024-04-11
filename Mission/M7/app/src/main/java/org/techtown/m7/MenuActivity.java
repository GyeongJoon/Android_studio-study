package org.techtown.m7;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity { // MenuActivity 클래스를 선언하고 AppCompatActivity를 상속받음

    @Override
    protected void onCreate(Bundle savedInstanceState) { // onCreate() 메서드 오버라이드
        super.onCreate(savedInstanceState); // 부모 클래스의 onCreate() 메서드 호출
        EdgeToEdge.enable(this); // 화면의 가장자리까지 UI를 확장하기 위한 EdgeToEdge 라이브러리 활성화
        setContentView(R.layout.activity_menu); // activity_menu.xml 레이아웃 파일을 액티비티의 화면으로 설정

        Button button2 = findViewById(R.id.button2); // 버튼2를 XML에서 찾아와서 변수에 할당
        button2.setOnClickListener(new View.OnClickListener() { // 버튼2에 클릭 리스너 설정
            @Override
            public void onClick(View v) { // 클릭 이벤트 처리
                Intent intent = new Intent(MenuActivity.this, MainActivity.class); // MainActivity로 이동하기 위한 Intent 생성
                startActivity(intent); // MainActivity 시작

                Toast toastView = Toast.makeText(getApplicationContext(), "로그인 화면입니다.", Toast.LENGTH_LONG); // 토스트 메시지 생성
                toastView.show(); // 토스트 메시지 표시
            }
        });
    }
}

