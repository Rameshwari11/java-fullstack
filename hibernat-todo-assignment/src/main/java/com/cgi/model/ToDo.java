package com.cgi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "todolist")
public class ToDo {
	
	@Id
	@Column(name = "todo_id")
	private int todoId;
	
	@Column(name = "todo_name")
	private String todoName;
	
	@Column(name = "is_completed")
	private boolean isCompleted;

	public int getTodoId() {
		return todoId;
	}

	public void setTodoId(int todoId) {
		this.todoId = todoId;
	}

	public String getTodoName() {
		return todoName;
	}

	public void setTodoName(String todoName) {
		this.todoName = todoName;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}


	@Override
	public String toString() {
		return "ToDo [todoId=" + todoId + ", todoName=" + todoName + ", isCompleted=" + isCompleted + "]";
	}


	public ToDo(int todoId, String todoName, boolean isCompleted) {
		super();
		this.todoId = todoId;
		this.todoName = todoName;
		this.isCompleted = isCompleted;
	}

	public ToDo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
