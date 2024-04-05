package org.techtown.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MainFragment extends Fragment { // MainFragment 클래스 선언 및 Fragment를 상속받음

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable Bundle savedInstanceState) {
        // onCreateView 메소드 오버라이딩
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);
        // fragment_main 레이아웃을 inflater를 사용하여 rootView에 추가

        Button button = rootView.findViewById(R.id.button); // rootView에서 button 요소를 찾음
        button.setOnClickListener(new View.OnClickListener() { // 버튼에 클릭 리스너 추가
            @Override
            public void onClick(View v) { // 클릭 이벤트 발생 시
                MainActivity activity = (MainActivity) getActivity(); // 현재 Fragment가 속한 Activity를 가져옴
                activity.onFragmentChanged(1); // MainActivity의 onFragmentChanged 메소드를 호출하여 인덱스를 전달하여 Fragment 변경 요청
            }
        });
        return rootView; // rootView 반환
    }
}
