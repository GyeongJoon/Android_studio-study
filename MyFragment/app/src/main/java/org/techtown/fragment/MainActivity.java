package org.techtown.fragment;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity { // MainActivity 클래스 선언 및 AppCompatActivity를 상속받음
    MainFragment mainFragment; // MainFragment 타입의 변수 선언
    MenuFragment menuFragment; // MenuFragment 타입의 변수 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) { // onCreate 메소드 오버라이딩
        super.onCreate(savedInstanceState); // 부모 클래스의 onCreate 메소드 호출
        EdgeToEdge.enable(this); // EdgeToEdge 라이브러리를 사용하여 에지 투 에지 기능을 활성화
        setContentView(R.layout.activity_main); // 화면에 activity_main 레이아웃을 설정

        mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.mainFragment); // mainFragment 변수에 mainFragment 객체 할당
        menuFragment = new MenuFragment(); // menuFragment 변수에 MenuFragment 객체 생성 및 할당
    }

    public void onFragmentChanged (int index) { // onFragmentChanged 메소드 정의
        if (index == 0) { // index가 0일 때
            getSupportFragmentManager().beginTransaction().replace(R.id.container, mainFragment).commit(); // container에 mainFragment를 대체하여 화면에 표시
        } else if (index == 1) { // index가 1일 때
            getSupportFragmentManager().beginTransaction().replace(R.id.container, menuFragment).commit(); // container에 menuFragment를 대체하여 화면에 표시
        }
    }
}