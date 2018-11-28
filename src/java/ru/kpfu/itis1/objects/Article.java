package ru.kpfu.itis1.objects;

import java.util.Objects;

public class Article {

    private String title;
    private String text;
    private String username;

    public Article(String username, String title, String text) {
        this.title = title;
        this.text = text;
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;
        Article article = (Article) o;
        return Objects.equals(title, article.title) &&
                Objects.equals(text, article.text) &&
                Objects.equals(username, article.username);
    }
}
