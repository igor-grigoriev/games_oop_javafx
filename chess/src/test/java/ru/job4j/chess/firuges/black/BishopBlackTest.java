package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BishopBlackTest {
    @Test
    public void whenPosition() {
        Cell expected = Cell.A1;
        BishopBlack bishop = new BishopBlack(expected);
        assertThat(bishop.position()).isEqualTo(expected);
    }

    @Test
    public void whenCopy() {
        Cell expected = Cell.A1;
        BishopBlack bishop = new BishopBlack(expected);
        assertThat(bishop.copy(expected).position()).isEqualTo(expected);
    }

    @Test
    public void whenWay() {
        Cell[] expected = {
                Cell.D2, Cell.E3, Cell.F4, Cell.G5 };
        BishopBlack bishop = new BishopBlack(Cell.C1);
        assertThat(bishop.way(Cell.G5)).isEqualTo(expected);
    }

    @Test
    public void whenWayException() {
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
            new BishopBlack(Cell.A1).way(Cell.A2); });
        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from A1 to A2");
    }
}