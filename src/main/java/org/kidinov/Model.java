package org.kidinov;

public class Model {
    private final String url;
    private final String text;

    public Model(String url, String text) {
        this.url = url;
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public String getText() {
        return text;
    }

}
