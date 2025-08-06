package youtube_coderArmy.SOLID_design.Dependency_Inversion_Principle;

// Abstraction (Interface)
interface Database {
    void save(String data);
}

// MySQL implementation (Low-level module)
class MySQLDatabase1 implements Database {
    @Override
    public void save(String data) {
        System.out.println(
                "Executing SQL Query: INSERT INTO users VALUES('"
                        + data + "');"
        );
    }
}

// MongoDB implementation (Low-level module)
class MongoDBDatabase1 implements Database {
    @Override
    public void save(String data) {
        System.out.println(
                "Executing MongoDB Function: db.users.insert({name: '"
                        + data + "'})"
        );
    }
}

// High-level module (Now loosely coupled via Dependency Injection)
class UserService1 {
    private final Database db;

    public UserService1(Database database) {
        this.db = database;
    }

    public void storeUser(String user) {
        db.save(user);
    }
}

public class DIPFollowed {
    public static void main(String[] args) {
        MySQLDatabase1 mysql = new MySQLDatabase1();
        MongoDBDatabase1 mongodb = new MongoDBDatabase1();

        UserService1 service1 = new UserService1(mysql);
        service1.storeUser("Prabhu");

        UserService1 service2 = new UserService1(mongodb);
        service2.storeUser("Teja");
    }
}