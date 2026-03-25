package za.ac.cput.factory;

import za.ac.cput.domain.Booking;
import za.ac.cput.domain.BookingStatusEnum;
import za.ac.cput.domain.Student;
import za.ac.cput.domain.Event;
import za.ac.cput.util.Helper;

import java.time.LocalDateTime;

public class BookingFactory {

    public static Booking createBooking(int bookingId,
                                        LocalDateTime bookingDate,
                                        BookingStatusEnum status,
                                        Student student,
                                        Event event) {

        if (!Helper.isPositive(bookingId)) {
            throw new IllegalArgumentException("Booking ID must be greater than 0");
        }

        if (!Helper.isValidDateTime(bookingDate)) {
            throw new IllegalArgumentException("Invalid booking date");
        }

        if (status == null) {
            throw new IllegalArgumentException("Booking status is required");
        }

        if (student == null) {
            throw new IllegalArgumentException("Student is required");
        }

        if (event == null) {
            throw new IllegalArgumentException("Event is required");
        }

        return new Booking.Builder()
                .setBookingId(bookingId)
                .setBookingDate(bookingDate)
                .setStatus(status)
                .setStudent(student)
                .setEvent(event)
                .build();
    }
}
