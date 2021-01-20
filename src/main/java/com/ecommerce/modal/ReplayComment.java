package com.ecommerce.modal;
import java.util.Date;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="comments_replay")
public class ReplayComment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String messageReplay;
	
	private String addedBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date addedAt;
	
	@JsonBackReference(value = "comment")
	@ManyToOne
	private Comment comment;

	public ReplayComment() {
		super();
	}

	public ReplayComment(String messageReplay, String addedBy, Date addedAt, Comment comment) {
		super();
		this.messageReplay = messageReplay;
		this.addedBy = addedBy;
		this.addedAt = addedAt;
		this.comment = comment;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessageReplay() {
		return messageReplay;
	}

	public void setMessageReplay(String messageReplay) {
		this.messageReplay = messageReplay;
	}

	public String getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}

	public Date getAddedAt() {
		return addedAt;
	}

	public void setAddedAt(Date addedAt) {
		this.addedAt = addedAt;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}
	
	
}
