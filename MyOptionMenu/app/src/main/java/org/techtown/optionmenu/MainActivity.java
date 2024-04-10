package org.techtown.optionmenu;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar; // 이 줄을 추가하세요.

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int curId = item.getItemId();

        if (curId == R.id.menu_refresh) {
            showToast("새로고침 메뉴 선택됨");
        } else if (curId == R.id.menu_search) {
            showToast("검색 메뉴 선택됨");
        } else if (curId == R.id.menu_settings) {
            showToast("설정 메뉴 선택됨");
        }

        return super.onOptionsItemSelected(item);
    }

    public void showToast(String data) {
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
    }
}
