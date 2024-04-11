package org.techtown.m8;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity { // MainActivity 클래스를 선언하고 AppCompatActivity를 상속받음

    private ActivityResultLauncher<Intent> activityResultLauncher; // 결과를 처리하기 위한 ActivityResultLauncher 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) { // onCreate() 메서드 오버라이드
        super.onCreate(savedInstanceState); // 부모 클래스의 onCreate() 메서드 호출
        EdgeToEdge.enable(this); // 화면의 가장자리까지 UI를 확장하기 위한 EdgeToEdge 라이브러리 활성화
        setContentView(R.layout.activity_main); // activity_main.xml 레이아웃 파일을 액티비티의 화면으로 설정

        EditText editText = findViewById(R.id.editText); // EditText1을 XML에서 찾아와서 변수에 할당
        EditText editText2 = findViewById(R.id.editText2); // EditText2를 XML에서 찾아와서 변수에 할당

        activityResultLauncher = registerForActivityResult( // ActivityResultLauncher 초기화
                new ActivityResultContracts.StartActivityForResult(), // 새로운 액티비티를 시작하고 결과를 받는 컨트랙트 등록
                result -> { // 결과 처리를 위한 람다식 정의
                    if (result.getResultCode() == Activity.RESULT_OK) { // 결과 코드가 OK인지 확인하여 성공 여부 판단
                        Intent data = result.getData(); // 결과 Intent를 가져옴
                        String responseMessage = data.getStringExtra("responseKey"); // 결과 데이터에서 "responseKey"라는 키를 사용하여 결과 메시지를 가져옴
                        Toast.makeText(getApplicationContext(), responseMessage, Toast.LENGTH_LONG).show(); // 결과 메시지를 Toast로 표시
                    }
                });

        Button button = findViewById(R.id.button); // 버튼을 XML에서 찾아와서 변수에 할당
        button.setOnClickListener(v -> { // 버튼에 클릭 리스너 설정
            String input1 = editText.getText().toString(); // 첫 번째 EditText에서 텍스트를 가져와서 문자열로 변환
            String input2 = editText2.getText().toString(); // 두 번째 EditText에서 텍스트를 가져와서 문자열로 변환
            if (input1.isEmpty() || input2.isEmpty()) { // 입력이 비어 있는지 확인
                Toast.makeText(getApplicationContext(), "아이디나 비밀번호를 입력해주세요.", Toast.LENGTH_LONG).show(); // 사용자에게 메시지를 토스트로 표시
            } else {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class); // MenuActivity로 이동하기 위한 Intent 생성
                activityResultLauncher.launch(intent); // 액티비티를 시작하고 결과를 받기 위해 ActivityResultLauncher 사용
            }
        });
    }
}
