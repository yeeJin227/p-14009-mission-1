package com.back;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("== 명언 앱 ==");
        Scanner scanner = new Scanner(System.in);
        int wiseSayingId = 0; // 등록되는 명언 번호를 저장할 변수.

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine().trim();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String wiseSaying = scanner.nextLine().trim();
                System.out.print("작가 : ");
                String author = scanner.nextLine().trim();

                wiseSayingId++; // 등록될 때마다 변수값 1씩 증가.
                System.out.println(wiseSayingId + "번 명령이 등록되었습니다.");
            }
        }

        scanner.close();
    }
}
