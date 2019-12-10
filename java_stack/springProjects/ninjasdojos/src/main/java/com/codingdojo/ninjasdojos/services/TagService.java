package com.codingdojo.ninjasdojos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.ninjasdojos.models.Tag;
import com.codingdojo.ninjasdojos.repositories.TagRepository;

@Service
public class TagService {
	private TagRepository tagRepository;
	
	public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }
	// returns all the tags
    public List<Tag> allTags() {
        return tagRepository.findAll();
    }
    
    // creates a tag
    public Tag createTag(Tag b) {
        return tagRepository.save(b);
    }
    // retrieves a tag
	    public Tag findTag(Long id) {
	        Optional<Tag> optionalTag = tagRepository.findById(id);
	        if(optionalTag.isPresent()) {
	            return optionalTag.get();
	        } else {
	            return null;
	        }
	    }
	 // retrieves a tag
	    public Tag findTagByName(String tag) {
	        Optional<Tag> optionalTag = tagRepository.findByTag(tag);
	        if(optionalTag.isPresent()) {
	            return optionalTag.get();
	        } else {
	            return null;
	        }
	    }
		public void deleteTag(Long id) {
			tagRepository.deleteById(id);
			
		}
		public Tag updateTag(Tag tag) {	
			tagRepository.save(tag);
			return null;
		}
}
