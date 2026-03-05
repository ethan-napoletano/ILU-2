package model;

public class ReservationHotel extends Reservation {
    private int nbLitSimple;
    private int nbLitDouble;
    private int numeroChambre;

    public ReservationHotel(int jour, int mois, int nbLitSimple, int nbLitDouble, int numeroChambre) {
        super(jour, mois);
        this.nbLitSimple = nbLitSimple;
        this.nbLitDouble = nbLitDouble;
        this.numeroChambre = numeroChambre;
    }

    @Override
    public String toString() {
        return "Le " + jour + "/" + mois + " : chambre n°" + numeroChambre +
               " avec " + nbLitSimple + " lit simple et " + nbLitDouble + " lit double.";
    }
}
