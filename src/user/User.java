package user;

public class User {
    private String name;
    private String companyName;
    private int yearOfJoining;
    private String email;
    private String password;


    public User(String name, String companyName, int yearOfJoining) {
        this.name = name;
        this.companyName = companyName;
        this.yearOfJoining = yearOfJoining;
        this.email = createUserEmail();
        this.password = createUserPassword();
    }

    private String createUserEmail() {
        return String.format("%s_%d@%s.com", getName().toLowerCase(), getYearOfJoining(), getCompanyName().toLowerCase());
    }

    private String createUserPassword() {
        StringBuilder sb = new StringBuilder();
        sb.append(generateRandomIntegerFromLimit(10));
        for (int i = 0; i < 4; i++) {
            sb.append(generateRandomCharacter());
        }
        sb.append(getFirst5CharacteresFromUserName());
        sb.append(generateRandomSpecialSymbol());
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public void setYearOfJoining(int yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }

    public String getEmail() {
        return email;

    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String getFirst5CharacteresFromUserName() {
        if (getName().length() < 5) {
            int difference = 5 - getName().length();
            StringBuilder tempName = new StringBuilder(getName());
            for (int i = 0; i < difference; i++) {
                tempName.append("0");
            }
            return tempName.toString();
        } else {
            return getName().substring(0, 5);
        }
    }

    private char generateRandomSpecialSymbol() {
        char[] specialSymbols =
                {
                        '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '{', '}', '[', ']', '"', ':', ';', '<', '>', '/', '.', '?'
                };
        int randomInteger = generateRandomIntegerFromLimit(specialSymbols.length);
        return specialSymbols[randomInteger];
    }

    private char generateRandomCharacter() {
        int randomNumberUpto26 = generateRandomIntegerFromLimit(26);
        return (char) ('a' + randomNumberUpto26);
    }

    public int generateRandomIntegerFromLimit(int limit) {
        return (int) (Math.random() * limit);

    }
}

class information {
    public static void main(String[] args) {
        User obj = new User("shivendra", "amazon", 2022);
        System.out.println(obj.getEmail());
        System.out.println(obj.getPassword());
    }
}








