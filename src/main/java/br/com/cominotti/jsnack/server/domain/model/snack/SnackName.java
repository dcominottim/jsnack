package br.com.cominotti.jsnack.server.domain.model.snack;

import br.com.cominotti.jsnack.server.validation.Validate;

public class SnackName {

    private String name;


    private SnackName(String name) {
        Validate.notNullNorEmpty(name);
        this.name = name;
    }


    public static SnackName of(String name) {
        return new SnackName(name);
    }

    public String getValue() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SnackName snackName = (SnackName) o;

        return name.equals(snackName.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }
}
