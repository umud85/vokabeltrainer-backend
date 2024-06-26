package dev.akbayin.vokabeltrainerbackend.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
public class VocabularyDTO {

    private UUID id;

    private String englishVocabulary;

    private String[] germanVocabularies;

    private int step;

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEnglishVocabulary() {
        return englishVocabulary;
    }

    public void setEnglishVocabulary(String englishVocabulary) {
        this.englishVocabulary = englishVocabulary;
    }

    public String[] getGermanVocabularies() {
        return germanVocabularies;
    }

    public void setGermanVocabularies(String[] germanVocabularies) {
        this.germanVocabularies = germanVocabularies;
    }
}
