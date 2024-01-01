package dev.akbayin.vokabeltrainerbackend.controllers;

import dev.akbayin.vokabeltrainerbackend.dto.TransferVocabulary;
import dev.akbayin.vokabeltrainerbackend.models.Vocabulary;
import dev.akbayin.vokabeltrainerbackend.services.VocabularyService;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/vokabeln")
public class VocabularyController {

    private final VocabularyService vocabularyService;

    public VocabularyController(VocabularyService vocabularyService) {
        this.vocabularyService = vocabularyService;
    }

    @CrossOrigin
    @GetMapping("all")
    public List<TransferVocabulary> getAllVocabularies() {
        return vocabularyService.getAllVocabularies();
    }

    @CrossOrigin
    @GetMapping("{amountOfVocabularies}")
    public List<TransferVocabulary> getAmountOfVocabularies(@PathVariable int amountOfVocabularies) {
        return vocabularyService.getAmountOfVocabularies(amountOfVocabularies);
    }
}
