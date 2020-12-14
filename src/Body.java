public class Body {
    String creator;
    String text;

    public Body(String creator, String text) {
        this.creator = creator;
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreator() {
        return this.creator;
    }

    public String getText() {
        return text;
    }
}
