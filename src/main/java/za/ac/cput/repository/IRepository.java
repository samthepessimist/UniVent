package za.ac.cput.repository;

/**Student name: Samukelo Ndlela
 * Student number: 231116144
 * Group: 3H
 * IRepository.java
 * Date: 24 March 2026
 * **/
import java.util.List;

public interface IRepository<T, ID> {
    T create(T entity);

    T read(ID id);

    T update(T entity);

    boolean delete(ID id);

    List<T> getAll();
}
