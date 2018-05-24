package edu.sdu.kz.baseapplication.data.network.models;

import java.io.Serializable;

public class Note implements Serializable{
    public String content,objectId;
    Long created,updated;

    public Long geDate(){
        return updated==null?created:updated;
    }

    public Note(){}

    public Note(String content) {
        this.content = content;
    }

}
