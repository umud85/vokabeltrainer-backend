package dev.akbayin.vokabeltrainerbackend.services;

import dev.akbayin.vokabeltrainerbackend.models.Vocabulary;
import dev.akbayin.vokabeltrainerbackend.repositories.VocabularyRepository;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class VocabularyServiceTest {
    private final List<Vocabulary> mockedList = new ArrayList<>();

    @BeforeEach
    void setup() {
        Vocabulary voc = new Vocabulary(
                new ObjectId(),
                "ensconced",
                new String[]{"versteckt"});
        Vocabulary otherVoc = new Vocabulary(
                new ObjectId(),
                "to forgo sth.",
                new String[]{"etwas aufgeben", "auf etwas verzichten"});
        mockedList.add(voc);
        mockedList.add(otherVoc);
    }

    @Test
    public void testGetAllVocabulariesReturnsSizeOf2() {
        VocabularyRepository vocabularyRepository = mock(VocabularyRepository.class);
        when(vocabularyRepository.findAll()).thenReturn(mockedList);
        VocabularyService vocabularyService = new VocabularyService(vocabularyRepository);
        var result = vocabularyService.getAllVocabularies();
        assertEquals(2, result.size());
    }

    @Test
    public void getAmountOfVocabulariesReturns1() {
        VocabularyRepository vocabularyRepository = mock(VocabularyRepository.class);
        when(vocabularyRepository.findAll()).thenReturn(mockedList);
        VocabularyService vocabularyService = new VocabularyService(vocabularyRepository);
        var result = vocabularyService.getAmountOfVocabularies(1);
        assertEquals(1, result.size());
    }
}

