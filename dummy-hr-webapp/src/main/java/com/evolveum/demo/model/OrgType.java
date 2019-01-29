package com.evolveum.demo.model;

/**
 * Created by Viliam Repan (lazyman).
 */
public enum OrgType {

    ApprenticeArmory,
    ApprenticeWeapons,
    ApprenticeBuildings,
    ApprenticeArtefacts,
    MasterArmory,
    MasterWeapons,
    MasterBuildings,
    MasterArtefacts,
    MasterMilitary,
    MasterCivil,
    GrandMaster;

    public static String getFullOrg(String type) {
        // dunno what to do here
        return type;
    }
}
