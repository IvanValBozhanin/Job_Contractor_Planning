import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentTest {

    private Equipment concrete;
    private Equipment torch;
    private Equipment tower;
    private Equipment hammer;

    @BeforeEach
    void setUp() {
        concrete = new ConcreteMixer("Siuuuu");
        torch = new Torch("Siuuuu");
        tower = new ScaffoldingTower("Siuuuu");
        hammer = new JackHammer("Siuuuu");
    }

    @Test
    void getRequirementsSuccess() {
        assertEquals("Siuuuu", torch.getRequirements());
    }

    @Test
    void testEqualsFailure() {
        assertNotEquals(concrete, tower);
    }

    @Test
    void testToStringSuccess() {
        assertEquals("Torch{Equipment{requirements='Siuuuu'}}", torch.toString());
    }
}