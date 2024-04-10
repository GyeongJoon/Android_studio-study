package org.techtown.fragment2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

// Fragment 클래스를 상속받아 ViewerFragment 클래스를 정의
public class ViewerFragment extends Fragment {
    // 이미지를 보여주기 위한 ImageView 멤버 변수 선언
    ImageView imageView;

    // Fragment의 뷰를 생성하고 반환하는 메서드
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) { // fragment_viewer 레이아웃을 인플레이트하여 rootView로 사용
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_viewer, container, false);
        imageView = rootView.findViewById(R.id.imageView); // rootView에서 ImageView를 찾아 멤버 변수에 할당
        return rootView; // rootView 반환
    }


    public void setImage(int resId) { // 외부에서 호출될 수 있는 setImage 메서드, 선택된 이미지 리소스를 ImageView에 설정
        imageView.setImageResource(resId); // imageView의 이미지 리소스를 설정
    }
}

