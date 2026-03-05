package model;

public abstract class Formulaire {
    protected int jour;
    protected int mois;
    protected int numeroEntite; 

    public Formulaire(int jour, int mois) {
        this.jour = jour;
        this.mois = mois;
    }

    public int getJour() {
        return jour;
    }

    public int getMois() {
        return mois;
    }

    public int getNumeroEntite() {
        return numeroEntite;
    }

    public void setNumeroEntite(int numeroEntite) {
        this.numeroEntite = numeroEntite;
    }

    @Override
    public abstract String toString();
}
