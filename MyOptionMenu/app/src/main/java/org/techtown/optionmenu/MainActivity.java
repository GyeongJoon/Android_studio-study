package org.techtown.optionmenu;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar; // 이 줄을 추가하세요.

public class MainActivity extends AppCompatActivity { // MainActivity 클래스 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) { // onCreate 메소드 오버라이드
        super.onCreate(savedInstanceState); // 부모 클래스의 onCreate 메소드 호출
        setContentView(R.layout.activity_main); // activity_main 레이아웃 설정

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Toolbar toolbar = findViewById(R.id.toolbar); // Toolbar 객체 생성 및 초기화
        setSupportActionBar(toolbar); // 툴바를 액션바로 설정
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { // onCreateOptionsMenu 메소드 오버라이드
        getMenuInflater().inflate(R.menu.menu_main, menu); // menu_main 메뉴 리소스를 inflate하여 메뉴에 추가
        return true; // true 반환
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) { // onOptionsItemSelected 메소드 오버라이드
        int curId = item.getItemId(); // 선택된 메뉴 아이템의 ID 가져오기

        if (curId == R.id.menu_refresh) { // 선택된 메뉴 아이템이 menu_refresh인 경우
            showToast("새로고침 메뉴 선택됨"); // "새로고침 메뉴 선택됨" 토스트 메시지 출력
        } else if (curId == R.id.menu_search) { // 선택된 메뉴 아이템이 menu_search인 경우
            showToast("검색 메뉴 선택됨"); // "검색 메뉴 선택됨" 토스트 메시지 출력
        } else if (curId == R.id.menu_settings) { // 선택된 메뉴 아이템이 menu_settings인 경우
            showToast("설정 메뉴 선택됨"); // "설정 메뉴 선택됨" 토스트 메시지 출력
        }

        return super.onOptionsItemSelected(item); // 부모 클래스의 onOptionsItemSelected 메소드 호출
    }

    public void showToast(String data) { // showToast 메소드 정의
        Toast.makeText(this, data, Toast.LENGTH_LONG).show(); // 입력한 문자열을 Toast로 출력
    }
}
