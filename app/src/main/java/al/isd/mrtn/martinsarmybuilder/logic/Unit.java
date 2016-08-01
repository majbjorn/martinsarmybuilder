package al.isd.mrtn.martinsarmybuilder.logic;

import java.util.ArrayList;
import java.util.List;

public class Unit {

    private final BaseUnit baseUnit;
    private List<Upgrade> upgrades = new ArrayList<>();
    private int extraUnits;

    public Unit(BaseUnit baseUnit) {
        this.baseUnit = baseUnit;
    }

    public void addExtraUnits(int num) {
        this.extraUnits += num;
    }

    public int getTotalUnitCount() {
        return this.baseUnit.baseUnitCount + this.extraUnits;
    }

    public void addUpgrade(Upgrade upgrade) {
        this.upgrades.add(upgrade);
    }

    public int getPointCost() {
        // Total point cost = cost/unit * unit_count.
        int allPoints = baseUnit.basePointCost + this.extraUnits * baseUnit.incrPointCost;
        for (Upgrade upgrade : this.upgrades) {
            allPoints += upgrade.pointCost;
        }
        return allPoints;
    }

    public int getCompCost() {
        int allkomp = baseUnit.baseCompCost +
                (int) Math.round(Math.floor(this.extraUnits * baseUnit.incrCompCost));
        for (Upgrade upgrade : this.upgrades) {
            allkomp += upgrade.kompCost;
        }
        return allkomp;
    }

    public enum BaseUnit {
        AUTARCH(Faction.ELDAR, "Autarch", UnitType.INFANTRY, Role.HQ, 1, 70, 3, 0, 0),
        GUARDIAN_DEFENDERS(Faction.ELDAR, "Guardian Defenders", UnitType.INFANTRY, Role.TROOP, 10, 90, 7, 9, 1 / 2.0),
        RANGERS(Faction.ELDAR, "Rangers", UnitType.INFANTRY, Role.TROOP, 5, 60, 5, 12, 0.5);


        public final Faction faction;
        private final UnitType unitType;
        private final Role role;
        private final int basePointCost;
        private final int incrPointCost;
        private final int baseCompCost;
        private final double incrCompCost;
        private final int baseUnitCount;

        BaseUnit(Faction faction, String name, UnitType unitType, Role role, int baseUnitCount,
                 int basePointCost, int baseCompCost, int incrPointCost, double incrCompCost) {
            this.faction = faction;
            this.unitType = unitType;
            this.role = role;
            this.baseUnitCount = baseUnitCount;
            this.basePointCost = basePointCost;
            this.incrPointCost = incrPointCost;
            this.baseCompCost = baseCompCost;
            this.incrCompCost = incrCompCost;
        }
    }

    public enum Faction {
        ELDAR, SPACE_MARINES
    }

    public enum Role {
        HQ, TROOP, ELITE, FAST_ATTACK, HEAVY_SUPPORT, LORD_OF_WAR
    }

    public enum UnitType {
        INFANTRY, JUMP_INFRANTRY, TANK, MONSTER
    }

    public enum Upgrade {
        SWOOPING_HAWK_WINGS(15, 2);

        public final int pointCost;
        public final int kompCost;

        Upgrade(int pointCost, int kompCost) {
            this.pointCost = pointCost;
            this.kompCost = kompCost;
        }
    }
}