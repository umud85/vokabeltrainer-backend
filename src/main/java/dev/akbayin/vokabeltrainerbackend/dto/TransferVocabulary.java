package dev.akbayin.vokabeltrainerbackend.dto;

import java.util.UUID;

public class TransferVocabulary {

    private UUID id;

    private String englishVocabulary;

    private String[] germanVocabularies;

    public UUID getId() {
        return id;
    }

    public TransferVocabulary() {
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
