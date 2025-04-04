package com.codelounge.springboot.kafka.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="wikimedia")
@Getter
@Setter
public class WikimediaData {
   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWikiEventData() {
        return wikiEventData;
    }

    public void setWikiEventData(String wikiEventData) {
        this.wikiEventData = wikiEventData;
    }

    @Lob
    private String wikiEventData;
}
