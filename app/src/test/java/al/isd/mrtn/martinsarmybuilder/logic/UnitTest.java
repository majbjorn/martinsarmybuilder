package al.isd.mrtn.martinsarmybuilder.logic;

import org.junit.Test;

import static org.junit.Assert.*;

public class UnitTest {
    @Test
    public void testKompSingleUpgrade(){
        Unit autarch = new Unit(Unit.BaseUnit.AUTARCH);
        autarch.addUpgrade(Unit.Upgrade.SWOOPING_HAWK_WINGS);
        assertEquals(5, autarch.getCompCost());
    }

    @Test
    public void testPointsSingleUpgrade(){
        Unit autarch = new Unit(Unit.BaseUnit.AUTARCH);
        autarch.addUpgrade(Unit.Upgrade.SWOOPING_HAWK_WINGS);
        assertEquals(85, autarch.getPointCost());
    }

    @Test
    public void testExtraUnitsPoints(){
        Unit gd = new Unit(Unit.BaseUnit.GUARDIAN_DEFENDERS);
        gd.addExtraUnits(1);
        gd.addExtraUnits(1);
        gd.addExtraUnits(1);
        gd.addExtraUnits(1);
        gd.addExtraUnits(1);
        assertEquals(15, gd.getTotalUnitCount());
        assertEquals(135, gd.getPointCost());
    }

    @Test
    public void testExtraUnitsComp(){
        Unit gd = new Unit(Unit.BaseUnit.GUARDIAN_DEFENDERS);
        gd.addExtraUnits(5);
        assertEquals(15, gd.getTotalUnitCount());
        assertEquals(9, gd.getCompCost());
    }

}