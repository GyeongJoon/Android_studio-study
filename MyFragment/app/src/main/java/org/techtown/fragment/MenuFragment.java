package org.techtown.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;


public class MenuFragment extends Fragment { // MenuFragment 클래스 선언 및 Fragment를 상속받음

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // onCreateView 메소드 오버라이딩
        return inflater.inflate(R.layout.fragment_menu, container, false);
        // fragment_menu 레이아웃을 inflater를 사용하여 화면에 표시하고, container에 추가하지 않음
    }
}
