package org.techtown.fragment2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

// Fragment 클래스를 상속받아 ListFragment 클래스를 정의
public class ListFragment extends Fragment {
    // 이미지 선택 시 콜백을 위한 ImageSelectionCallback 인터페이스 타입의 멤버 변수 선언
    ImageSelectionCallback callback;

    // Fragment가 Activity에 attach될 때 호출되는 메서드
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        // context가 ImageSelectionCallback의 인스턴스인지 확인
        if (context instanceof ImageSelectionCallback) {
            // context를 ImageSelectionCallback로 캐스팅하여 callback에 할당
            callback = (ImageSelectionCallback) context;
        }
    }

    // Fragment의 뷰를 생성하고 반환하는 메서드
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // fragment_list 레이아웃을 인플레이트하여 rootView로 사용
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_list, container, false);

        // rootView에서 첫 번째 버튼을 찾아 설정
        Button button = rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // callback이 null이 아니면 첫 번째 이미지 선택 콜백 호출
                if (callback != null) {
                    callback.onImageSelected(0);
                }
            }
        });

        // rootView에서 두 번째 버튼을 찾아 설정
        Button button2 = rootView.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // callback이 null이 아니면 두 번째 이미지 선택 콜백 호출
                if (callback != null) {
                    callback.onImageSelected(1);
                }
            }
        });

        // rootView에서 세 번째 버튼을 찾아 설정
        Button button3 = rootView.findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // callback이 null이 아니면 세 번째 이미지 선택 콜백 호출
                if (callback != null) {
                    callback.onImageSelected(2);
                }
            }
        });

        // rootView 반환
        return rootView;
    }
}


