package com.akorelyakov.webapp.storage;

import com.akorelyakov.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10_000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    public void save(Resume resume) {
        int searchKey = getSearchKey(resume.getUuid());
        if (searchKey <= 0) {
            storage[size] = resume;
            size++;
        } else {
            System.out.println("resume is already exist");
        }
    }

    public void update(Resume resume) {
        int searchKey = getSearchKey(resume.getUuid());
        if (searchKey >= 0) {
            storage[searchKey] = resume;
            size++;
        } else {
            System.out.println("resume is not exist");
        }
    }

    public Resume get(String uuid) {
        int searchKey = getSearchKey(uuid);
        if (searchKey >= 0) {
            return storage[searchKey];
        } else {
            System.out.println("resume is not exist");
        }
        return null;
    }

    public void delete(String uuid) {
        int searchKey = getSearchKey(uuid);
        if (searchKey >= 0) {
            System.arraycopy(storage, searchKey + 1, storage, searchKey, storage.length - 1 - searchKey);
            size--;
        } else {
            System.out.println("resume is not exist");
        }
    }

    public Resume[] getAll() {
        return size == 0 ? null : Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }

    private int getSearchKey(String uuid) {
        int searchKey = -1;
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                searchKey = i;
            }
        }
        return searchKey;
    }
}
