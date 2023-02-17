import java.util.Scanner;

public class Partie {

    private boolean partieEnCours;
    private boolean aGagne;
    private boolean aPerdu;

/*=========================| Constructeur |=========================*/

    public Partie() { // constructeur
        this.partieEnCours = true;
        this.aGagne = false;
        this.aPerdu = false;
    }

/*=========================| Get / Set |=========================*/

    public boolean getEtatPartie() { // recupere l'état de la partie (true pour en cours / false pour fini)
        return partieEnCours;
    }

    public void setEtatPartie(boolean etatPartie) { // permet de modifier l'état de la Partie
        this.partieEnCours = etatPartie;
    }
    
    public boolean getAGagne() { // savoir si le joueur a gagne
        return aGagne;
    }

    public void setAGagne(boolean aGagne) { // permet de changer l'état de si le joueur à gagné
        this.aGagne = aGagne;
    }

    public boolean getAPerdu() { // savoir si joueur à perdu
        return aPerdu;
    }

    public void setAPerdu(boolean aPerdu) { // permet de changer l'état de si le joueur à perdu
        this.aPerdu = aPerdu;
    }

/*=========================| Fonction / Procedure |=========================*/

    public void gestionMenuPrincipal(Scanner sc, EntreeSortie entreeSortie) { // Gestion du Menu Principal

        while (partieEnCours) {

            //affichage titre du jeu
            entreeSortie.titre();
            int choixMenuPrincipal = entreeSortie.menuPrincipal(sc);
            switch (choixMenuPrincipal) {
                case 1:
                    // Lancer l'initialisation du jeu
                    initialisationPartie(sc, entreeSortie);
                    break;
                case 2:
                    System.out.println("**Parametre**");
                    // Lancer Menu Parametre
                    break;
                case 3:
                    System.out.println("**Credit**");
                    // Lancer Credit
                    break;
                case 4:
                    // on quitte la partie en mettant en false la boucle
                    this.partieEnCours = false;
                    break;
                default:
                    System.out.println("==| Choix non correct |==");
                    break;
            }
        }
    }

    public void initialisationPartie(Scanner sc, EntreeSortie entreeSortie) {

        String pseudoJoueur = entreeSortie.InitalisationNomHero(sc);

        // Initialisation Arme
        Arme armeMain = new Arme("main nue",5);

        // Initialisation Joueur
        Hero hero = new Hero(1,1,100,armeMain,0,pseudoJoueur);

        // Initialisation Carte
        char [][] carte = {{'0','0','0','0','0'},
                           {'0','0','0','0','0'},
                           {'0','0','0','0','0'},
                           {'0','0','0','0','0'},
                           {'0','0','0','0','0'}};

        Donjon Donjon1 = new Donjon(carte);
        System.out.println(Donjon1.getCarte());

    }

}