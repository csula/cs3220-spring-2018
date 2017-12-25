package edu.csula.cs3220.dao;

import java.util.List;
import java.util.Optional;

/**
 * DAO (Data Access Object) is common abstraction layer between business model
 * to database
 *
 * Commoon operations in this layer is to parse result set into business model
 * and vice versa
 */
public interface DAO<T> {
    // List a list of objects
    public List<T> list();

    // return single object given its id
    public Optional<T> get(int id);

    // add item obj into database
    public void add(T obj);

    // update item
    public void update(T obj);

    // delete item given id
    public void delete(int id);
}
