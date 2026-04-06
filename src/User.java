public class User {
    private String name;
    private Integer age;
    private String registration;
    private boolean hasPhoto;
    private double fine;


    public User(String name,String registration, Integer age) {
        if(age == null){
            throw new RuntimeException("Idade invalida");
        } else if (age < 0) {
            throw new RuntimeException("Volte mais tarde");
        } else if (name.isEmpty() || registration.isEmpty()) {
            throw new RuntimeException("Campo nome ou matricula vazio!");
        }
        this.registration = registration;
        this.name = name;
        this.age = age;
        this.hasPhoto = false;
    }

    public String getName() {
        return name;
    }

    public void setHasFoto() {
        this.hasPhoto = true;
    }

    public void setFine(double fine){
        this.fine = fine;
    }

    public double getFine() {
        return fine;
    }

    public boolean IsHasPhoto() {
        return hasPhoto;
    }

    public Integer getAge() {
        return age;
    }

    public String getRegistration() {
        return registration;
    }

    @Override
    public String toString(){
        return "Nome: " + this.name + "\nMatricula: " + this.registration + "\nIdade: " + this.age;
    }
}


