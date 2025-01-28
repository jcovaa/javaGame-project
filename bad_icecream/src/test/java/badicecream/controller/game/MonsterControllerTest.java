package badicecream.controller.game;

import badicecream.model.arena.Arena;
import badicecream.model.arena.Cell;
import badicecream.model.arena.Grid;
import badicecream.model.elements.characters.Monster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class MonsterControllerTest {
    private MonsterController monsterController;
    private Grid mockedGrid;
    private Monster mockedMonsterUp;
    private Monster mockedMonsterDown;
    private Monster mockedMonsterLeft;
    private Monster mockedMonsterRight;

    @BeforeEach
    public void setup() {
        Arena mockedArena = mock(Arena.class);
        mockedGrid = mock(Grid.class);
        Cell mockedCell = mock(Cell.class);

        when(mockedArena.getGrid()).thenReturn(mockedGrid);

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                when(mockedGrid.getCell(x, y)).thenReturn(mockedCell);
            }
        }

        mockedMonsterUp = mock(Monster.class);
        when(mockedMonsterUp.getDirection()).thenReturn("UP");
        when(mockedMonsterUp.getX()).thenReturn(5);
        when(mockedMonsterUp.getY()).thenReturn(5);

        mockedMonsterDown = mock(Monster.class);
        when(mockedMonsterDown.getDirection()).thenReturn("DOWN");
        when(mockedMonsterDown.getX()).thenReturn(6);
        when(mockedMonsterDown.getY()).thenReturn(6);

        mockedMonsterLeft = mock(Monster.class);
        when(mockedMonsterLeft.getDirection()).thenReturn("LEFT");
        when(mockedMonsterLeft.getX()).thenReturn(7);
        when(mockedMonsterLeft.getY()).thenReturn(7);

        mockedMonsterRight = mock(Monster.class);
        when(mockedMonsterRight.getDirection()).thenReturn("RIGHT");
        when(mockedMonsterRight.getX()).thenReturn(8);
        when(mockedMonsterRight.getY()).thenReturn(8);

        List<Monster> mockedMonsters = new ArrayList<>();
        mockedMonsters.add(mockedMonsterUp);
        mockedMonsters.add(mockedMonsterDown);
        mockedMonsters.add(mockedMonsterLeft);
        mockedMonsters.add(mockedMonsterRight);

        when(mockedArena.getMonsters()).thenReturn(mockedMonsters);

        monsterController = new MonsterController(mockedArena);
    }

    @Test
    public void stepMonsterTest() {
        when(mockedMonsterUp.canMove(5, 4, mockedGrid)).thenReturn(true);
        when(mockedMonsterDown.canMove(6, 7, mockedGrid)).thenReturn(true);
        when(mockedMonsterLeft.canMove(6, 7, mockedGrid)).thenReturn(true);
        when(mockedMonsterRight.canMove(9, 8, mockedGrid)).thenReturn(true);

        monsterController.step(null, null, 0);
        verify(mockedMonsterUp, never()).moveUp(mockedGrid);
        verify(mockedMonsterDown, never()).moveDown(mockedGrid);
        verify(mockedMonsterLeft, never()).moveLeft(mockedGrid);
        verify(mockedMonsterRight, never()).moveRight(mockedGrid);

        monsterController.step(null, null, 600);
        verify(mockedMonsterUp, times(1)).moveUp(mockedGrid);
        verify(mockedMonsterDown, times(1)).moveDown(mockedGrid);
        verify(mockedMonsterLeft, times(1)).moveLeft(mockedGrid);
        verify(mockedMonsterRight, times(1)).moveRight(mockedGrid);
    }

    @Test
    public void moveVerticallyBolckedTest() {
        when(mockedMonsterUp.canMove(5, 4, mockedGrid)).thenReturn(false);
        when(mockedMonsterDown.canMove(6, 7, mockedGrid)).thenReturn(false);
        when(mockedMonsterUp.canMove(5, 6, mockedGrid)).thenReturn(true);
        when(mockedMonsterDown.canMove(6, 5, mockedGrid)).thenReturn(true);

        monsterController.moveVertically();

        verify(mockedMonsterUp).setDirection("DOWN");
        verify(mockedMonsterDown).setDirection("UP");
        verify(mockedMonsterUp).moveDown(mockedGrid);
        verify(mockedMonsterDown).moveUp(mockedGrid);
    }

    @Test
    public void moveHorizontallyBlockedTest() {
        when(mockedMonsterLeft.canMove(6, 7, mockedGrid)).thenReturn(false);
        when(mockedMonsterRight.canMove(9, 8, mockedGrid)).thenReturn(false);
        when(mockedMonsterLeft.canMove(8, 7, mockedGrid)).thenReturn(true);
        when(mockedMonsterRight.canMove(7, 8, mockedGrid)).thenReturn(true);

        monsterController.moveHorizontally();

        verify(mockedMonsterLeft).setDirection("RIGHT");
        verify(mockedMonsterRight).setDirection("LEFT");
        verify(mockedMonsterLeft).moveRight(mockedGrid);
        verify(mockedMonsterRight).moveLeft(mockedGrid);
    }
}
