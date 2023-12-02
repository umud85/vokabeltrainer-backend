package dev.akbayin.vokabeltrainerbackend.controllers;

import dev.akbayin.vokabeltrainerbackend.dto.TransferVocabulary;
import dev.akbayin.vokabeltrainerbackend.models.Vocabulary;
import dev.akbayin.vokabeltrainerbackend.services.VocabularyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class VocabularyController {

    private final VocabularyService vocabularyService;

    public VocabularyController(VocabularyService vocabularyService) {
        this.vocabularyService = vocabularyService;
    }

    @GetMapping("/")
    public List<TransferVocabulary> getAllVocabularies() {
        return vocabularyService.getVocabularies().stream().map(
                vocRaw -> {
                    TransferVocabulary transferVocabulary = new TransferVocabulary();
                    transferVocabulary.setId(UUID.randomUUID());
                    transferVocabulary.setEnglishVocabulary(vocRaw.getEnglishVocabulary());
                    transferVocabulary.setGermanVocabularies(vocRaw.getGermanVocabularies());
                    return transferVocabulary;
                }
        ).collect(Collectors.toList());
    }
}
