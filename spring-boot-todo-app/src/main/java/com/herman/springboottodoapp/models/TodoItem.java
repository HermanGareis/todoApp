package com.herman.springboottodoapp.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name = "todo_item")
public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @NotBlank(message = "Description is required")
    private String description;

    @Getter
    @Setter
    private boolean complete;

    @Getter
    @Setter
    private String createdDate;

    @Getter
    @Setter
    private String modifiedDate;
    
    @Getter
    @Setter
    private String completedDate;

    public TodoItem() {}

    public TodoItem(String description) {
        this.description = description;
        this.complete = false;
        this.createdDate = dateFormat(LocalDateTime.now());
        this.modifiedDate = dateFormat(LocalDateTime.now());
        this.completedDate = null;
    }
    
    
    public String dateFormat(LocalDateTime time) {
    	DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm E, MMM dd yyyy");
    	String formattedDate = time.format(myFormatObj);
    	return formattedDate;
    }
    
    @Override
    public String toString() {
        return String.format("TodoItem{id=%d, description='%s', complete='%s', createdDate='%s', modifiedDate='%s', completedDate= '%s'}",
        id, description, complete, createdDate, modifiedDate, completedDate);
    }
    
}
