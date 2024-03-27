package org.techtown.toast;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // 버튼을 레이아웃에서 찾습니다.
        Button button = findViewById(R.id.button);

        // 버튼에 클릭 리스너를 설정합니다.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 토스트 메시지를 생성합니다. 내용은 "토스트 메시지입니다.", 지속 시간은 Toast.LENGTH_LONG 입니다.
                Toast toastView = Toast.makeText(getApplicationContext(), "토스트 메시지입니다.", Toast.LENGTH_LONG);

                // 토스트 메시지의 위치를 지정합니다. (화면 상단 왼쪽, x좌표 200, y좌표 800)
                toastView.setGravity(Gravity.TOP|Gravity.LEFT, 200, 800);

                // 토스트 메시지를 화면에 표시합니다.
                toastView.show();
            }
        });
    }
}