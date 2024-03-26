package org.techtown.m4;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {
    EditText inputMessage; // 입력된 메시지를 담을 EditText 객체
    TextView inputCount; // 입력된 바이트 수를 표시할 TextView 객체

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // XML 레이아웃에서 정의된 뷰들을 찾아서 초기화
        inputMessage = findViewById(R.id.inputMessage); // 입력 메시지 EditText 찾기
        inputCount = findViewById(R.id.inputCount); // 바이트 수를 표시할 TextView 찾기

        // 전송 버튼에 클릭 리스너 설정
        Button sendButton = findViewById(R.id.sendButton);
        sendButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // 입력된 메시지 가져오기
                String message = inputMessage.getText().toString();
                // 메시지를 토스트 메시지로 표시
                Toast.makeText(getApplicationContext(), "전송할 메시지\n\n" + message, Toast.LENGTH_LONG).show();
            }
        });

        // 닫기 버튼에 클릭 리스너 설정
        Button closeButton = findViewById(R.id.closeButton);
        closeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // 액티비티 종료
                finish();
            }
        });

        // EditText에 입력되는 텍스트 변화를 감지하는 TextWatcher 설정
        TextWatcher watcher = new TextWatcher() {
            public void onTextChanged(CharSequence str, int start, int before, int count) {
                // 입력된 텍스트의 바이트 수 계산
                byte[] bytes = null;
                try {
                    bytes = str.toString().getBytes("KSC5601");
                    int strCount = bytes.length;
                    // 바이트 수를 TextView에 표시
                    inputCount.setText(strCount + " / 80바이트");
                } catch(UnsupportedEncodingException ex) {
                    ex.printStackTrace();
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // 이전 텍스트 변경 이벤트
            }

            public void afterTextChanged(Editable strEditable) {
                // 입력된 텍스트의 바이트 수 체크 및 초과시 자동 삭제
                String str = strEditable.toString();
                try {
                    byte[] strBytes = str.getBytes("KSC5601");
                    if(strBytes.length > 80) {
                        // 바이트 수가 80을 초과하면 마지막 글자 자동 삭제
                        strEditable.delete(strEditable.length()-2, strEditable.length()-1);
                    }
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        };

        // EditText에 TextWatcher 설정
        inputMessage.addTextChangedListener(watcher);
    }

}
