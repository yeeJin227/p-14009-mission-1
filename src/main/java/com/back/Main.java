package com.back;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("== 명언 앱 ==");
        Scanner scanner = new Scanner(System.in);
        int wiseSayingId = 0; // 등록되는 명언 번호를 저장할 변수.
        List<WiseSayingList> wiseSayingLists = new ArrayList<>();
        // List는 여러 개의 데이터를 순서대로 저장하는 인터페이스(약속서)이다.
        // List<WiseSayingList>는 이 리스트에 WiseSayingList 타입 객체들만 저장하겠다는 의미이다.
        // new ArrayList<>()는 List 인터페이스를 실제로 구현한 클래스이다. 즉, 실제 데이터를 저장하고 관리할 공간을 생성한 것이다.

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

                WiseSayingList wsl = new WiseSayingList();
                wsl.number = wiseSayingId;
                wsl.authorName = author;
                wsl.wiseSayingContent = wiseSaying;

                wiseSayingLists.add(wsl);
                // wiseSayingLists는 데이터를 저장하는 리스트를 가리키는 변수이다.
                // wiseSayingLists.add(wsl)는 wsl객체를 리스트에 추가한다는 의미이다.

                // - 정리 -
                // 명언을 보관하는 서랍장 : wiseSayingLsits
                // 새로 쓴 명언 : wsl
                // 새로 쓴 명언을 서랍장에 넣는 것 : .add(wsl)

            } else if (cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                for (int i = wiseSayingLists.size()-1; i >= 0; i--) { // wiseSayingLists.size()는 리스트에 담긴 명언 목록의 개수이다.
                    WiseSayingList getWsl = wiseSayingLists.get(i); // wiseSayingLists 리스트에 있는 i번째 인덱스를 가져옴.
                    System.out.printf("%d / %s / %s \n", getWsl.number, getWsl.authorName, getWsl.wiseSayingContent);
                }
                // - 배열(Array) -
                // int[] arr = new int[5];와 같이 한 번 만들면 크기를 바꿀 수 없다. .length로 크기 확인 가능.

                // - 리스트(List/ArrayList) -
                // ArrayList<String> list = new ArrayList<>();와 같이 생성 후 list.add("hi");와 같이 데이터를 추가할 수 있다.
                // 즉, 크기가 늘어나고 줄어들 수 있다. .size()로 크기 확인 가능.
            }
        }

        scanner.close();
    }
}
