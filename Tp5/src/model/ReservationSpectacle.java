package model;

public class ReservationSpectacle extends Reservation {
    private int zone;
    private int numeroChaise;

    public ReservationSpectacle(int jour, int mois, int zone, int numeroChaise) {
        super(jour, mois);
        this.zone = zone;
        this.numeroChaise = numeroChaise;
    }

    @Override
    public String toString() {
        return "Le " + jour + "/" + mois + " : place en zone n°" + zone + ", chaise n°" + numeroChaise + ".";
    }
}
