package com.back;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("== 명언 앱 ==");
        int lastId = 0;

        while (true) {
            System.out.print("명령) ");

            String str = scanner.nextLine().trim();

            if (str.equals("종료")) {
                break;
            }
            else if (str.equals("등록")) {
                System.out.print("명언 : ");
                String wiseSayingContent = scanner.nextLine().trim();
                System.out.print("작가 : ");
                String wiseSayingAuthor = scanner.nextLine().trim();
                int no = ++lastId;
                System.out.println("%d번 명언이 등록되었습니다.".formatted(no));
            }
        }
        scanner.close();
    }
}