/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.upce.fei.inptp.zz.entity;

import java.util.Objects;

/**
 *
 * @author Roman
 */
public class Driver {
    private String identifier;

    public Driver(String identifier) {
        this.identifier = Objects.requireNonNull(identifier, "identifier should not be null!");
    }

    public String getIdentifier() {
        return identifier;
    }
}
