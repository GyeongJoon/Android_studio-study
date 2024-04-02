package org.techtown.lifecycle;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import androidx.activity.EdgeToEdge; // AndroidX 라이브러리 사용
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

// MainActivity 클래스 시작
public class MainActivity extends AppCompatActivity {

    EditText editText; // EditText 변수 선언

    // 액티비티 생성시 호출되는 메서드
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this); // 시스템 UI 영역을 더 넓게 사용하도록 설정
        setContentView(R.layout.activity_main); // 화면에 XML 레이아웃 표시

        editText = findViewById(R.id.editText); // EditText를 XML 레이아웃에서 찾아 변수에 할당

        Log.d("Main", "onCreate 호출됨"); // Logcat에 메시지 출력
    }

    // 액티비티가 화면에 표시되기 전에 호출되는 메서드
    @Override
    protected void onStart() {
        super.onStart();

        Log.d("Main", "onStart 호출됨"); // Logcat에 메시지 출력
    }

    // 액티비티가 화면에서 사라지기 전에 호출되는 메서드
    @Override
    protected void onStop() {
        super.onStop();

        Log.d("Main", "onStop 호출됨"); // Logcat에 메시지 출력
    }

    // 액티비티가 소멸될 때 호출되는 메서드
    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("Main", "onDestroy 호출됨"); // Logcat에 메시지 출력
    }

    // 액티비티가 일시정지될 때 호출되는 메서드
    @Override
    protected void onPause() {
        super.onPause();

        saveState(); // 상태 저장 메서드 호출

        Log.d("Main", "onPause 호출됨"); // Logcat에 메시지 출력
    }

    // 액티비티가 다시 시작될 때 호출되는 메서드
    @Override
    protected void onResume() {
        super.onResume();

        loadState(); // 상태 로드 메서드 호출

        Log.d("Main", "onResume 호출됨"); // Logcat에 메시지 출력
    }

    // 상태를 저장하는 메서드
    public void saveState() {
        // SharedPreferences 객체를 가져옵니다. "pref"라는 이름의 SharedPreferences를 사용합니다.
        // MODE_PRIVATE는 해당 SharedPreferences가 애플리케이션 전용으로 사용되도록 지정합니다.
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);

        // SharedPreferences를 수정하기 위한 Editor 객체를 가져옵니다.
        SharedPreferences.Editor editor = pref.edit();

        // EditText에서 텍스트를 가져와서 "name"이라는 키에 해당하는 값으로 설정합니다.
        editor.putString("name", editText.getText().toString());

        // 변경사항을 저장합니다.
        editor.commit();

    }

    // 상태를 로드하는 메서드
    public void loadState() {
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if (pref != null) {
            String name = pref.getString("name", ""); // "name" 키에 해당하는 값 가져오기
            editText.setText(name); // EditText에 가져온 값 설정
        }
    }
}
