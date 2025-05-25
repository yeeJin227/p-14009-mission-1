package com.back;

import java.util.Scanner;
// java.util에 있는 scanner를 사용하기 위해 import 해야한다.
// - Scanner 잠깐 정리 -
// Scanner는 사용자한테 입력받을 수 있게 해주는 도구이다.
// < 주요 메서드 >
// nextLine() - 한 줄 통째로 입력 받음
// nextInt() - 정수 입력 받음
// nextDouble() - 실수 입력 받음

public class Main {
    public static void main(String[] args) {
        System.out.println("== 명언 앱 ==");
        Scanner scanner = new Scanner(System.in); //이 문장은 통으로 외워야한다.

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine().trim();
            // trim()은 문자열에서 앞,뒤 쓸데없는 공백을 잘라내는 메서드이다.
            // 즉, 사용자에게 문장을 입력 받고 앞 뒤로 쓸데없는 공백은 자동으로 지워서 cmd라는 String 변수에 대입한다.

            if (cmd.equals("종료")) {
                break;
            } //문자를 비교할 때 ==를 쓰면 '메모리 주소'를 비교하고, .equals()를 쓰면 '글자 자체'를 비교한다.
        }

        scanner.close(); //이 문장은 안써도 문제없이 동작은 하지만, 써 주는 게 좋다.
    }
}
