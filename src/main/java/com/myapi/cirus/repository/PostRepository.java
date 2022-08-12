package com.myapi.cirus.repository;

import com.myapi.cirus.domain.Post;
import com.myapi.cirus.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {
}
