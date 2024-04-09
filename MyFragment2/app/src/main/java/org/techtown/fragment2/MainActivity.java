package org.techtown.fragment2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

// MainActivity 클래스 정의, AppCompatActivity를 상속받고 ImageSelectionCallback 인터페이스를 구현
public class MainActivity extends AppCompatActivity implements ImageSelectionCallback{
    // ListFragment와 ViewerFragment 객체 변수 선언
    ListFragment listFragment;
    ViewerFragment viewerFragment;

    // 이미지 리소스를 저장하는 정수 배열 선언
    int[] images = {R.drawable.dream01, R.drawable.dream02, R.drawable.dream03};

    // 액티비티가 생성될 때 호출되는 메서드
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // FragmentManager를 사용하여 fragment 참조 얻기
        FragmentManager manager = getSupportFragmentManager();
        // id를 통해 ListFragment 찾기
        listFragment = (ListFragment) manager.findFragmentById(R.id.listFragment);
        // id를 통해 ViewerFragment 찾기
        viewerFragment = (ViewerFragment) manager.findFragmentById(R.id.viewerFragment);
    }

    // ImageSelectionCallback 인터페이스의 메서드 구현
    // 이미지가 선택되었을 때 호출되며, 선택된 이미지를 viewerFragment를 통해 보여줌
    @Override
    public void onImageSelected(int position) {
        // viewerFragment의 setImage 메서드를 호출하여 선택된 이미지를 설정
        viewerFragment.setImage(images[position]);
    }

}