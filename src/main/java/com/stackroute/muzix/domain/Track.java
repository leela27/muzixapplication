package com.stackroute.muzix.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Data
public class Track {
    @Id
    private  int trackId;
    private String trackName;
    private  String trackComments;

}
