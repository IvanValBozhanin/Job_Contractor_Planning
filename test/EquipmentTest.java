import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentTest {

    private Equipment concrete;
    private Equipment concrete1;
    private Equipment torch;
    private Equipment torch1;
    private Equipment tower;
    private Equipment tower1;
    private Equipment hammer;
    private Equipment hammer1;

    @BeforeEach
    void setUp() {
        concrete = new ConcreteMixer("Siuuuu");
        concrete1 = new ConcreteMixer("Siuuuu");
        torch = new Torch("Siuuuu");
        torch1 = new Torch("Siuuuu");
        tower = new ScaffoldingTower("Siuuuu");
        tower1 = new ScaffoldingTower("Siuuuu");
        hammer = new JackHammer("Siuuuu");
        hammer1 = new JackHammer("Siuuuu");
    }

    @Test
    void getRequirementsSuccess() {
        assertEquals("Siuuuu", torch.getRequirements());
    }

    @Test
    void testEqualsSuccess() {
        assertEquals(concrete, concrete1);
        assertEquals(hammer, hammer1);
        assertEquals(tower, tower1);
        assertEquals(torch, torch1);
    }

    @Test
    void testToStringSuccess() {
        assertEquals("Torch{Equipment{requirements='Siuuuu'} Butane Gas power supply}", torch.toString());
        assertEquals("ScaffoldingTower{Equipment{requirements='Siuuuu'}}", tower.toString());
        assertEquals("JackHammer{Equipment{requirements='Siuuuu'} Air Compressor power supply}", hammer.toString());
        assertEquals("ConcreteMixer{ Equipment{requirements='Siuuuu'} }", concrete.toString());
    }
}