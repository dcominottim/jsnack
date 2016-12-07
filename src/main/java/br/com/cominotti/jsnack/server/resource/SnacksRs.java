package br.com.cominotti.jsnack.server.resource;

import br.com.cominotti.jsnack.server.validation.Validate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SnacksRs {

    private final List<SnackRs> snacks;


    public SnacksRs(List<SnackRs> snacks) {
        Validate.notNull(snacks);
        this.snacks = Collections.unmodifiableList(snacks);
    }


    public List<SnackRs> getSnacks() {
        return new ArrayList<>(snacks);
    }
}
