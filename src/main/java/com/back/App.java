package com.back;

import com.back.WiseSaying;

import java.util.Scanner;

public class App {
    Scanner scanner = new Scanner(System.in);
    int lastId = 0;
    WiseSaying[] wiseSayings = new WiseSaying[100];
    int wiseSayingsLastIndex = -1;


    // 진입점 시작
    public void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine().trim();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                actionWrite();
            } else if (cmd.equals("목록")) {
                actionList();
            } else if (cmd.startsWith("삭제")) {
                actionDelete(cmd);
            }
        }
        scanner.close();
    }
    // 진입점 끝


    // 내부 로직 처리 후 '출력'을 담당하는 action- 메서드들
    // 등록 시 출력 담당
    void actionWrite(){
        System.out.print("명언 : ");
        String content = scanner.nextLine().trim();
        System.out.print("작가 : ");
        String author = scanner.nextLine().trim();

        WiseSaying wiseSaying2 = write(content,author);

        System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying2.id));
    }

    // 목록 시 출력 담당
    void actionList(){
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        WiseSaying[] forListWiseSayings = findForList();

        for (WiseSaying wiseSaying : forListWiseSayings) {
            System.out.printf("%d / %s / %s\n", wiseSaying.id, wiseSaying.author, wiseSaying.content);
        }
    }

    // 삭제 시 출력 담당
    void actionDelete(String cmd) {
        String[] cmdBits = cmd.split("=",2);

        if (cmdBits.length < 2 || cmdBits[1].isEmpty()) {
            System.out.println("id를 입력해주세요.");
            return;
        }

        int id = Integer.parseInt(cmdBits[1]);
        int deletedIndex = delete(id);

        if (deletedIndex == -1) {
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
            return;
        }

        System.out.println("%d번 명언이 삭제되었습니다.".formatted(id));
    }


    // 내부 로직 메서드들
    // 목록 로직
    int getSize(){
        return wiseSayingsLastIndex + 1;
    }

    WiseSaying[] findForList() {
        WiseSaying[] forListWiseSayings = new WiseSaying[getSize()]; // 실제 존재하는 명언 개수를 요소 개수로 해서 배열 생성

        int forListWiseSayingsIndex = -1;

        // 최근에 등록한 명언을 forListWiseSayings 배열의 0번째 인텍스부터 담기
        for (int i = wiseSayingsLastIndex; i >=0 ; i--) {
            forListWiseSayings[++forListWiseSayingsIndex] = wiseSayings[i];
        }

        return forListWiseSayings;
    }

    // 등록 로직
    WiseSaying write(String content, String author) {
        WiseSaying wiseSaying = new WiseSaying();
        wiseSaying.id = ++lastId;
        wiseSaying.author = author;
        wiseSaying.content = content;

        // 사용자가 입력한 명언,작가와 등록 번호를 wiseSayings배열에 담기
        wiseSayings[++wiseSayingsLastIndex] = wiseSaying;

        return wiseSaying;
    }

    // 삭제 로직
    int delete(int id) {
        int deleteIndex = -1;

        // 삭제하고자 하는 번호의 wiseSayings[] 명언을 찾는 과정
        for (int i = 0; i <= wiseSayingsLastIndex; i++) {
            if (wiseSayings[i].id == id) {
                deleteIndex = i;
                break;
            }
        }

        // 명언 없을 때
        if (deleteIndex == -1) return deleteIndex;

        // 명언 있으면 해당 인덱스 뒤부터 '인덱스 번호 하나씩 앞으로 땡기기'
        for (int i = deleteIndex + 1; i <= wiseSayingsLastIndex; i++) {
            wiseSayings[i - 1] = wiseSayings[i];
        }

        // 마지막 명언 인덱스에 null값 넣기
        wiseSayings[wiseSayingsLastIndex] = null;
        wiseSayingsLastIndex--;  // 명언 개수 1개 줄이기

        return deleteIndex;
    }
}
