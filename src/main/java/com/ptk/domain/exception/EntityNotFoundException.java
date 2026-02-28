package com.ptk.domain.exception;

/**
 * Exception thrown when a requested entity is not found.
 */
public class EntityNotFoundException extends DomainException {

    public EntityNotFoundException(String entityName, Long id) {
        super(String.format("%s with id %d not found", entityName, id));
    }

    public EntityNotFoundException(String entityName, String identifier) {
        super(String.format("%s with identifier '%s' not found", entityName, identifier));
    }

    public EntityNotFoundException(String message) {
        super(message);
    }
}
