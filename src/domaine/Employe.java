package domaine;


public class Employe {
    Genre genre;
    int taille;

    public Employe(Genre genre, int taille, String nom) {
        this.genre = genre;
        this.taille = taille;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    String nom;

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public boolean isHomme(){
        return this.genre == Genre.HOMME;
    }
}
