package br.com.cominotti.jsnack.server.domain.model.snack;

import br.com.cominotti.jsnack.server.validation.Validate;

public final class SnackId {

    private Integer id;


    private SnackId(Integer id) {
        Validate.positiveNumber(id);
        this.id = id;
    }


    public static SnackId of(Integer id) {
        return new SnackId(id);
    }


    public Integer getValue() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SnackId snackId = (SnackId) o;

        return id.equals(snackId.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return id.toString();
    }
}
