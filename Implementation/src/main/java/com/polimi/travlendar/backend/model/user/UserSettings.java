package com.polimi.travlendar.backend.model.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter 
public class UserSettings {
	
	private PreferenceLevel bikePreference, carPreference;
	private int maxWalkingDistance;
	private boolean carAvailability, bikeAvailability, drivingLicense;

    public UserSettings(PreferenceLevel bikePreference, PreferenceLevel carPreference, int maxWalkingDistance, boolean carAvailability, boolean bikeAvailability, boolean drivingLicense) {
        this.bikePreference = bikePreference;
        this.carPreference = carPreference;
        this.maxWalkingDistance = maxWalkingDistance;
        this.carAvailability = carAvailability;
        this.bikeAvailability = bikeAvailability;
        this.drivingLicense = drivingLicense;
    }

    public UserSettings() {
    }

    @Override
    public String toString() {
        return "UserSettings{" + "bikePreference=" + bikePreference + ", carPreference=" + carPreference + ", maxWalkingDistance=" + maxWalkingDistance + ", carAvailability=" + carAvailability + ", bikeAvailability=" + bikeAvailability + ", drivingLicense=" + drivingLicense + '}';
    }
	
        
	
}
