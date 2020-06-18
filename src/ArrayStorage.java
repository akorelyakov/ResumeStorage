import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int counter = 0;

    void clear() {
        for (int i = 0; i < counter; i++) {
            storage[i] = null;
        }
        counter = 0;
    }

    void save(Resume resume) {
        storage[counter] = resume;
        counter++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < counter; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int index = -1;
        for (int i = 0; i < counter; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                index = i;
            }
        }
        if (index != -1) {
            System.arraycopy(storage, index + 1, storage, index, storage.length - 1 - index);
        }
        counter--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return counter == 0 ? null : Arrays.copyOfRange(storage, 0, counter);
    }

    int size() {
        return counter;
    }
}
