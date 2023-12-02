package dev.akbayin.vokabeltrainerbackend.repositories;

import dev.akbayin.vokabeltrainerbackend.models.Vocabulary;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VocabularyRepository extends MongoRepository<Vocabulary, ObjectId> {
}
