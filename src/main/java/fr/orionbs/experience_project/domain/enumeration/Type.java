package fr.orionbs.experience_project.domain.enumeration;

public enum Type {
    LANGUAGE("Language"),
    FRAMEWORK("Framework"),
    DESIGN_PATTERN("Design pattern"),
    ARCHITECTURE("Architecture"),
    DEPLOYMENT("Deployment"),
    ENVIRONMENT("Environment");

    private final String label;

    Type(String label) {
        this.label = label;
    }

}
