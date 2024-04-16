package org.techtown.tab;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 에지 투 에지 모드를 활성화합니다.
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // 툴바를 초기화하고 액션바로 설정합니다.
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // 액션바에서 타이틀을 숨깁니다.
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);

        // 각각의 프래그먼트를 초기화합니다.
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();

        // 첫 번째 프래그먼트를 컨테이너에 표시합니다.
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();

        // 탭을 설정하고 탭에 텍스트를 추가합니다.
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("통화기록"));
        tabs.addTab(tabs.newTab().setText("스팸기록"));
        tabs.addTab(tabs.newTab().setText("연락처"));

        // 탭 선택에 대한 리스너를 추가합니다.
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // 선택된 탭의 위치를 가져옵니다.
                int position = tab.getPosition();

                // 해당 위치에 따라 프래그먼트를 교체합니다.
                if (position == 0) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();
                } else if (position == 1) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment2).commit();
                } else if (position == 2) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment3).commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // 선택되지 않은 탭에 대한 동작은 여기서 구현합니다.
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // 탭이 다시 선택될 때의 동작은 여기서 구현합니다.
            }
        });
    }
}