package com.back;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("== 명언 앱 ==");
        int lastId = 0;
        WiseSaying[] wiseSayings = new WiseSaying[100];
        int wiseSayingsLastIndex = -1;

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine().trim();

            if (cmd.equals("종료")) {
                break;

            } else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String wiseSayingContent = scanner.nextLine().trim();
                System.out.print("작가 : ");
                String wiseSayingAuthor = scanner.nextLine().trim();

                int id = ++lastId;

                WiseSaying wiseSaying = new WiseSaying(); // 객체 생성
                wiseSaying.id = id;
                wiseSaying.author = wiseSayingAuthor;
                wiseSaying.content = wiseSayingContent;
                wiseSayings[++wiseSayingsLastIndex] = wiseSaying;

                System.out.println("%d번 명언이 등록되었습니다.".formatted(id));

            } else if (cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");

                for (int i = wiseSayingsLastIndex; i >=0 ; i--) {
                    WiseSaying wiseSaying = wiseSayings[i];

                    System.out.printf("%d / %s / %s\n", wiseSaying.id, wiseSaying.author, wiseSaying.content);
                }
            }
        }
        scanner.close();
    }
}