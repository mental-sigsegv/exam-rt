package sk.stuba.fei.uim.oop;

import lombok.Getter;

public class MousePosition {
    @Getter
    private int x;
    @Getter
    private int y;
    public MousePosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
