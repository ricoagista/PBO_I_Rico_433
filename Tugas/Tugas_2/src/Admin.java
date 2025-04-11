class Admin {
    private final String validUsername = "admin";
    private final String validPassword = "admin";

    public boolean login(String username, String password) {
        return username.equals(validUsername) && password.equals(validPassword);
    }
}