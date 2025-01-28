package badicecream.gui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScreenCreatorTest {

    private ScreenCreator screenCreator;
    private  int width;
    private  int height;
    private  int fontSize;

    @BeforeEach
    void setup(){
        screenCreator = Mockito.mock(ScreenCreator.class);
        width = 50;
        height = 50;
        fontSize = 10;
    }

    @Test
    void constructor(){
        screenCreator = new ScreenCreator(width, height, fontSize);
        assertEquals(50, width);
        assertEquals(50, height);
        assertEquals(10, fontSize);
    }

}
