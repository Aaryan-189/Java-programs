interface Authenticatable {
    void login(String user, String pass); 
    default void audit() {
        System.out.println("[Audit] Authenticatable");
    }
}

interface PowerManageable {
    void powerUsage(); 
    default void audit() {
        System.out.println("[Audit] PowerManageable");
    }
}


abstract class BaseDevice {
    int deviceId;
    String deviceName;
    public BaseDevice() {
        this(0, "Basic Device"); 
    }
    public BaseDevice(int deviceId, String deviceName) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
    }
    public abstract void operate(); 
    public final void deviceCard() { 
        System.out.println("ID: " + deviceId + "  Name: " + deviceName);
    }
    public static void policy() { 
        System.out.println("Policy: Use devices responsibly to save energy.");
    }
}

class SmartFan extends BaseDevice implements Authenticatable, PowerManageable {
    public SmartFan(int id, String name) {
        super(id, name);
    }
    @Override
    public void operate() {
        System.out.println(deviceName + " is in a SmartFan.");
    }
    @Override
    public void login(String user, String pass) {
        System.out.println("Fan Access Granted for user: " + user);
    }
    @Override
    public void powerUsage() {
        System.out.println("Fan consuming 50W.");
    }
    @Override
    public void audit() {
        System.out.println("Resolving Conflict in SmartFan");
        Authenticatable.super.audit();
        PowerManageable.super.audit();
    }
}

class SmartWasher extends BaseDevice implements Authenticatable, PowerManageable {
    public SmartWasher(int id, String name) {
        super(id, name);
    }
    @Override
    public void operate() {
        System.out.println(deviceName + " is in a SmartWasher.");
    }
    @Override
    public void login(String user, String pass) {
        System.out.println("Washer Access Granted for user: " + user);
    }
    @Override
    public void powerUsage() {
        System.out.println("Washer consuming 500W.");
    }
    @Override
    public void audit() {
        System.out.println("Resolving Conflict in SmartWasher");
        PowerManageable.super.audit();
    }
}

class Controller {
    public void connect(BaseDevice d) {
        System.out.println("DeviceName: " + d.deviceName);
    }
    public void connect(BaseDevice d, int timeout) {
        System.out.println("DeviceName: " + d.deviceName + "  Timeout " + timeout );
    }
    public void connect(BaseDevice d, String mode, int timeout) {
        System.out.println("DeviceName: " + d.deviceName + " Mode: " + mode + " Timeout: " + timeout );
    }
}

public class Challenge {
    public static void main(String[] args) {
        BaseDevice.policy();
        BaseDevice fan = new SmartFan(101, "Living Room Fan");
        BaseDevice washer = new SmartWasher(202, "Laundry Washer");
        fan.deviceCard();
        fan.operate();   
        Authenticatable authWasher = (Authenticatable) washer;
        authWasher.login("Admin", "Pass123");
        authWasher.audit(); 
        PowerManageable powerFan = (PowerManageable) fan;
        powerFan.powerUsage();
        System.out.println("Controller");
        Controller remote = new Controller();
        remote.connect(fan);
        remote.connect(washer, 5000);
        remote.connect(fan, "SECURE", 3000);
    }
}