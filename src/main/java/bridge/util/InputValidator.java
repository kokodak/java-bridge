package bridge.util;

public class InputValidator {

    private static final String NOT_NUMBER = "[ERROR] 숫자가 아닙니다.";
    private static final String BRIDGE_SIZE_ERROR = "[ERROR] 다리의 길이는 3 이상 20 이하의 수여야 합니다.";
    private static final String MOVING_ERROR = "[ERROR] 이동할 수 있는 칸은 U 혹은 D 중 하나여야 합니다.";

    public static int validateBridgeSize(String input) throws IllegalArgumentException {
        try {
            int bridgeSize = Integer.parseInt(input);
            if (bridgeSize < 3 || bridgeSize > 20) {
                throw new IllegalArgumentException(BRIDGE_SIZE_ERROR);
            }
            return bridgeSize;
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(NOT_NUMBER);
        }
    }

    public static String validateMoving(String input) throws IllegalArgumentException {
        if (!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException(MOVING_ERROR);
        }
        return input;
    }
}
