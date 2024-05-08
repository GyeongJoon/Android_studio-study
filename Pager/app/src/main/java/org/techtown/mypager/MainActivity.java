package org.techtown.mypager;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import org.techtown.mypager.Fragment1;
import org.techtown.mypager.Fragment2;
import org.techtown.mypager.Fragment3;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPager; // ViewPager2 객체 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // activity_main.xml 레이아웃 설정

        Button button = findViewById(R.id.button); // 버튼 객체 참조
        viewPager = findViewById(R.id.viewPager); // ViewPager2 객체 참조
        viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL); // ViewPager2의 방향을 수평으로 설정

        MyPagerAdapter adapter = new MyPagerAdapter(this); // MyPagerAdapter 객체 생성 및 context 전달

        Fragment1 fragment1 = new Fragment1(); // Fragment1 객체 생성
        adapter.addItem(fragment1); // ViewPager2 Adapter에 Fragment1 추가

        Fragment2 fragment2 = new Fragment2(); // Fragment2 객체 생성
        adapter.addItem(fragment2); // ViewPager2 Adapter에 Fragment2 추가

        Fragment3 fragment3 = new Fragment3(); // Fragment3 객체 생성
        adapter.addItem(fragment3); // ViewPager2 Adapter에 Fragment3 추가

        viewPager.setAdapter(adapter); // ViewPager2에 Adapter 설정
    }

    static class MyPagerAdapter extends FragmentStateAdapter { // ViewPager2 Adapter 클래스 정의

        ArrayList<Fragment> items = new ArrayList<>(); // Fragment를 저장할 ArrayList 선언

        public MyPagerAdapter(FragmentActivity fragmentActivity) { // 생성자
            super(fragmentActivity); // 상위 클래스의 생성자 호출
        }

        public void addItem(Fragment item) { // Fragment를 ArrayList에 추가하는 메서드
            items.add(item); // ArrayList에 Fragment 추가
        }

        @Override
        public Fragment createFragment(int position) { // position에 해당하는 Fragment 반환하는 메서드
            return items.get(position); // ArrayList에서 해당 position의 Fragment 반환
        }

        @Override
        public int getItemCount() { // ViewPager2에 표시할 Fragment의 개수를 반환하는 메서드
            return items.size(); // ArrayList의 크기 반환
        }
    }
}
