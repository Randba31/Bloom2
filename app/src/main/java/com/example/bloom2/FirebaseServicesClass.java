package com.example.bloom2;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

public class FirebaseServicesClass {

        private static FirebaseServicesClass instance;
        private FirebaseAuth auth;
        private FirebaseFirestore fire;
        private FirebaseStorage storage ;

    public FirebaseAuth getAuth() {
        return auth;
    }

    public FirebaseFirestore getFire() {
        return fire;
    }

    public FirebaseStorage getStorage() {
        return storage;
    }

    public FirebaseServicesClass()
        {
            auth=FirebaseAuth.getInstance();
            fire=FirebaseFirestore.getInstance();
            storage=FirebaseStorage.getInstance();
        }

        public static FirebaseServicesClass getInstance() {
            if (instance==null)
                instance=new FirebaseServicesClass();
            return instance;
        }

}
