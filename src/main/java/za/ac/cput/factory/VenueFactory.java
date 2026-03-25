package za.ac.cput.factory;

import za.ac.cput.domain.Venue;
import za.ac.cput.util.Helper;

public class VenueFactory {

    public static Venue createVenue(int venueId,
                                    String venueName,
                                    String campus,
                                    String locationDetails,
                                    int capacity) {

        if (!Helper.isValidVenueId(venueId)) {
            throw new IllegalArgumentException("Venue ID must be greater than 0");
        }

        if (!Helper.isValidVenueName(venueName)) {
            throw new IllegalArgumentException("Venue name cannot be empty");
        }

        if (!Helper.isValidCampus(campus)) {
            throw new IllegalArgumentException("Campus cannot be empty");
        }

        if (!Helper.isValidLocationDetails(locationDetails)) {
            throw new IllegalArgumentException("Location details cannot be empty");
        }

        if (!Helper.isValidCapacity(capacity)) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }

        return new Venue.Builder(venueId)
                .setVenueName(venueName)
                .setCampus(campus)
                .setLocationDetails(locationDetails)
                .setCapacity(capacity)
                .build();
    }
}
