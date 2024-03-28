package org.techtown.intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        // 결과 데이터를 가져옵니다.
                        Intent data = result.getData();
                        if (data != null) {
                            // "name" 키를 사용하여 데이터를 추출합니다.
                            String name = data.getStringExtra("name");
                            if (name != null) {
                                // 추출된 데이터를 사용하여 Toast 메시지를 표시합니다.
                                Toast.makeText(this, "응답으로 받은 데이터: " + name, Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                });

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                // MenuActivity를 시작하고 결과를 처리하기 위해 launcher를 사용합니다.
                launcher.launch(intent);
            }
        });
    }
}
