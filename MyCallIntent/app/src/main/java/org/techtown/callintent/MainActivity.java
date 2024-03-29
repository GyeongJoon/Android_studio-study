package org.techtown.callintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // ActivityResultLauncher를 선언합니다.
    private ActivityResultLauncher<Intent> menuActivityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // MenuActivity를 시작하는 Intent를 생성합니다.
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                // ActivityResultLauncher를 사용하여 MenuActivity를 시작합니다.
                menuActivityResultLauncher.launch(intent);
            }
        });

        // registerForActivityResult 메소드를 사용하여 ActivityResultLauncher를 초기화합니다.
        // StartActivityForResultContract를 사용하여 ActivityResultLauncher를 설정합니다.
        menuActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                // 결과를 처리하기 위한 콜백 함수를 정의합니다.
                result -> {
                    // 결과 코드가 RESULT_OK인 경우에 대한 처리를 수행합니다.
                    if (result.getResultCode() == RESULT_OK) {
                        // 필요한 경우 결과를 처리합니다.
                    }
                });
    }
}
