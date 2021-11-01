package cz.uhk.garmintostravasynchronizationmanager.model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Dto {

    public Object dataObject;
    public List<String> errors;

    public Dto() {
    }

    public Dto(Object dataObject, List<String> errors) {
        this.dataObject = dataObject;
        this.errors = errors;
    }

    public Object getDataObject() {
        return dataObject;
    }

    public void setDataObject(Object dataObject) {
        this.dataObject = dataObject;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
