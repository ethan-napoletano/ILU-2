package model;


public abstract class Reservation {
    protected int jour;
    protected int mois;

    public Reservation(int jour, int mois) {
        this.jour = jour;
        this.mois = mois;
    }

    public int getJour() {
        return jour;
    }

    public int getMois() {
        return mois;
    }

    @Override
    public abstract String toString();
}
