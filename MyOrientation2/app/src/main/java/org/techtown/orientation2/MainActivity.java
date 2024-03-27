package org.techtown.orientation2;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig); // 기본 구현을 호출하여 기능을 유지합니다.

        // 새 구성에서 화면 방향을 확인합니다.
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            showToast("가로 방향임"); // 가로 방향임을 알리는 토스트 메시지를 표시합니다.
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            showToast("세로 방향임"); // 세로 방향임을 알리는 토스트 메시지를 표시합니다.
        }
    }

    // 토스트 메시지를 표시하는 메서드입니다.
    public void showToast(String data) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show(); // 입력된 데이터를 짧은 시간동안 화면에 보여줍니다.
    }
}