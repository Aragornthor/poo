package services;

public interface CRUD<T> {

    /**
     * Permet l'ajout en base de l'entité de type T.
     * @param entity
     */
    Integer create(T entity);

    /**
     * Permet la lecture en base de l'entité ayant l'id searchId.
     * @param searchId
     */
    T readFromId(Integer searchId);

    /**
     * Permet la modification en base de l'entité de type T. Si l'entité n'existe pas, alors elle sera créée.
     * @param entity
     */
    void update(T entity);

    /**
     * Permet la suppression en base de l'entité de type T.
     * @param entity
     */
    void delete(T entity);
}
