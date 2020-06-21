package com.example.sweater.domain;

import com.example.sweater.domain.util.MessageHelper;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message="Please, fill the message field")
    @Length(max=2048, message="Message is too long (more than 2 kB).")
    private String text;
    @NotBlank(message = "Please fill the tag field")
    @Length(max = 255, message = "Tag mustn`t be longer than 255 symbols.")
    private String tag;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    @ManyToMany
    @JoinTable(
            name = "message_likes",
            joinColumns = {@JoinColumn(name = "message_id")},
            inverseJoinColumns ={@JoinColumn(name = "user_id")}
    )
    private Set<User> likes = new HashSet<>();

    private String filename;

    public Message(){}

    public Message(String text, String tag, User user){
        this.text=text;
        this.tag=tag;
        this.author=user;
    }

    public String getAuthorName(){
        return MessageHelper.getAuthorName(author);
    }

    public Long getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Set<User> getLikes() {
        return likes;
    }

    public void setLikes(Set<User> likes) {
        this.likes = likes;
    }
}
