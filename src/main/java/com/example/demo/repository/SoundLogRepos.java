package com.example.demo.repository;

import com.example.demo.domain.Sound;
import com.example.demo.domain.SoundLog;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
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
}
