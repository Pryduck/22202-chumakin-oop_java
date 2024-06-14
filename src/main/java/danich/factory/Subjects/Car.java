package danich.factory.Subjects;

import danich.factory.ID.IDAssignor;

public class Car extends Subject {
    protected final Body body;
    protected final Motor motor;
    protected final Accessory accessory;

    public Car(Body body, Motor motor, Accessory accessory) {
        super(IDAssignor.generateId());
        this.body = body;
        this.motor = motor;
        this.accessory = accessory;
    }

    public Body getBody() {
        return body;
    }

    public Accessory getAccessory() {
        return accessory;
    }

    public Motor getMotor() {
        return motor;
    }
}

