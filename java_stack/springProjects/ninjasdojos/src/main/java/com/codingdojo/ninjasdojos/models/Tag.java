package com.codingdojo.ninjasdojos.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.codingdojo.ninjasdojos.models.*;

@Entity
@Table(name="tag")
public class Tag {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Size(min = 3, max = 255)
    private String tag;
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "dojos_tags", 
        joinColumns = @JoinColumn(name = "tag_id"), 
        inverseJoinColumns = @JoinColumn(name = "dojo_id")
    )
    private List<Dojo> dojos;
	public Tag(@Size(min = 3, max = 255) String tag) {
		super();
		this.tag = tag;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public List<Dojo> getDojos() {
		return dojos;
	}
	public void setDojos(List<Dojo> dojos) {
		this.dojos = dojos;
	}
	

}
