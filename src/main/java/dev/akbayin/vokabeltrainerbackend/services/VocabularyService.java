package dev.akbayin.vokabeltrainerbackend.services;

import dev.akbayin.vokabeltrainerbackend.dto.VocabularyDTO;
import dev.akbayin.vokabeltrainerbackend.models.Vocabulary;
import dev.akbayin.vokabeltrainerbackend.repositories.VocabularyRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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

    public List<VocabularyDTO> getAllVocabularies() {
        return vocabularyRepository.findAll().stream().map(
                vocRaw -> {
                    VocabularyDTO vocabularyDTO = new VocabularyDTO();
                    vocabularyDTO.setId(UUID.randomUUID());
                    vocabularyDTO.setEnglishVocabulary(vocRaw.getEnglishVocabulary());
                    vocabularyDTO.setGermanVocabularies(vocRaw.getGermanVocabularies());
                    return vocabularyDTO;
                }
        ).collect(Collectors.toList());
    }

    public List<VocabularyDTO> getAmountOfVocabularies(int amountOfVocabularies) {
        List<Vocabulary> allVocabularies = vocabularyRepository.findAll();
        Collections.shuffle(allVocabularies);

        return allVocabularies.subList(0, amountOfVocabularies).stream().map(
                vocRaw -> {
                    VocabularyDTO vocabularyDTO = new VocabularyDTO();
                    vocabularyDTO.setId(UUID.randomUUID());
                    vocabularyDTO.setEnglishVocabulary(vocRaw.getEnglishVocabulary());
                    vocabularyDTO.setGermanVocabularies(vocRaw.getGermanVocabularies());
                    vocabularyDTO.setStep(0);
                    return vocabularyDTO;
                }
        ).collect(Collectors.toList());
    }
}
