package ch.bbw.services;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@SessionScope
public class BackgroundColor {
    private final List<String> colors = List.of("red", "blue", "green", "yellow");
    private Map<UUID, String> users;

    public String getUserColor(UUID uuid) {
        return users.get(uuid);
    }

    public void generateColor(UUID uuid) {
        users.put(uuid, colors.get(getRandomNumber(0, 3)));
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
