package za.ac.cput.repository;

import za.ac.cput.domain.Venue;
import java.util.*;

public class VenueRepository implements IVenueRepository {

    private static VenueRepository instance;
    private final Map<Integer, Venue> store = new HashMap<>();

    private VenueRepository() {}

    public static VenueRepository getInstance() {
        if (instance == null) {
            instance = new VenueRepository();
        }
        return instance;
    }

    @Override
    public Venue create(Venue entity) {
        store.put(entity.getVenueId(), entity);
        return entity;
    }

    @Override
    public Venue read(Integer id) {
        return store.get(id);
    }

    @Override
    public Venue update(Venue entity) {
        if (store.containsKey(entity.getVenueId())) {
            store.put(entity.getVenueId(), entity);
            return entity;
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        if (store.containsKey(id)) {
            store.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Venue> getAll() {
        return new ArrayList<>(store.values());
    }
}
