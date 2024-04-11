package org.techtown.m8;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> activityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);

        activityResultLauncher = registerForActivityResult( // ActivityResultLauncher 초기화
                new ActivityResultContracts.StartActivityForResult(), // 새로운 액티비티를 시작하고 결과를 받는 컨트랙트 등록
                result -> { // 결과 처리를 위한 람다식 정의
                    if (result.getResultCode() == Activity.RESULT_OK) { // 결과 코드가 OK인지 확인하여 성공 여부 판단
                        Intent data = result.getData(); // 결과 Intent를 가져옴
                        String responseMessage = data.getStringExtra("Menu화면"); // 결과 데이터에서 "responseKey"라는 키를 사용하여 결과 메시지를 가져옴
                        Toast.makeText(getApplicationContext(), responseMessage, Toast.LENGTH_LONG).show(); // 결과 메시지를 Toast로 표시
                    }
                });

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, Menu1Activity.class);
                activityResultLauncher.launch(intent);
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, Menu2Activity.class);
                activityResultLauncher.launch(intent);
            }
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, Menu3Activity.class);
                activityResultLauncher.launch(intent);
            }
        });

        // 뒤로 가기 버튼을 눌렀을 때의 동작을 정의하는 OnBackPressedCallback 객체를 생성하고 등록합니다.
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // 사용자가 뒤로 가기 버튼을 눌렀을 때 실행할 코드를 여기에 작성합니다.
                // 예를 들어, 결과를 설정하고 액티비티를 종료합니다.
                Intent returnIntent = new Intent();
                returnIntent.putExtra("responseKey", "Menu화면에서 반환됨");
                setResult(Activity.RESULT_OK, returnIntent);
                finish(); // 액티비티를 종료합니다.
            }
        });
    }
}
