package bridge.view;

import bridge.domain.BridgeGame;
import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String GAME_START = "다리 건너기 게임을 시작합니다.";
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String START = "[";
    private static final String END = "]";
    private static final String SEPARATOR = "|";
    private static final String CONTENTS = " %s ";
    private static final String BLANK = " ";
    private static final String RESULT = "최종 게임 결과";
    private static final String GAME_SUCCESS = "게임 성공 여부: 성공";
    private static final String GAME_FAILED = "게임 성공 여부: 실패";
    private static final String TOTAL_ATTEMPTS = "총 시도한 횟수: %d\n";

    public void printGameStart() {
        System.out.println(GAME_START);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame) {
        printUpperLineOfMap(bridgeGame.getUserMoved(), bridgeGame.getMatchingStatus());
        printLowerLineOfMap(bridgeGame.getUserMoved(), bridgeGame.getMatchingStatus());
    }

    private void printUpperLineOfMap(List<String> userMoved, List<String> matchingStatus) {
        String matchingMap = String.join(SEPARATOR, getMatchingMap(userMoved, matchingStatus, UP));
        System.out.println(START + matchingMap + END);
    }

    private void printLowerLineOfMap(List<String> userMoved, List<String> matchingStatus) {
        String matchingMap = String.join(SEPARATOR, getMatchingMap(userMoved, matchingStatus, DOWN));
        System.out.println(START + matchingMap + END);
    }

    private List<String> getMatchingMap(List<String> userMoved, List<String> matchingStatus, String direction) {
        List<String> matchingMap = new ArrayList<>();
        for (int i = 0; i < userMoved.size(); i++) {
            if (userMoved.get(i).equals(direction)) {
                matchingMap.add(String.format(CONTENTS, matchingStatus.get(i)));
                continue;
            }
            matchingMap.add(String.format(CONTENTS, BLANK));
        }
        return matchingMap;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println(RESULT);
        printMap(bridgeGame);
        printWhetherGameSuccess(bridgeGame.isGameFailed());
        printTotalAttempts(bridgeGame.getTotalAttempts());
    }

    private void printWhetherGameSuccess(boolean isGameFailed) {
        if (!isGameFailed) {
            System.out.println(GAME_SUCCESS);
            return;
        }
        System.out.println(GAME_FAILED);
    }

    private void printTotalAttempts(int totalAttempts) {
        System.out.printf(TOTAL_ATTEMPTS, totalAttempts);
    }
}
