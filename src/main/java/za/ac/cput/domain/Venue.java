package za.ac.cput.domain;
/**
 * Name: Sesethu Nciti
 * Description: VenueRepository
 * Date: 25 March 2026
 **/

public class Venue {

    private final int venueId;
    private String venueName;
    private String campus;
    private String locationDetails;
    private int capacity;

    // Private constructor for Builder
    private Venue(Builder builder) {
        this.venueId = builder.venueId;
        this.venueName = builder.venueName;
        this.campus = builder.campus;
        this.locationDetails = builder.locationDetails;
        this.capacity = builder.capacity;
    }

    // Getters
    public int getVenueId() {
        return venueId;
    }

    public String getVenueName() {
        return venueName;
    }

    public String getCampus() {
        return campus;
    }

    public String getLocationDetails() {
        return locationDetails;
    }

    public int getCapacity() {
        return capacity;
    }

    // Methods
    public boolean checkAvailability(int requestedCapacity) {
        return requestedCapacity <= capacity;
    }

    public void updateVenueDetails(String venueName, String campus, String locationDetails, int capacity) {
        this.venueName = venueName;
        this.campus = campus;
        this.locationDetails = locationDetails;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Venue{" +
                "venueId=" + venueId +
                ", venueName='" + venueName + '\'' +
                ", campus='" + campus + '\'' +
                ", locationDetails='" + locationDetails + '\'' +
                ", capacity=" + capacity +
                '}';
    }

    // Builder Class
    public static class Builder {
        private final int venueId; // required
        private String venueName;
        private String campus;
        private String locationDetails;
        private int capacity;

        public Builder(int venueId) {
            this.venueId = venueId;
        }

        public Builder setVenueName(String venueName) {
            this.venueName = venueName;
            return this;
        }

        public Builder setCampus(String campus) {
            this.campus = campus;
            return this;
        }

        public Builder setLocationDetails(String locationDetails) {
            this.locationDetails = locationDetails;
            return this;
        }

        public Builder setCapacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        // Only one build() method, returning a Venue
        public Venue build() {
            return new Venue(this);
        }
    }
}





