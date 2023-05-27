package fr.orionbs.experience_service.adapter.exception;

public class UnknownExperienceException extends RuntimeException {
    public UnknownExperienceException() {
        super("unknown-experience-exception");
    }
}
