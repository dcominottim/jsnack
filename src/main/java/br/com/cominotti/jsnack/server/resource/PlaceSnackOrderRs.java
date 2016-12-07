package br.com.cominotti.jsnack.server.resource;

import br.com.cominotti.jsnack.server.validation.Validate;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PlaceSnackOrderRs {

    private final Integer snackId;


    @JsonCreator
    public PlaceSnackOrderRs(@JsonProperty("snackId") Integer snackId) {
        Validate.positiveNumber(snackId);
        this.snackId = snackId;
    }


    public Integer getSnackId() {
        return snackId;
    }
}
