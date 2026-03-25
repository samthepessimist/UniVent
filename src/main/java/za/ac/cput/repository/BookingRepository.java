package za.ac.cput.repository;
import za.ac.cput.domain.Booking;

import java.util.*;

/**
 * Student name: Nondumiso
 * Student number: 222703768
 * Group: 3H
 * BookingRepository.java
 * Date: 25 March 2026
 **/

public class BookingRepository implements IBookingRepository {

    private static BookingRepository repository = null;
    private Map<Integer, Booking> bookingMap;

    private BookingRepository() {
        bookingMap = new HashMap<>();
    }

    public static BookingRepository getRepository() {
        if (repository == null) {
            repository = new BookingRepository();
        }
        return repository;
    }

    @Override
    public Booking create(Booking booking) {
        bookingMap.put(booking.getBookingId(), booking);
        return booking;
    }

    @Override
    public Booking read(Integer id) {
        return bookingMap.get(id);
    }

    @Override
    public Booking update(Booking booking) {
        if (bookingMap.containsKey(booking.getBookingId())) {
            bookingMap.put(booking.getBookingId(), booking);
            return booking;
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return bookingMap.remove(id) != null;
    }

    @Override
    public List<Booking> getAll() {
        return new ArrayList<>(bookingMap.values());
    }

    // Optional search methods

    public List<Booking> findByStatus(String status) {
        List<Booking> result = new ArrayList<>();
        for (Booking booking : bookingMap.values()) {
            if (booking.getStatus() != null && booking.getStatus().toString().equals(status)) {
                result.add(booking);
            }
        }
        return result;
    }

    public List<Booking> findByStudentId(int studentId) {
        List<Booking> result = new ArrayList<>();
        for (Booking booking : bookingMap.values()) {
            if (booking.getStudent() != null &&
                    booking.getStudent().getUserId() == studentId) {
                result.add(booking);
            }
        }
        return result;
    }

    public List<Booking> findByEventId(int eventId) {
        List<Booking> result = new ArrayList<>();
        for (Booking booking : bookingMap.values()) {
            if (booking.getEvent() != null &&
                    booking.getEvent().getEventId() == eventId) {
                result.add(booking);
            }
        }
        return result;
    }
}