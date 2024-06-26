package dev.akbayin.vokabeltrainerbackend.controllers;

import dev.akbayin.vokabeltrainerbackend.dto.VocabularyDTO;
import dev.akbayin.vokabeltrainerbackend.services.VocabularyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vokabeln")
public class VocabularyController {

    private final VocabularyService vocabularyService;

    public VocabularyController(VocabularyService vocabularyService) {
        this.vocabularyService = vocabularyService;
    }

    @CrossOrigin
    @GetMapping("all")
    public ResponseEntity<List<VocabularyDTO>> getAllVocabularies() {
        List<VocabularyDTO> vocabularies = vocabularyService.getAllVocabularies();
        if (vocabularies == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(vocabularies);
        }
    }

    @CrossOrigin
    @GetMapping("{amountOfVocabularies}")
    public List<VocabularyDTO> getAmountOfVocabularies(@PathVariable int amountOfVocabularies) {
        return vocabularyService.getAmountOfVocabularies(amountOfVocabularies);
    }
}
