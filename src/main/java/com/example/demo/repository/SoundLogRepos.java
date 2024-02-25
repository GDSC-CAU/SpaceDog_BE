package com.example.demo.repository;

import com.example.demo.domain.Sound;
import com.example.demo.domain.SoundLog;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Repository
@Slf4j
public class SoundLogRepos {
    public static final String COLLECTION_NAME = "soundLogs";

    public List<SoundLog> getSoundLogs() throws ExecutionException, InterruptedException {
        List<SoundLog> list = new ArrayList<>();
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = db.collection(COLLECTION_NAME).get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        for (QueryDocumentSnapshot document : documents) {
            list.add(document.toObject(SoundLog.class));
        }
        return list;
    }

    public List<SoundLog> getSoundLogsByUserId(String userId) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        Query query = db.collection(COLLECTION_NAME).whereEqualTo("user_id", userId);
        ApiFuture<QuerySnapshot> querySnapshot = query.get();
        List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();

        List<SoundLog> soundLogs = new ArrayList<>();
        for (DocumentSnapshot document : documents) {
            soundLogs.add(document.toObject(SoundLog.class));
        }
        return soundLogs;
    }

    public String createSoundLog(SoundLog soundLog) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference addedDocRef = db.collection(COLLECTION_NAME).add(soundLog).get();
        return addedDocRef.getId();
    }


}
