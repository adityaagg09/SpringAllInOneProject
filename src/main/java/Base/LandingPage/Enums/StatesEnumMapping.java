package Base.LandingPage.Enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum StatesEnumMapping {
    HR("Haryana", true),
    PB("Punjab", true),
    JK("Jammu & Kashmir", false);

    String stateValue;

    boolean isEnabeled;

    public String getStateValue() {
        return stateValue;
    }

    public boolean isEnabeled() {
        return isEnabeled;
    }

    StatesEnumMapping(String stateValue, boolean isEnabeled) {
        this.stateValue = stateValue;
        this.isEnabeled = isEnabeled;
    }

    public static StatesEnumMapping getStateEnum(StatesEnumMapping stateValue) {
        return Arrays.stream(StatesEnumMapping.values()).filter(stateEnum -> stateEnum.equals(stateValue)).findFirst().get(); // Returning the full enum object
    }

    public static List<String> getStateNames() {
        List<String> stateNames = new ArrayList<>(); // Returning the enums names
        for(StatesEnumMapping state : StatesEnumMapping.values()) {
            if(state.isEnabeled) {
                stateNames.add(state.stateValue);
            }
        }
        return stateNames;
    }

    public static List<String> getStateEnumNames() {
        List<String> stateNames = new ArrayList<>(); // Returning the enums values corresponding to the names
        for(StatesEnumMapping state : StatesEnumMapping.values()) {
            if(state.isEnabeled) {
                stateNames.add(state.name());
            }
        }
        return stateNames;
    }


}
