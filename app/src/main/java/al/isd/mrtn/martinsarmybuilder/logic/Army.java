package al.isd.mrtn.martinsarmybuilder.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by isdal on 7/31/16.
 */
public class Army {
    private final List<Unit> units = new ArrayList<>();


    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public List<Unit> getUnits() {
        return units;
    }

    public int getTotalPointCost() {
        int totalPoints = 0;
        for (Unit unit : this.units) {
            totalPoints += unit.getPointCost();
        }
        return totalPoints;
    }

    public int getTotalCompCost() {
        int totalComp = 0;
        for (Unit unit : this.units) {
            totalComp += unit.getCompCost();
        }
        return totalComp;
    }
}
