package youtube_coderArmy.SOLID_design.LiskovSubstitution_Principle.LSP_Rules.Method_Rule.Pre_Condition_Rule;


// A Precondition must be satisfied before a method can be executed.
// Subclasses can weaken the precondition but cannot strengthen it.

class User {
    // Precondition: Password must be at least 8 characters long
    public void setPassword(String password) {
        if (password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long!");
        }
        System.out.println("Password set successfully");
    }
}

class AdminUser extends User {
    // Precondition: Password must be at least 6 characters
    @Override
    public void setPassword(String password) {
        if (password.length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters long!");
        }
        System.out.println("Password set successfully");
    }
}

public class PreConditions {
    public static void main(String[] args) {
        User user = new AdminUser();
        user.setPassword("Admin1");  // Works fine: AdminUser allows shorter passwords
    }
}
