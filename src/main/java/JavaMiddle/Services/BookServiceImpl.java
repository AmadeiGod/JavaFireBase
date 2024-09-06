package JavaMiddle.Services;


import JavaMiddle.Models.Book;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class BookServiceImpl {
    private static final String COLLECTION_NAME = "books";

    public String save(Book book) throws ExecutionException, InterruptedException {

        Firestore firestore = FirestoreClient.getFirestore();

        ApiFuture<DocumentReference> apiFuture = firestore.collection(COLLECTION_NAME).add(book);

        return apiFuture.get().toString();
    }
    public Book get(String name) throws ExecutionException, InterruptedException {

        Firestore firestore = FirestoreClient.getFirestore();

        DocumentReference documentReference = firestore.collection(COLLECTION_NAME).document(name);

        ApiFuture<DocumentSnapshot> documentSnapshotApiFuture = documentReference.get();

        DocumentSnapshot documentSnapshot = documentSnapshotApiFuture.get();

        if(documentSnapshot.exists()){
            return documentSnapshot.toObject(Book.class);
        }
        return null;
    }
    public String delete(String name) throws ExecutionException, InterruptedException {

        Firestore firestore = FirestoreClient.getFirestore();

        ApiFuture<WriteResult> apiFuture = firestore.collection(COLLECTION_NAME).document(name).delete();

        return "Книга удалена : " + name;
    }
    public List<Book> getAll() throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();

        Iterable<DocumentReference> documentReference = firestore.collection(COLLECTION_NAME).listDocuments();
        Iterator<DocumentReference> documentReferenceIterator = documentReference.iterator();

        List<Book> list = new ArrayList<>();
        Book book = null;

        while(documentReferenceIterator.hasNext()){
            DocumentReference documentReference1 = documentReferenceIterator.next();
            ApiFuture<DocumentSnapshot> future = documentReference1.get();
            DocumentSnapshot documentSnapshot = future.get();

            book = documentSnapshot.toObject(Book.class);
            list.add(book);
        }
        return list;
    }
}
