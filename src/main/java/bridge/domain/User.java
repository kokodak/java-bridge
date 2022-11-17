package bridge.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {

    private final List<String> userMoved;

    public User() {
        userMoved = new ArrayList<>();
    }

    public void move(String moving) {
        userMoved.add(moving);
    }

    public List<String> getUserMoved() {
        return Collections.unmodifiableList(userMoved);
    }
}
