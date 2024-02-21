package com.example.demo.repository;

import com.example.demo.domain.Locate;
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
public class LocateRepos {
    public static final String COLLECTION_NAME = "locates";

    public List<Locate> getLocates() throws ExecutionException, InterruptedException {
        List<Locate> list = new ArrayList<>();
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = db.collection(COLLECTION_NAME).get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        for (QueryDocumentSnapshot document : documents) {
            list.add(document.toObject(Locate.class));
        }
        return list;
    }

    public String createLocate(Locate locate) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference addedDocRef = db.collection(COLLECTION_NAME).add(locate).get();
        return addedDocRef.getId();
    }

    public Locate getLatestLocateByUserId(String userId) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        System.out.println("ddd");
        Query query = db.collection(COLLECTION_NAME)
                .whereEqualTo("user_id", userId)
                .orderBy("current_time", Query.Direction.DESCENDING)
                .limit(1);
        System.out.println("kkk");

        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        System.out.println("kkk");
        List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();

        System.out.println("kkk");

        if (!documents.isEmpty()) {
            QueryDocumentSnapshot latestDocument = documents.get(0);
            return latestDocument.toObject(Locate.class);
        } else {
            return null; // 해당 사용자의 위치 정보가 없을 경우 null 반환
        }
    }
}
