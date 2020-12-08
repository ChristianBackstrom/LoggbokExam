public class Body {
    User creator;
    String text;

    public Body(User creator, String text) {
        this.creator = creator;
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreator() {
        return this.creator.getUser();
    }

    public String getText() {
        return text;
    }

    public String getCreatorString() {
        return this.creator.getUser();
    }
}
