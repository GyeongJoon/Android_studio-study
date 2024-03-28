package org.techtown.inflater;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MenuActivity extends AppCompatActivity {
    LinearLayout container; // LinearLayout 객체를 선언합니다.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // 부모 클래스의 onCreate 메서드를 호출합니다.
        EdgeToEdge.enable(this); // 화면의 가장자리까지 뷰를 확장시키는 EdgeToEdge 라이브러리를 활성화합니다.
        setContentView(R.layout.activity_menu); // 레이아웃 파일을 화면에 표시합니다.

        container = findViewById(R.id.container); // XML 레이아웃에서 container라는 ID를 가진 뷰를 찾아서 변수에 할당합니다.

        Button button2 = findViewById(R.id.button2); // XML 레이아웃에서 button2라는 ID를 가진 버튼을 찾아서 변수에 할당합니다.
        button2.setOnClickListener(new View.OnClickListener() { // 버튼에 클릭 리스너를 등록합니다.
            @Override
            public void onClick(View v) { // 버튼이 클릭되었을 때 실행되는 메서드입니다.
                addLayout(); // addLayout 메서드를 호출하여 부분 화면을 추가합니다.
            }
        });
    }

    public void addLayout() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE); // LayoutInflater를 사용하여 XML 레이아웃을 뷰 객체로 인플레이트할 수 있는 객체를 가져옵니다.
        inflater.inflate(R.layout.sub1, container, true); // sub1 레이아웃을 container 레이아웃에 추가합니다.

        Toast.makeText(this, "부분 화면이 추가되었습니다", Toast.LENGTH_LONG).show(); // 사용자에게 메시지를 토스트 형태로 표시합니다.
    }
}
