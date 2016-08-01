package al.isd.mrtn.martinsarmybuilder.logic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArmyTest {
    @Test
    public void testAdd(){
        Army army = new Army();
        {
            Unit autarch = new Unit(Unit.BaseUnit.AUTARCH);
            autarch.addUpgrade(Unit.Upgrade.SWOOPING_HAWK_WINGS);
            army.addUnit(autarch);
        }
        {
            Unit gd = new Unit(Unit.BaseUnit.GUARDIAN_DEFENDERS);
            gd.addExtraUnits(5);
            army.addUnit(gd);
        }
        army.addUnit(new Unit(Unit.BaseUnit.GUARDIAN_DEFENDERS));
        assertEquals(21, army.getTotalCompCost());
        assertEquals(310, army.getTotalPointCost());
    }
}