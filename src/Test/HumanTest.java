import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

class HumanTest {

    @Test
    void absorbLoot() {
        MaxCoordinates.maxCols = 100;
        MaxCoordinates.maxRows = 100;
        Human human = new Human();
        Random random = new Random();
        ArrayList<Piece> lootList = Loot.getLootList(random);
        int originalLootListSize = lootList.size();
        human.setCoordinates(lootList.get(0).coordinates);
        lootList = human.absorbLoot(lootList);
        assertTrue(originalLootListSize > lootList.size());
        assertTrue(lootList.stream().noneMatch(Objects::isNull));
    }
}