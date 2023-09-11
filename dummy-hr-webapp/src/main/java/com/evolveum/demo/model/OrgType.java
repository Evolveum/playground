package com.evolveum.demo.model;

/**
 * Created by Viliam Repan (lazyman).
 */
public enum OrgType {

    ApprenticeArmory("Apprentice/Armory Department/Military Department/Grand Master"),
    ApprenticeWeapons("Apprentice/Weapons Department/Military Department/Grand Master"),
    ApprenticeBuildings("Apprentice/Buildings Department/Civil Department/Grand Master"),
    ApprenticeArtefacts("Apprentice/Artefacts Department/Civil Department/Grand Master"),
    MasterArmory("Armory Department/Military Department/Grand Master"),
    MasterWeapons("Weapons Department/Military Department/Grand Master"),
    MasterBuildings("Buildings Department/Civil Department/Grand Master"),
    MasterArtefacts("Artefacts Department/Civil Department/Grand Master"),
    MasterMilitary("Military Department/Grand Master"),
    MasterCivil("Civil Department/Grand Master"),
    GrandMaster("Grand Master");

    public final String label;

    OrgType(String label) {
        this.label = label;
    }

    public static String getFullOrg(String type) {
        // dunno what to do here
        return type;
    }
}
