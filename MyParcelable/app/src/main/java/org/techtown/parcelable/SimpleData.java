package org.techtown.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

// Parcelable 인터페이스를 구현하는 클래스 정의
public class SimpleData implements Parcelable {
    int code; // 정수형 필드
    String message; // 문자열 필드

    // 생성자: 객체를 초기화하는 메서드
    public SimpleData(int code, String message) {
        this.code = code; // 코드 필드 초기화
        this.message = message; // 메시지 필드 초기화
    }

    // Parcel에서 데이터를 읽어와 객체를 생성하는 생성자
    public SimpleData(Parcel src) {
        code = src.readInt(); // Parcel에서 코드 데이터를 읽어와 할당
        message = src.readString(); // Parcel에서 문자열 데이터를 읽어와 할당
    }

    // Parcelable.Creator를 구현하는 static final 필드
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        // Parcel에서 데이터를 읽어와 SimpleData 객체 생성
        public SimpleData createFromParcel(Parcel in) {
            return new SimpleData(in);
        }

        // 배열의 크기를 지정하여 SimpleData 객체 배열 생성
        public SimpleData[] newArray(int size) {
            return new SimpleData[size];
        }
    };

    // Parcelable 인터페이스를 구현하는 메서드: 객체의 설명 반환
    @Override
    public int describeContents() {
        return 0; // Parcel의 추가 객체 내용 설명 없음을 반환
    }

    // Parcelable 인터페이스를 구현하는 메서드: 객체를 Parcel로 쓰기
    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(code); // 코드 데이터를 Parcel에 쓰기
        dest.writeString(message); // 메시지 데이터를 Parcel에 쓰기
    }
}
