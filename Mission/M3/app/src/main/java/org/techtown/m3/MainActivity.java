package org.techtown.m3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity { // MainActivity 클래스는 AppCompatActivity를 상속받아 선언됩니다.
    ImageView imageView01; // 이미지 뷰 객체를 참조하는 변수를 선언합니다.
    ImageView imageView02; // 이미지 뷰 객체를 참조하는 변수를 선언합니다.

    @SuppressLint("MissingInflatedId") // 누락된 View ID에 대한 경고를 억제하는 어노테이션을 사용합니다.
    @Override
    protected void onCreate(Bundle savedInstanceState) { // 액티비티가 생성될 때 호출되는 메소드입니다.
        super.onCreate(savedInstanceState); // 부모 클래스의 onCreate() 메소드를 호출합니다.
        setContentView(R.layout.activity_main); // 현재 액티비티의 레이아웃을 설정합니다.

        imageView01 = findViewById(R.id.imageView3); // 레이아웃에서 정의한 imageView3의 ID를 사용하여 imageView01을 초기화합니다.
        imageView02 = findViewById(R.id.imageView2); // 레이아웃에서 정의한 imageView2의 ID를 사용하여 imageView02을 초기화합니다.

        Button button01 = findViewById(R.id.button01); // 레이아웃에서 정의한 button01의 ID를 사용하여 button01을 초기화합니다.
        button01.setOnClickListener(new View.OnClickListener() { // 버튼에 클릭 리스너를 등록합니다.
            public void onClick(View v) { // 버튼이 클릭되었을 때 호출되는 메소드입니다.
                moveImageUp(); // 이미지를 위로 이동하는 메소드를 호출합니다.
            }
        });

        Button button02 = findViewById(R.id.button02); // 레이아웃에서 정의한 button02의 ID를 사용하여 button02을 초기화합니다.
        button02.setOnClickListener(new View.OnClickListener() { // 버튼에 클릭 리스너를 등록합니다.
            public void onClick(View v) { // 버튼이 클릭되었을 때 호출되는 메소드입니다.
                moveImageDown(); // 이미지를 아래로 이동하는 메소드를 호출합니다.
            }
        });

        moveImageUp(); // 액티비티가 생성될 때 이미지를 위로 이동시키는 메소드를 호출합니다.
    }

    private void moveImageDown() { // 이미지를 아래로 이동시키는 메소드입니다.
        imageView01.setImageResource(0); // imageView01에 할당된 이미지를 없앱니다.
        imageView02.setImageResource(R.drawable.turret); // imageView02에 새로운 이미지를 설정합니다.

        imageView01.invalidate(); // imageView01을 다시 그리도록 요청합니다.
        imageView02.invalidate(); // imageView02을 다시 그리도록 요청합니다.
    }

    private void moveImageUp() { // 이미지를 위로 이동시키는 메소드입니다.
        imageView01.setImageResource(R.drawable.body); // imageView01에 새로운 이미지를 설정합니다.
        imageView02.setImageResource(0); // imageView02에 할당된 이미지를 없앱니다.

        imageView01.invalidate(); // imageView01을 다시 그리도록 요청합니다.
        imageView02.invalidate(); // imageView02을 다시 그리도록 요청합니다.
    }
}