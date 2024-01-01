package dev.akbayin.vokabeltrainerbackend.services;

import dev.akbayin.vokabeltrainerbackend.dto.TransferVocabulary;
import dev.akbayin.vokabeltrainerbackend.models.Vocabulary;
import dev.akbayin.vokabeltrainerbackend.repositories.VocabularyRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class VocabularyService {

    private final VocabularyRepository vocabularyRepository;

    public VocabularyService(VocabularyRepository vocabularyRepository) {
        this.vocabularyRepository = vocabularyRepository;
    }

    public List<TransferVocabulary> getAllVocabularies() {
        return vocabularyRepository.findAll().stream().map(
                vocRaw -> {
                    TransferVocabulary transferVocabulary = new TransferVocabulary();
                    transferVocabulary.setId(UUID.randomUUID());
                    transferVocabulary.setEnglishVocabulary(vocRaw.getEnglishVocabulary());
                    transferVocabulary.setGermanVocabularies(vocRaw.getGermanVocabularies());
                    return transferVocabulary;
                }
        ).collect(Collectors.toList());
    }

    public List<TransferVocabulary> getAmountOfVocabularies(int amountOfVocabularies) {
        List<Vocabulary> allVocabularies = vocabularyRepository.findAll();
        Collections.shuffle(allVocabularies);

        return allVocabularies.subList(0, amountOfVocabularies).stream().map(
                vocRaw -> {
                    TransferVocabulary transferVocabulary = new TransferVocabulary();
                    transferVocabulary.setId(UUID.randomUUID());
                    transferVocabulary.setEnglishVocabulary(vocRaw.getEnglishVocabulary());
                    transferVocabulary.setGermanVocabularies(vocRaw.getGermanVocabularies());
                    transferVocabulary.setStep(0);
                    return transferVocabulary;
                }
        ).collect(Collectors.toList());
    }
}
