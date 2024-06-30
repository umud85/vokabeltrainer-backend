package dev.akbayin.vokabeltrainerbackend.repositories;

import dev.akbayin.vokabeltrainerbackend.models.Vocabulary;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VocabularyRepository extends MongoRepository<Vocabulary, ObjectId> {
}
