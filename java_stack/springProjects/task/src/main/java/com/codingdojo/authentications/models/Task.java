package com.codingdojo.authentications.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="tasks")
public class Task {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Size(min=5, max=255)
    private String msg;
    @Size(min=2, max=10)
    private String priority;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @Transient
    @Range(min=1,max=1000)
    private Long assignee_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="creator_id")
    private User creator;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="assignee_id")
    private User assignee;
    
    public Long getAssignee_id() {
		return assignee_id;
	}

	public void setAssignee_id(Long assignee_id) {
		this.assignee_id = assignee_id;
	}

	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    
	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

	public Task(@Size(min = 5, max = 255) String msg, @Size(min = 5, max = 10) String priority) {
		super();
		this.msg = msg;
		this.priority = priority;
	}

	public Task(@Size(min = 5, max = 255) String msg, @Size(min = 5, max = 10) String priority, User creator,
			User assignee) {
		super();
		this.msg = msg;
		this.priority = priority;
		this.creator = creator;
		this.assignee = assignee;
	}

	public Task() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public User getAssignee() {
		return assignee;
	}

	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}

	
}
