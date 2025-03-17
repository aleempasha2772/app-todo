package com.example.todo_app.Model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Item {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String taskname;
	private LocalDateTime date;
	private String description;
	private boolean status;

	public Item(Integer id, String taskname, String description, boolean status) {
		this.id = id;
		this.taskname = taskname;
		this.description = description;
		this.status = status;
	}

	@PrePersist
	protected void onCreate() {
		this.date = LocalDateTime.now();
	}

	public Item() {

	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTaskname() {
		return taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Item{" +
				"id=" + id +
				", taskname='" + taskname + '\'' +
				", description='" + description + '\'' +
				", status=" + status +
				'}';
	}
}

