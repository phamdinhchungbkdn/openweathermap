package apiengine.model.response;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Error {

    public String cod;
    public String message;

    /**
     * No args constructor for use in serialization
     *
     */
    public Error() {
    }

    /**
     *
     * @param cod
     * @param message
     */
    public Error(String cod, String message) {
        super();
        this.cod = cod;
        this.message = message;
    }

}