package danich.factory.Subjects;

abstract public class Subject {
    protected final long id;

    public Subject(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
