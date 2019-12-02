package cz.upce.fei.inptp.project.entity;

import java.util.Objects;

public class Driver {
    private String identifier;

    public Driver(String identifier) {
        this.identifier = Objects.requireNonNull(identifier, "identifier should not be null!");
    }

    public String getIdentifier() {
        return identifier;
    }
}
