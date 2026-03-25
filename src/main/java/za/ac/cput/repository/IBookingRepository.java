package za.ac.cput.repository;


import za.ac.cput.domain.Booking;
import java.util.List;

public interface IBookingRepository {


    Booking create(Booking booking);
    Booking read(Integer id);
    Booking update(Booking booking);
    boolean delete(Integer id);
    List<Booking> getAll();


    List<Booking> findByStatus(String status);
    List<Booking> findByStudentId(int studentId);
    List<Booking> findByEventId(int eventId);
}