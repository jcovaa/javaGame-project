package badicecream.model.elements.fruits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WaterMelonTest {

    private WaterMelon waterMelon;

    @BeforeEach
    public void setup() {
        waterMelon = new WaterMelon(3, 6);
    }

    @Test
    public void waterMelonConstructor() {
        Assertions.assertEquals(3, waterMelon.getX());
        Assertions.assertEquals(6, waterMelon.getY());
    }
}
