package com.akorelyakov.webapp.storage;

import com.akorelyakov.webapp.model.Resume;

public interface Storage {

    void clear();

    void save(Resume resume);

    void update(Resume resume);

    Resume get(String uuid);

    void delete(String uuid);

    Resume[] getAll();

    int size();
}
