package model;

public class ReservationRestaurant extends Reservation {
    private int service; 
    private int numeroTable;

    public ReservationRestaurant(int jour, int mois, int service, int numeroTable) {
        super(jour, mois);
        this.service = service;
        this.numeroTable = numeroTable;
    }

    @Override
    public String toString() {
        String serviceStr = (service == 1) ? "premier service" : "deuxième service";
        return "Le " + jour + "/" + mois + "\nTable " + numeroTable + " pour le " + serviceStr + ".";
    }
}
