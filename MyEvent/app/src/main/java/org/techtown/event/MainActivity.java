package org.techtown.event;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView textView; // TextView 객체 선언

    GestureDetector detector; // GestureDetector 객체 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) { // 액티비티가 생성될 때 호출되는 메소드
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this); // 화면의 가장자리까지 UI를 확장시키는 라이브러리를 사용하여 앱의 가장자리 확장을 활성화
        setContentView(R.layout.activity_main); // 액티비티의 레이아웃 설정

        textView = findViewById(R.id.textView); // XML 레이아웃에서 TextView 객체 참조

        View view = findViewById(R.id.view);
        view.setOnTouchListener(new View.OnTouchListener() { // View에 대한 터치 이벤트 처리를 위한 리스너 설정
            @Override
            public boolean onTouch(View v, MotionEvent event) { // 터치 이벤트 처리
                int action = event.getAction(); // 터치 이벤트의 액션 확인

                float curX = event.getX(); // 현재 X 좌표 가져오기
                float curY = event.getY(); // 현재 Y 좌표 가져오기

                if (action == MotionEvent.ACTION_DOWN) { // 터치 다운 액션 처리
                    println("손가락 눌림 : " + curX + ", "  + curY); // 텍스트뷰에 출력
                } else if (action == MotionEvent.ACTION_MOVE) { // 터치 이동 액션 처리
                    println("손가락 움직임 : " + curX + ", "  + curY); // 텍스트뷰에 출력
                } else if (action == MotionEvent.ACTION_UP) { // 터치 업 액션 처리
                    println("손가락 떨어짐 : " + curX + ", "  + curY); // 텍스트뷰에 출력
                }

                return true; // 이벤트 처리 여부 반환
            }
        });

        detector = new GestureDetector(this, new GestureDetector.OnGestureListener() { // GestureDetector 초기화
            @Override
            public boolean onDown(@NonNull MotionEvent e) { // 다운 제스처 처리
                println("onDown 호출됨"); // 텍스트뷰에 출력

                return true; // 제스처 처리 여부 반환
            }

            @Override
            public void onShowPress(@NonNull MotionEvent e) { // 특정 제스처의 press 상태를 표시

            }

            @Override
            public boolean onSingleTapUp(@NonNull MotionEvent e) { // 단일 탭 제스처 처리
                return false;
            }

            @Override
            public boolean onScroll(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float distanceX, float distanceY) { // 스크롤 제스처 처리
                return false;
            }

            @Override
            public void onLongPress(@NonNull MotionEvent e) { // 롱 프레스 제스처 처리
                println("onLongPress 호출됨"); // 텍스트뷰에 출력
            }

            @Override
            public boolean onFling(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) { // 플링 제스처 처리
                println("onFling 호출됨 : " + velocityX + ", " + velocityY); // 텍스트뷰에 출력

                return true; // 제스처 처리 여부 반환
            }
        });

        View view2 = findViewById(R.id.view2); // XML 레이아웃에서 View 객체 참조
        view2.setOnTouchListener(new View.OnTouchListener() { // View2에 대한 터치 이벤트 처리를 위한 리스너 설정
            @Override
            public boolean onTouch(View v, MotionEvent event) { // 터치 이벤트 처리
                detector.onTouchEvent(event); // GestureDetector에 터치 이벤트 전달하여 제스처 감지 및 처리
                return true; // 이벤트 처리 여부 반환
            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) { // 키가 눌렸을 때 호출되는 메소드
        if (keyCode == KeyEvent.KEYCODE_BACK) { // 눌린 키가 백 버튼인지 확인
            println("시스템 [BACK] 버튼이 눌렸어요."); // 텍스트뷰에 메시지 출력

            return true; // 이벤트 처리 완료를 반환
        }

        return false; // 이벤트 처리를 계속 전파
    }

    public void println(String data) { // 텍스트를 텍스트뷰에 출력하는 메소드
        textView.append(data + "\n"); // 텍스트뷰에 문자열과 줄바꿈 추가
    }

