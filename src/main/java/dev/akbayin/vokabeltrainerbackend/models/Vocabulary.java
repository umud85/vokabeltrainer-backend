package dev.akbayin.vokabeltrainerbackend.models;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "EnglishToGermanShort")
public class Vocabulary {

    @Id
    private ObjectId id;

    @Field("Englisch")
    private String englishVocabulary;

    @Field("Deutsch")
    private String[] germanVocabularies;

    public ObjectId getId() {
        return id;
    }

    public Vocabulary() {
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
