package dev.akbayin.vokabeltrainerbackend.services;

import dev.akbayin.vokabeltrainerbackend.models.Vocabulary;
import dev.akbayin.vokabeltrainerbackend.repositories.VocabularyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VocabularyService {

    private final VocabularyRepository vocabularyRepository;

    public VocabularyService(VocabularyRepository vocabularyRepository) {
        this.vocabularyRepository = vocabularyRepository;
    }

    public List<Vocabulary> getVocabularies() {
        return vocabularyRepository.findAll();
    }
}
