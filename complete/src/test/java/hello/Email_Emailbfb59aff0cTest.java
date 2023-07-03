package hello;

public class Email {
    private String to;
    private String body;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        if (to == null) {
            throw new IllegalArgumentException("To field cannot be null");
        }
        this.to = to;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        if (body == null) {
            throw new IllegalArgumentException("Body cannot be null");
        }
        this.body = body;
    }
}
