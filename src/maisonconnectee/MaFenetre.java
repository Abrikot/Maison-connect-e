/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maisonconnectee;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;

/**
 *
 * @author Test
 */
public class MaFenetre extends JFrame implements MouseListener {

    private int option;
    private final MotDePasse mdp;
    private String mdpEntre;
    private final Ecriture ecriture;
    private final Ecriture texte;

    private final ArrayList<Bouton> listeMdp;
    //JButton retourAcceuil;
    private final Bouton retour;
    // Ecran Acceuil
    private final Bouton rasp, parametre;
    // Ecran Rasp choix reveil ou alarme
    private final Bouton reveil, intrusion;
    // dans le reveil 
    private final Bouton heure, cafe, lumiere, chauffage, radio, volet, bain;
    // Bain 
    private final Bouton temperature, fondEntreeTexte, annuler, valider;
    private final Bouton plus, moins;
    private final Bouton lum;
    private Ecriture textev; // pour le volet

    //radio
    private final Bouton frequence;
    //Intrusion
    private final Bouton alarme, video;
    //musique
    private final Bouton musique1;
    private final Bouton musique2;
    private final Ecriture textemus;
    //video
    private final Bouton video1;
    //semaine
    private final Ecriture texte_semaine;
    private final Ecriture texte_bouton_semaine;
    //Week
    private final Ecriture texte_week;
    private final Ecriture texte_bouton_week;
    private final Ecriture texte_heure;
    private final Bouton fond_heure;
    private final Bouton fond_minute;
    private final Bouton fondEntreeTexte2;
    private final Ecriture ecritureHeure;
    private final Ecriture ecritureMinutes;
    private int selectionHeure = 0;

    private final Ecriture affichageHeure;

    //Café
    private final Bouton capuccino, nespresso, deca, moka, lait, creme;
    private final Ecriture texte_capu, texte_nes, texte_deca, texte_moka, texte_lait, texte_creme;
    //Café_sucre
    private final Ecriture sucre;

    private final Background background;

    Bain b;
    Cafe c;
    Chauffage h;
    LumiereExterieure lumExt;
    LumiereInterieure lumInt;
    Radio r;
    Reveil e;
    Volets v;
    

    public MaFenetre(Bain b, Cafe c, Chauffage h, LumiereExterieure lumExt, LumiereInterieure lumInt, Radio r, Reveil e, Volets v) {
        this.setTitle("Maison connectée");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        //this.setAlwaysOnTop(true);
        this.setBounds(0, 0, 752, 448);

        this.b = b;
        this.c = c;
        this.h = h;
        this.lumExt = lumExt;
        this.lumInt = lumInt;
        this.r = r;
        this.e = e;
        this.v = v;
        

        mdp = new MotDePasse("0000");
        mdpEntre = "";
        ecriture = new Ecriture("", 36, 200, 50);
        texte = new Ecriture("Tapez votre mot de passe", 26, 300, 50);

        // Bouton retour
        retour = new Bouton("retour.png", 50, 50);

        // Mot de passe
        listeMdp = new ArrayList();
        for (int i = 0; i < 10; i++) {
            listeMdp.add(new Bouton("mdp-b" + i + ".png", 50, 50));
        }
        listeMdp.add(new Bouton("mdp-clear.png", 50, 50));
        listeMdp.add(new Bouton("mdp-valider.png", 50, 50));

        // Accueil
        rasp = new Bouton("raspberry.png", 200, 220);
        parametre = new Bouton("parametres.png", 200, 220);

        // Raspberry
        reveil = new Bouton("reveil.png", 200, 220);
        intrusion = new Bouton("intrusion.png", 200, 220);

        // Réveil        
        heure = new Bouton("horloge.png", 180, 180);
        cafe = new Bouton("cafe.png", 80, 100);
        lumiere = new Bouton("lumiere.png", 80, 100);
        chauffage = new Bouton("radiateur.png", 80, 100);
        radio = new Bouton("radio.png", 80, 100);
        volet = new Bouton("volets.png", 80, 100);
        bain = new Bouton("baignoire.png", 80, 100);

        // Temperature
        temperature = new Bouton("thermometre.png", 300, 240);
        annuler = new Bouton("refuser.png", 80, 80);
        valider = new Bouton("valider.png", 80, 80);
        fondEntreeTexte = new Bouton("entreeTexte.png", 300, 50);

        background = new Background("fond.jpg");

        plus = new Bouton("Plus.png", 80, 80);
        moins = new Bouton("Moins.png", 80, 80);

        textev = new Ecriture("Voulez-vous ouvrir les volets ?", 30, 400, 50);
        lum = new Bouton("luminosite.png", 300, 240);

        //radio
        frequence = new Bouton("frequence.png", 300, 240);
        //intrusion
        alarme = new Bouton("musique.png", 200, 220);
        video = new Bouton("video.png", 200, 220);
        //musique
        musique1 = new Bouton("entreeTexte.png", 300, 50);
        musique2 = new Bouton("entreeTexte.png", 300, 50);
        textemus = new Ecriture("Choisissez une alarme", 30, 300, 50);
        //video
        video1 = new Bouton("entreeTexte.png", 300, 300);

        Date tmp = new Date();
        int heures = tmp.getHours();
        int minutes = tmp.getMinutes();

        texte_semaine = new Ecriture("Entrez l'heure voulue", 26, 300, 50);
        texte_bouton_semaine = new Ecriture("HEURE SEMAINE", 30, 400, 50);
        texte_week = new Ecriture("Entrez l'heure voulue ", 26, 300, 50);
        texte_bouton_week = new Ecriture("HEURE WEEK-END", 30, 500, 50);
        fondEntreeTexte2 = new Bouton("entreeTexte.png", 300, 50);
        fond_heure = new Bouton("entreeTexte.png", 100, 50);
        fond_minute = new Bouton("entreeTexte.png", 100, 50);
        texte_heure = new Ecriture(" H ", 30, 500, 50);
        ecritureHeure = new Ecriture((e.getHeureSemaine() / 100 == 0 ? "00" : (e.getHeureSemaine() / 100 < 10 ? "0" + e.getHeureSemaine() / 100 : e.getHeureSemaine() / 100)) + "", 38, 100, 50);
        ecritureMinutes = new Ecriture((e.getHeureSemaine() % 100 == 0 ? "00" : (e.getHeureSemaine() % 100 < 10 ? "0" + e.getHeureSemaine() % 100 : e.getHeureSemaine() % 100)) + "", 38, 100, 50);

        affichageHeure = new Ecriture((heures == 0 ? "00" : (heures < 10 ? "0" + heures : heures)) + " : " + (minutes == 0 ? "00" : (minutes < 10 ? "0" + minutes : minutes)), 30, 100, 50);

        //café
        capuccino = new Bouton("entreeTexte.png", 300, 50);
        nespresso = new Bouton("entreeTexte.png", 300, 50);
        deca = new Bouton("entreeTexte.png", 300, 50);
        moka = new Bouton("entreeTexte.png", 300, 50);
        lait = new Bouton("entreeTexte.png", 300, 50);
        creme = new Bouton("entreeTexte.png", 300, 50);
        texte_capu = new Ecriture("Capuccino", 26, 300, 50);
        texte_nes = new Ecriture("Nespresso", 26, 300, 50);
        texte_deca = new Ecriture("Décaféiné", 26, 300, 50);
        texte_moka = new Ecriture("Moka", 26, 300, 50);
        texte_lait = new Ecriture("Café au lait", 26, 300, 50);
        texte_creme = new Ecriture("Café à la crème", 26, 300, 50);
        //café_sucre
        sucre = new Ecriture("Souhaitez vous du sucre?", 26, 300, 50);

        // appel fonction 
        option = 0;
        initialisation();

        rasp.addMouseListener(this);
        retour.addMouseListener(this);
        reveil.addMouseListener(this);
        bain.addMouseListener(this);
        chauffage.addMouseListener(this);
        lumiere.addMouseListener(this);
        volet.addMouseListener(this);
        for (int i = 0; i < listeMdp.size(); i++) {
            listeMdp.get(i).addMouseListener(this);
        }
        valider.addMouseListener(this);
        annuler.addMouseListener(this);
        plus.addMouseListener(this);
        moins.addMouseListener(this);
        radio.addMouseListener(this);
        alarme.addMouseListener(this);
        video.addMouseListener(this);
        intrusion.addMouseListener(this);
        heure.addMouseListener(this);
        fondEntreeTexte.addMouseListener(this);
        fondEntreeTexte2.addMouseListener(this);
        cafe.addMouseListener(this);
        capuccino.addMouseListener(this);
        nespresso.addMouseListener(this);
        moka.addMouseListener(this);
        deca.addMouseListener(this);
        lait.addMouseListener(this);
        creme.addMouseListener(this);
    }

    public void initialisation() {
        this.getContentPane().removeAll();
        this.getContentPane().repaint();
        this.getContentPane().setLayout(null);

        /* Numéros pour les options :
        0 : Mot de passe
        1 : Accueil
        2 : Menu Gestion
        3 : Menu Réveil
        4 : Menu température bain
        5 : Menu température chauffage
        6 : Menu luminosité
        7 : Café
        9 : Menu volets
        10 : Choix entre changer l'heure de réveil la semaine et l'heure de réveil le week-end
        11 : Radio
        13 : Semaine
        14 : Week-end
        15 : Intrusion
        16 : Vidéo
        17 : Sonnerie alarme
         */
        switch (option) {
            case 0: // Mot de passe
                for (int i = 1; i < 10; i++) {
                    this.add(listeMdp.get(i));
                    listeMdp.get(i).setBounds(((i - 1) % 3) * 60 + 85, ((i - 1) / 3) * 60 + this.getHeight() / 2 - 115, (int) listeMdp.get(i).getPreferredSize().getWidth(), (int) listeMdp.get(i).getPreferredSize().getHeight());
                }
                this.add(listeMdp.get(0));
                listeMdp.get(0).setBounds(60 + 85, 3 * 60 + this.getHeight() / 2 - 115, (int) listeMdp.get(0).getPreferredSize().getWidth(), (int) listeMdp.get(0).getPreferredSize().getHeight());
                this.add(listeMdp.get(10));
                listeMdp.get(10).setBounds(0 + 85, 3 * 60 + this.getHeight() / 2 - 115, (int) listeMdp.get(10).getPreferredSize().getWidth(), (int) listeMdp.get(10).getPreferredSize().getHeight());
                this.add(listeMdp.get(11));
                listeMdp.get(11).setBounds(120 + 85, 3 * 60 + this.getHeight() / 2 - 115, (int) listeMdp.get(11).getPreferredSize().getWidth(), (int) listeMdp.get(11).getPreferredSize().getHeight());
                this.add(fondEntreeTexte);
                fondEntreeTexte.setBounds((int) (this.getWidth() - fondEntreeTexte.getPreferredSize().getWidth() - 60), (int) ((this.getHeight() - fondEntreeTexte.getPreferredSize().getHeight()) / 2), (int) fondEntreeTexte.getPreferredSize().getWidth(), (int) fondEntreeTexte.getPreferredSize().getHeight());
                this.add(ecriture);
                ecriture.setBounds((int) (this.getWidth() - ecriture.getPreferredSize().getWidth() - 60), (int) ((this.getHeight() - ecriture.getPreferredSize().getHeight()) / 2), (int) ecriture.getPreferredSize().getWidth(), (int) ecriture.getPreferredSize().getHeight());
                this.add(texte);
                texte.setBounds((int) (this.getWidth() - texte.getPreferredSize().getWidth() - 60), (int) ((this.getHeight() - texte.getPreferredSize().getHeight()) / 2 - 80), (int) texte.getPreferredSize().getWidth(), (int) texte.getPreferredSize().getHeight());
                break;
            case 1: // Accueil
                this.add(rasp);
                rasp.setBounds((int) ((this.getWidth() - rasp.getPreferredSize().getWidth()) / 4), (int) ((this.getHeight() - rasp.getPreferredSize().getHeight()) / 2), (int) rasp.getPreferredSize().getWidth(), (int) rasp.getPreferredSize().getHeight());

                this.add(parametre);
                parametre.setBounds((int) (3.0 * (this.getWidth() - rasp.getPreferredSize().getWidth()) / 4), (int) ((this.getHeight() - rasp.getPreferredSize().getHeight()) / 2), (int) parametre.getPreferredSize().getWidth(), (int) parametre.getPreferredSize().getHeight());
                break;
            case 2: // Menu Raspberry
                this.add(retour);
                retour.setBounds(20, 20, (int) retour.getPreferredSize().getWidth(), (int) retour.getPreferredSize().getHeight());

                this.add(reveil);
                reveil.setBounds((int) ((this.getWidth() - reveil.getPreferredSize().getWidth()) / 4), (int) ((this.getHeight() - reveil.getPreferredSize().getHeight()) / 2), (int) reveil.getPreferredSize().getWidth(), (int) reveil.getPreferredSize().getHeight());

                this.add(intrusion);
                intrusion.setBounds((int) (3.0 * (this.getWidth() - intrusion.getPreferredSize().getWidth()) / 4), (int) ((this.getHeight() - intrusion.getPreferredSize().getHeight()) / 2), (int) intrusion.getPreferredSize().getWidth(), (int) intrusion.getPreferredSize().getHeight());
                break;
            case 3: // Menu Réveil
                this.add(retour);
                retour.setBounds(20, 20, (int) retour.getPreferredSize().getWidth(), (int) retour.getPreferredSize().getHeight());

                this.add(heure);
                this.add(cafe);
                this.add(lumiere);
                this.add(chauffage);
                this.add(radio);
                this.add(volet);
                this.add(bain);

                heure.setBounds((int) ((this.getWidth() - heure.getPreferredSize().getWidth()) / 2), (int) ((this.getHeight() - heure.getPreferredSize().getHeight()) / 2), (int) heure.getPreferredSize().getWidth(), (int) heure.getPreferredSize().getHeight());
                cafe.setBounds((int) ((this.getWidth() - cafe.getPreferredSize().getWidth()) / 2), (int) ((1.0 / 40) * this.getHeight()), (int) cafe.getPreferredSize().getWidth(), (int) cafe.getPreferredSize().getHeight());
                radio.setBounds((int) ((this.getWidth() - radio.getPreferredSize().getWidth()) / 2), (int) ((39.0 / 40) * this.getHeight()) - (int) radio.getPreferredSize().getHeight(), (int) radio.getPreferredSize().getWidth(), (int) radio.getPreferredSize().getHeight());
                lumiere.setBounds((int) ((5.0 / 70) * this.getWidth()), (int) ((2.0 / 9) * this.getHeight()), (int) lumiere.getPreferredSize().getWidth(), (int) lumiere.getPreferredSize().getHeight());
                chauffage.setBounds((int) ((5.0 / 70) * this.getWidth()), (int) ((7.0 / 9) * this.getHeight() - chauffage.getPreferredSize().getHeight()), (int) chauffage.getPreferredSize().getWidth(), (int) chauffage.getPreferredSize().getHeight());
                bain.setBounds((int) ((65.0 / 70) * this.getWidth() - bain.getPreferredSize().getWidth()), (int) ((2.0 / 9) * this.getHeight()), (int) bain.getPreferredSize().getWidth(), (int) bain.getPreferredSize().getHeight());
                volet.setBounds((int) ((65.0 / 70) * this.getWidth() - volet.getPreferredSize().getWidth()), (int) ((7.0 / 9) * this.getHeight() - volet.getPreferredSize().getHeight()), (int) volet.getPreferredSize().getWidth(), (int) volet.getPreferredSize().getHeight());
                break;
            case 4: // Température
            case 5: // Température
                this.add(retour);
                retour.setBounds(20, 20, (int) retour.getPreferredSize().getWidth(), (int) retour.getPreferredSize().getHeight());

                this.add(temperature);
                temperature.setBounds((int) ((this.getWidth() - temperature.getPreferredSize().getWidth()) / 2), (int) ((this.getHeight() - temperature.getPreferredSize().getHeight()) / 2) - 30, (int) temperature.getPreferredSize().getWidth(), (int) temperature.getPreferredSize().getHeight());

                this.add(annuler);
                annuler.setBounds((int) (this.getWidth() - annuler.getPreferredSize().getWidth() * 2.5), (int) (this.getHeight() * 3 / 4.0), (int) annuler.getPreferredSize().getWidth(), (int) annuler.getPreferredSize().getHeight());

                this.add(valider);
                valider.setBounds((int) (this.getWidth() - valider.getPreferredSize().getWidth() * 1.25), (int) (this.getHeight() * 3 / 4.0), (int) valider.getPreferredSize().getWidth(), (int) valider.getPreferredSize().getHeight());

                this.add(plus);
                plus.setBounds((int) (10 + valider.getPreferredSize().getWidth() * 1.25), (int) (this.getHeight() * 3 / 4.0), (int) valider.getPreferredSize().getWidth(), (int) valider.getPreferredSize().getHeight());
                this.add(moins);
                moins.setBounds((int) (-90 + valider.getPreferredSize().getWidth() * 1.25), (int) (this.getHeight() * 3 / 4.0), (int) valider.getPreferredSize().getWidth(), (int) valider.getPreferredSize().getHeight());

                this.add(fondEntreeTexte);
                fondEntreeTexte.setBounds((int) ((this.getWidth() - fondEntreeTexte.getPreferredSize().getWidth()) / 2), (int) (valider.getY() + (valider.getPreferredSize().getHeight() - fondEntreeTexte.getPreferredSize().getHeight()) * 1.0 / 2), (int) fondEntreeTexte.getPreferredSize().getWidth(), (int) fondEntreeTexte.getPreferredSize().getHeight());

                ecriture.setTxt((option == 4 ? b.getTemperature() : h.getTemperature()) + "°C");
                this.add(ecriture);
                ecriture.setBounds((int) ((this.getWidth() - ecriture.getPreferredSize().getWidth() / 3) / 2), (int) (valider.getY() + (valider.getPreferredSize().getHeight() - ecriture.getPreferredSize().getHeight()) * 1.0 / 2) - 7, (int) ecriture.getPreferredSize().getWidth(), (int) ecriture.getPreferredSize().getHeight());
                break;
            case 6: // Luminosité
                this.add(retour);
                retour.setBounds(20, 20, (int) retour.getPreferredSize().getWidth(), (int) retour.getPreferredSize().getHeight());

                this.add(annuler);
                annuler.setBounds((int) (this.getWidth() - annuler.getPreferredSize().getWidth() * 2.5), (int) (this.getHeight() * 3 / 4.0), (int) annuler.getPreferredSize().getWidth(), (int) annuler.getPreferredSize().getHeight());

                this.add(valider);
                valider.setBounds((int) (this.getWidth() - valider.getPreferredSize().getWidth() * 1.25), (int) (this.getHeight() * 3 / 4.0), (int) valider.getPreferredSize().getWidth(), (int) valider.getPreferredSize().getHeight());

                this.add(lum);
                lum.setBounds((int) ((this.getWidth() - lum.getPreferredSize().getWidth()) / 2), (int) ((this.getHeight() - lum.getPreferredSize().getHeight()) / 2) - 30, (int) lum.getPreferredSize().getWidth(), (int) lum.getPreferredSize().getHeight());

                this.add(plus);
                plus.setBounds((int) (10 + valider.getPreferredSize().getWidth() * 1.25), (int) (this.getHeight() * 3 / 4.0), (int) valider.getPreferredSize().getWidth(), (int) valider.getPreferredSize().getHeight());
                this.add(moins);
                moins.setBounds((int) (-90 + valider.getPreferredSize().getWidth() * 1.25), (int) (this.getHeight() * 3 / 4.0), (int) valider.getPreferredSize().getWidth(), (int) valider.getPreferredSize().getHeight());

                this.add(fondEntreeTexte);
                fondEntreeTexte.setBounds((int) ((this.getWidth() - fondEntreeTexte.getPreferredSize().getWidth()) / 2), (int) (valider.getY() + (valider.getPreferredSize().getHeight() - fondEntreeTexte.getPreferredSize().getHeight()) * 1.0 / 2), (int) fondEntreeTexte.getPreferredSize().getWidth(), (int) fondEntreeTexte.getPreferredSize().getHeight());

                ecriture.setTxt(lumInt.getLuminosite() + "%");
                this.add(ecriture);
                ecriture.setBounds((int) ((this.getWidth() - ecriture.getPreferredSize().getWidth() / 3) / 2), (int) (valider.getY() + (valider.getPreferredSize().getHeight() - ecriture.getPreferredSize().getHeight()) * 1.0 / 2) - 7, (int) ecriture.getPreferredSize().getWidth(), (int) ecriture.getPreferredSize().getHeight());
                break;
            case 9: // Volets
                this.add(retour);
                retour.setBounds(20, 20, (int) retour.getPreferredSize().getWidth(), (int) retour.getPreferredSize().getHeight());

                textev.setTxt(v.isPosition() ? "Voulez-vous fermer les volets ?" : "Voulez-vous ouvrir les volets ?");
                this.add(textev);
                textev.setBounds((int) (this.getWidth() - textev.getPreferredSize().getWidth() - 190), (int) ((this.getHeight() - textev.getPreferredSize().getHeight()) / 2 - 80), (int) textev.getPreferredSize().getWidth(), (int) textev.getPreferredSize().getHeight());

                this.add(valider);
                valider.setBounds(230, 250, (int) valider.getPreferredSize().getWidth(), (int) valider.getPreferredSize().getHeight());

                this.add(annuler);
                annuler.setBounds(380, 250, (int) annuler.getPreferredSize().getWidth(), (int) annuler.getPreferredSize().getHeight());
                break;
            case 11:
                this.add(retour);
                retour.setBounds(20, 20, (int) retour.getPreferredSize().getWidth(), (int) retour.getPreferredSize().getHeight());

                this.add(annuler);
                annuler.setBounds((int) (this.getWidth() - annuler.getPreferredSize().getWidth() * 2.5), (int) (this.getHeight() * 3 / 4.0), (int) annuler.getPreferredSize().getWidth(), (int) annuler.getPreferredSize().getHeight());

                this.add(plus);
                plus.setBounds((int) (10 + valider.getPreferredSize().getWidth() * 1.25), (int) (this.getHeight() * 3 / 4.0), (int) valider.getPreferredSize().getWidth(), (int) valider.getPreferredSize().getHeight());

                this.add(moins);
                moins.setBounds((int) (-90 + valider.getPreferredSize().getWidth() * 1.25), (int) (this.getHeight() * 3 / 4.0), (int) valider.getPreferredSize().getWidth(), (int) valider.getPreferredSize().getHeight());

                this.add(valider);
                valider.setBounds((int) (this.getWidth() - valider.getPreferredSize().getWidth() * 1.25), (int) (this.getHeight() * 3 / 4.0), (int) valider.getPreferredSize().getWidth(), (int) valider.getPreferredSize().getHeight());

                this.add(frequence);
                frequence.setBounds((int) ((this.getWidth() - frequence.getPreferredSize().getWidth()) / 2), (int) ((this.getHeight() - frequence.getPreferredSize().getHeight()) / 2) - 30, (int) frequence.getPreferredSize().getWidth(), (int) frequence.getPreferredSize().getHeight());

                ecriture.setTxt(r.getFrequence() + "MHz");
                this.add(ecriture);
                ecriture.setBounds((int) ((this.getWidth() - ecriture.getPreferredSize().getWidth() / 3) / 2), (int) (valider.getY() + (valider.getPreferredSize().getHeight() - ecriture.getPreferredSize().getHeight()) * 1.0 / 2) - 7, (int) ecriture.getPreferredSize().getWidth(), (int) ecriture.getPreferredSize().getHeight());

                this.add(fondEntreeTexte);
                fondEntreeTexte.setBounds((int) ((this.getWidth() - fondEntreeTexte.getPreferredSize().getWidth()) / 2), (int) (valider.getY() + (valider.getPreferredSize().getHeight() - fondEntreeTexte.getPreferredSize().getHeight()) * 1.0 / 2), (int) fondEntreeTexte.getPreferredSize().getWidth(), (int) fondEntreeTexte.getPreferredSize().getHeight());
                break;
            case 15://Intrusion
                this.add(retour);
                retour.setBounds(20, 20, (int) retour.getPreferredSize().getWidth(), (int) retour.getPreferredSize().getHeight());

                this.add(alarme);
                alarme.setBounds((int) ((this.getWidth() - alarme.getPreferredSize().getWidth()) / 4), (int) ((this.getHeight() - alarme.getPreferredSize().getHeight()) / 2), (int) alarme.getPreferredSize().getWidth(), (int) alarme.getPreferredSize().getHeight());

                this.add(video);
                video.setBounds((int) (3.0 * (this.getWidth() - video.getPreferredSize().getWidth()) / 4), (int) ((this.getHeight() - video.getPreferredSize().getHeight()) / 2), (int) video.getPreferredSize().getWidth(), (int) video.getPreferredSize().getHeight());
                break;
            case 16://video
                this.add(retour);
                retour.setBounds(20, 20, (int) retour.getPreferredSize().getWidth(), (int) retour.getPreferredSize().getHeight());

                this.add(video1);
                video1.setBounds((int) ((this.getWidth() - video1.getPreferredSize().getWidth()) / 2), (int) ((this.getHeight() - video1.getPreferredSize().getHeight()) / 2), (int) video1.getPreferredSize().getWidth(), (int) video1.getPreferredSize().getHeight());
                break;
            case 17://musique
                this.add(retour);
                retour.setBounds(20, 20, (int) retour.getPreferredSize().getWidth(), (int) retour.getPreferredSize().getHeight());

                this.add(musique1);
                musique1.setBounds((int) ((this.getWidth() - musique1.getPreferredSize().getWidth()) / 2), (int) ((this.getHeight() - musique1.getPreferredSize().getHeight()) / 2), (int) musique1.getPreferredSize().getWidth(), (int) musique1.getPreferredSize().getHeight());
                this.add(musique2);
                musique2.setBounds((int) ((this.getWidth() - musique2.getPreferredSize().getWidth()) / 2), (int) ((this.getHeight() - musique1.getPreferredSize().getHeight()) / 3), (int) musique2.getPreferredSize().getWidth(), (int) musique2.getPreferredSize().getHeight());
                this.add(textemus);
                textemus.setBounds((int) ((this.getWidth() - textemus.getPreferredSize().getWidth()) / 2), (int) ((this.getHeight() - textemus.getPreferredSize().getHeight()) / 5), (int) textemus.getPreferredSize().getWidth(), (int) textemus.getPreferredSize().getHeight());

                this.add(valider);
                valider.setBounds((int) ((this.getWidth() - valider.getPreferredSize().getWidth()) / 2 - 50), 300, (int) valider.getPreferredSize().getWidth(), (int) valider.getPreferredSize().getHeight());

                this.add(annuler);
                annuler.setBounds((int) ((this.getWidth() - annuler.getPreferredSize().getWidth()) / 2 + 50), 300, (int) annuler.getPreferredSize().getWidth(), (int) annuler.getPreferredSize().getHeight());
                break;
            case 13: // Pour la semaine
                this.add(retour);
                retour.setBounds(20, 20, (int) retour.getPreferredSize().getWidth(), (int) retour.getPreferredSize().getHeight());

                for (int i = 1; i < 10; i++) {
                    this.add(listeMdp.get(i));
                    listeMdp.get(i).setBounds(((i - 1) % 3) * 60 + 85, ((i - 1) / 3) * 60 + this.getHeight() / 2 - 115, (int) listeMdp.get(i).getPreferredSize().getWidth(), (int) listeMdp.get(i).getPreferredSize().getHeight());
                }
                this.add(listeMdp.get(0));
                listeMdp.get(0).setBounds(60 + 85, 3 * 60 + this.getHeight() / 2 - 115, (int) listeMdp.get(0).getPreferredSize().getWidth(), (int) listeMdp.get(0).getPreferredSize().getHeight());
                this.add(listeMdp.get(10));
                listeMdp.get(10).setBounds(0 + 85, 3 * 60 + this.getHeight() / 2 - 115, (int) listeMdp.get(10).getPreferredSize().getWidth(), (int) listeMdp.get(10).getPreferredSize().getHeight());
                this.add(listeMdp.get(11));
                listeMdp.get(11).setBounds(120 + 85, 3 * 60 + this.getHeight() / 2 - 115, (int) listeMdp.get(11).getPreferredSize().getWidth(), (int) listeMdp.get(11).getPreferredSize().getHeight());
                this.add(texte_semaine);
                texte_semaine.setBounds((int) (this.getWidth() - texte_semaine.getPreferredSize().getWidth() - 60), (int) ((this.getHeight() - texte_semaine.getPreferredSize().getHeight()) / 2 - 80), (int) texte.getPreferredSize().getWidth(), (int) texte.getPreferredSize().getHeight());
                this.add(fond_heure);
                fond_heure.setBounds((int) (this.getWidth() - fond_heure.getPreferredSize().getWidth() - 260), (int) ((this.getHeight() - fond_heure.getPreferredSize().getHeight()) / 2), (int) fond_heure.getPreferredSize().getWidth(), (int) fond_heure.getPreferredSize().getHeight());
                this.add(fond_minute);
                fond_minute.setBounds((int) (this.getWidth() - fond_minute.getPreferredSize().getWidth() - 110), (int) ((this.getHeight() - fond_minute.getPreferredSize().getHeight()) / 2), (int) fond_minute.getPreferredSize().getWidth(), (int) fond_minute.getPreferredSize().getHeight());
                this.add(texte_heure);
                texte_heure.setBounds(500, 195, (int) texte_heure.getPreferredSize().getWidth(), (int) texte_heure.getPreferredSize().getHeight());
                ecritureHeure.setTxt((e.getHeureSemaine() / 100 == 0 ? "00" : (e.getHeureSemaine() / 100 < 10 ? "0" + e.getHeureSemaine() / 100 : e.getHeureSemaine() / 100)) + "");
                ecritureMinutes.setTxt((e.getHeureSemaine() % 100 == 0 ? "00" : (e.getHeureSemaine() % 100 < 10 ? "0" + e.getHeureSemaine() % 100 : e.getHeureSemaine() % 100)) + "");
                this.add(ecritureHeure);
                ecritureHeure.setBounds((int) (this.getWidth() - fond_heure.getPreferredSize().getWidth() - 230), (int) ((this.getHeight() - fond_heure.getPreferredSize().getHeight()) / 2) - 5, (int) ecritureHeure.getPreferredSize().getWidth(), (int) ecritureHeure.getPreferredSize().getHeight());
                this.add(ecritureMinutes);
                ecritureMinutes.setBounds((int) (this.getWidth() - fond_minute.getPreferredSize().getWidth() - 80), (int) ((this.getHeight() - fond_minute.getPreferredSize().getHeight()) / 2) - 5, (int) ecritureMinutes.getPreferredSize().getWidth(), (int) ecritureMinutes.getPreferredSize().getHeight());
                break;

            case 14: // le week
                this.add(retour);
                retour.setBounds(20, 20, (int) retour.getPreferredSize().getWidth(), (int) retour.getPreferredSize().getHeight());

                for (int i = 1; i < 10; i++) {
                    this.add(listeMdp.get(i));
                    listeMdp.get(i).setBounds(((i - 1) % 3) * 60 + 85, ((i - 1) / 3) * 60 + this.getHeight() / 2 - 115, (int) listeMdp.get(i).getPreferredSize().getWidth(), (int) listeMdp.get(i).getPreferredSize().getHeight());
                }
                this.add(listeMdp.get(0));
                listeMdp.get(0).setBounds(60 + 85, 3 * 60 + this.getHeight() / 2 - 115, (int) listeMdp.get(0).getPreferredSize().getWidth(), (int) listeMdp.get(0).getPreferredSize().getHeight());
                this.add(listeMdp.get(10));
                listeMdp.get(10).setBounds(0 + 85, 3 * 60 + this.getHeight() / 2 - 115, (int) listeMdp.get(10).getPreferredSize().getWidth(), (int) listeMdp.get(10).getPreferredSize().getHeight());
                this.add(listeMdp.get(11));
                listeMdp.get(11).setBounds(120 + 85, 3 * 60 + this.getHeight() / 2 - 115, (int) listeMdp.get(11).getPreferredSize().getWidth(), (int) listeMdp.get(11).getPreferredSize().getHeight());
                this.add(texte_week);
                texte_week.setBounds((int) (this.getWidth() - texte_week.getPreferredSize().getWidth() - 60), (int) ((this.getHeight() - texte_week.getPreferredSize().getHeight()) / 2 - 80), (int) texte_week.getPreferredSize().getWidth(), (int) texte_week.getPreferredSize().getHeight());
                this.add(fond_heure);
                fond_heure.setBounds((int) (this.getWidth() - fond_heure.getPreferredSize().getWidth() - 260), (int) ((this.getHeight() - fond_heure.getPreferredSize().getHeight()) / 2), (int) fond_heure.getPreferredSize().getWidth(), (int) fond_heure.getPreferredSize().getHeight());
                this.add(fond_minute);
                fond_minute.setBounds((int) (this.getWidth() - fond_minute.getPreferredSize().getWidth() - 110), (int) ((this.getHeight() - fond_minute.getPreferredSize().getHeight()) / 2), (int) fond_minute.getPreferredSize().getWidth(), (int) fond_minute.getPreferredSize().getHeight());
                this.add(texte_heure);
                texte_heure.setBounds(500, 195, (int) texte_heure.getPreferredSize().getWidth(), (int) texte_heure.getPreferredSize().getHeight());

                ecritureHeure.setTxt((e.getHeureWeekEnd() / 100 == 0 ? "00" : (e.getHeureWeekEnd() / 100 < 10 ? "0" + e.getHeureWeekEnd() / 100 : e.getHeureWeekEnd() / 100)) + "");
                ecritureMinutes.setTxt((e.getHeureWeekEnd() % 100 == 0 ? "00" : (e.getHeureWeekEnd() % 100 < 10 ? "0" + e.getHeureWeekEnd() % 100 : e.getHeureWeekEnd() % 100)) + "");
                this.add(ecritureHeure);
                ecritureHeure.setBounds((int) (this.getWidth() - fond_heure.getPreferredSize().getWidth() - 230), (int) ((this.getHeight() - fond_heure.getPreferredSize().getHeight()) / 2) - 5, (int) ecritureHeure.getPreferredSize().getWidth(), (int) ecritureHeure.getPreferredSize().getHeight());
                this.add(ecritureMinutes);
                ecritureMinutes.setBounds((int) (this.getWidth() - fond_minute.getPreferredSize().getWidth() - 80), (int) ((this.getHeight() - fond_minute.getPreferredSize().getHeight()) / 2) - 5, (int) ecritureMinutes.getPreferredSize().getWidth(), (int) ecritureMinutes.getPreferredSize().getHeight());
                break;
            case 10:
                this.add(retour);
                retour.setBounds(20, 20, (int) retour.getPreferredSize().getWidth(), (int) retour.getPreferredSize().getHeight());

                this.add(fondEntreeTexte);
                fondEntreeTexte.setBounds(200, 250, (int) fondEntreeTexte.getPreferredSize().getWidth(), (int) fondEntreeTexte.getPreferredSize().getHeight());

                this.add(fondEntreeTexte2);
                fondEntreeTexte2.setBounds(200, 100, (int) fondEntreeTexte2.getPreferredSize().getWidth(), (int) fondEntreeTexte2.getPreferredSize().getHeight());

                this.add(texte_bouton_semaine);
                texte_bouton_semaine.setBounds(250, 245, (int) texte_bouton_semaine.getPreferredSize().getWidth(), (int) texte_bouton_semaine.getPreferredSize().getHeight());

                this.add(texte_bouton_week);
                texte_bouton_week.setBounds(250, 95, (int) texte_bouton_week.getPreferredSize().getWidth(), (int) texte_bouton_week.getPreferredSize().getHeight());

                break;
            case 18://cafe
                this.add(retour);
                retour.setBounds(20, 20, (int) retour.getPreferredSize().getWidth(), (int) retour.getPreferredSize().getHeight());

                this.add(capuccino);
                capuccino.setBounds(50, 100, (int) capuccino.getPreferredSize().getWidth(), (int) capuccino.getPreferredSize().getHeight());
                this.add(texte_capu);
                texte_capu.setBounds(125, 90, (int) capuccino.getPreferredSize().getWidth(), (int) capuccino.getPreferredSize().getHeight());

                this.add(nespresso);
                nespresso.setBounds(50, 175, (int) nespresso.getPreferredSize().getWidth(), (int) nespresso.getPreferredSize().getHeight());
                this.add(texte_nes);
                texte_nes.setBounds(125, 165, (int) nespresso.getPreferredSize().getWidth(), (int) nespresso.getPreferredSize().getHeight());

                this.add(deca);
                deca.setBounds(50, 250, (int) deca.getPreferredSize().getWidth(), (int) deca.getPreferredSize().getHeight());
                this.add(texte_deca);
                texte_deca.setBounds(125, 240, (int) deca.getPreferredSize().getWidth(), (int) deca.getPreferredSize().getHeight());

                this.add(moka);
                moka.setBounds(400, 100, (int) moka.getPreferredSize().getWidth(), (int) moka.getPreferredSize().getHeight());
                this.add(texte_moka);
                texte_moka.setBounds(475, 90, (int) moka.getPreferredSize().getWidth(), (int) moka.getPreferredSize().getHeight());

                this.add(lait);
                lait.setBounds(400, 175, (int) lait.getPreferredSize().getWidth(), (int) lait.getPreferredSize().getHeight());
                this.add(texte_lait);
                texte_lait.setBounds(475, 165, (int) lait.getPreferredSize().getWidth(), (int) lait.getPreferredSize().getHeight());

                this.add(creme);
                creme.setBounds(400, 250, (int) creme.getPreferredSize().getWidth(), (int) creme.getPreferredSize().getHeight());
                this.add(texte_creme);
                texte_creme.setBounds(475, 240, (int) creme.getPreferredSize().getWidth(), (int) creme.getPreferredSize().getHeight());
                break;
            case 19://sucre
                this.add(retour);
                retour.setBounds(20, 20, (int) retour.getPreferredSize().getWidth(), (int) retour.getPreferredSize().getHeight());

                this.add(sucre);
                sucre.setBounds((int) (this.getWidth() - sucre.getPreferredSize().getWidth() - 200), (int) ((this.getHeight() - sucre.getPreferredSize().getHeight()) / 2 - 80), (int) sucre.getPreferredSize().getWidth(), (int) sucre.getPreferredSize().getHeight());
                this.add(valider);
                valider.setBounds((int) ((this.getWidth() - valider.getPreferredSize().getWidth()) / 2 - 50), 250, (int) valider.getPreferredSize().getWidth(), (int) valider.getPreferredSize().getHeight());

                this.add(annuler);
                annuler.setBounds((int) ((this.getWidth() - annuler.getPreferredSize().getWidth()) / 2 + 50), 250, (int) annuler.getPreferredSize().getWidth(), (int) annuler.getPreferredSize().getHeight());
                break;
        }

        this.add(affichageHeure);
        affichageHeure.setBounds(this.getWidth() - 150, 10, (int) affichageHeure.getPreferredSize().getWidth(), (int) affichageHeure.getPreferredSize().getWidth());

        this.add(background);
        background.setBounds(0, 0, (int) background.getPreferredSize().getWidth(), (int) background.getPreferredSize().getHeight());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == heure) {
            option = 10;
            initialisation();
            return;
        }
        if (e.getSource() == fondEntreeTexte) {
            option = 13;
            initialisation();
            return;
        }
        if (e.getSource() == fondEntreeTexte2) {
            option = 14;
            initialisation();
            return;
        }

        if (e.getSource() == intrusion) {
            option = 15;
            initialisation();
            return;
        }

        if (e.getSource() == rasp) {
            option = 2;
            initialisation();
            return;
        }
        if (e.getSource() == retour) {
            switch (option) {
                case 2:
                    option = 1;
                    break;
                case 3:
                case 15:
                    option = 2;
                    break;
                case 4:
                case 5:
                case 6:
                case 9:
                case 10:
                case 11:
                case 18:
                    option = 3;
                    break;
                case 16:
                case 17:
                    option = 15;
                    break;
                case 13:
                case 14:
                    option = 10;
                    break;
                case 19:
                    option = 18;
                    break;
            }
            initialisation();
            return;
        }
        if (e.getSource() == reveil) {
            option = 3;
            initialisation();
            return;
        }
        if (e.getSource() == bain) {
            option = 4;
            initialisation();
            return;
        }
        if (e.getSource() == chauffage) {
            option = 5;
            initialisation();
            return;
        }

        if (e.getSource() == lumiere) {
            option = 6;
            initialisation();
            return;
        }

        if (e.getSource() == volet) {
            option = 9;
            initialisation();
            return;
        }

        if (e.getSource() == radio) {
            option = 11;
            initialisation();
            return;
        }

        if (e.getSource() == video) {
            option = 16;
            initialisation();
            return;
        }
        if (e.getSource() == alarme) {
            option = 17;
            initialisation();
            return;
        }

        if (e.getSource() == cafe) {
            option = 18;
            initialisation();
            return;
        }

        if (e.getSource() == deca || e.getSource() == capuccino
                || e.getSource() == nespresso || e.getSource() == moka
                || e.getSource() == lait || e.getSource() == creme) {
            if (e.getSource() == capuccino) {
                c.setType(1);
            }
            if (e.getSource() == moka) {
                c.setType(2);
            }
            if (e.getSource() == nespresso) {
                c.setType(3);
            }
            if (e.getSource() == lait) {
                c.setType(4);
            }
            if (e.getSource() == deca) {
                c.setType(5);
            }
            if (e.getSource() == creme) {
                c.setType(6);
            }

            option = 19;
            initialisation();
            return;
        }

        for (int i = 0; i < 10; i++) {
            switch (option) {
                case 0:
                    if (e.getSource() == listeMdp.get(i)) {
                        mdpEntre += i;
                        String tmp = "";
                        for (int j = 0; j < mdpEntre.length(); j++) {
                            tmp += "*";
                        }
                        ecriture.setTxt(tmp);
                        ecriture.repaint();
                        return;
                    }
                    break;
                case 13:
                case 14:
                    if (e.getSource() == listeMdp.get(i)) {
                        System.out.println(i);
                        switch (selectionHeure) {
                            case 0:
                                ecritureHeure.setTxt("0" + i);
                                ecritureHeure.repaint();
                                selectionHeure = 1;
                                break;
                            case 1:
                                if (Integer.parseInt(ecritureHeure.getTxt()) != 0)
                                {
                                    ecritureHeure.setTxt((Integer.parseInt(ecritureHeure.getTxt()) * 10 + i > 23) ? "23" : Integer.parseInt(ecritureHeure.getTxt()) * 10 + i + "");
                                    ecritureHeure.repaint();
                                    selectionHeure = 2;
                                    break;
                                }
                                else
                                {
                                    ecritureHeure.setTxt("0" + i);
                                    ecritureHeure.repaint();
                                    selectionHeure = 2;
                                    break;
                                }
                            case 2:
                                ecritureMinutes.setTxt("0" + i);
                                ecritureMinutes.repaint();
                                selectionHeure = 3;
                                break;
                            case 3:
                                if (Integer.parseInt(ecritureMinutes.getTxt()) != 0)
                                {
                                    ecritureMinutes.setTxt((Integer.parseInt(ecritureMinutes.getTxt()) * 10 + i > 59) ? "59" : Integer.parseInt(ecritureMinutes.getTxt()) * 10 + i + "");
                                    ecritureMinutes.repaint();
                                    selectionHeure = 4;
                                    break;
                                }
                                else
                                {
                                    ecritureMinutes.setTxt("0" + i);
                                    ecritureMinutes.repaint();
                                    selectionHeure = 4;
                                    break;
                                }
                        }
                    }
            }
        }
        if (e.getSource() == listeMdp.get(10)) {
            System.out.println("Annuler");
            switch (option)
            {
                case 0:
                    mdpEntre = "";
                    ecriture.setTxt("");
                    ecriture.repaint();
                    return;
                case 13:
                    ecritureHeure.setTxt((this.e.getHeureSemaine()/ 100 == 0 ? "00" : (this.e.getHeureSemaine() / 100 < 10 ? "0" + this.e.getHeureSemaine() / 100 : this.e.getHeureSemaine() / 100)) + "");
                    ecritureMinutes.setTxt((this.e.getHeureSemaine() % 100 == 0 ? "00" : (this.e.getHeureSemaine() % 100 < 10 ? "0" + this.e.getHeureSemaine() % 100 : this.e.getHeureSemaine() % 100)) + "");
                    selectionHeure = 0;
                    return;
                case 14:
                    ecritureHeure.setTxt((this.e.getHeureWeekEnd() / 100 == 0 ? "00" : (this.e.getHeureWeekEnd() / 100 < 10 ? "0" + this.e.getHeureWeekEnd() / 100 : this.e.getHeureWeekEnd() / 100)) + "");
                    ecritureMinutes.setTxt((this.e.getHeureWeekEnd() % 100 == 0 ? "00" : (this.e.getHeureWeekEnd() % 100 < 10 ? "0" + this.e.getHeureWeekEnd() % 100 : this.e.getHeureWeekEnd() % 100)) + "");
                    selectionHeure = 0;
                    return;
            }
        }
        
        if (e.getSource() == listeMdp.get(11)) {
            System.out.println("Valider");
            switch (option)
            {
                case 0:
                    if (mdp.compareMdp(mdpEntre)) {
                        option = 1;
                        initialisation();
                        return;
                    } else {
                        texte.setTxt("Mot de passe incorrect");
                        texte.repaint();
                        mdpEntre = "";
                        ecriture.setTxt(mdpEntre);
                        ecriture.repaint();
                        System.out.println("Erreur !");
                        return;
                    }
                case 13:
                    this.e.setHeureSemaine(Integer.parseInt(ecritureHeure.getTxt()) * 100 + Integer.parseInt(ecritureMinutes.getTxt()));
                    option = 3;
                    selectionHeure = 0;
                    initialisation();
                    return;
                case 14:
                    this.e.setHeureWeekEnd(Integer.parseInt(ecritureHeure.getTxt()) * 100 + Integer.parseInt(ecritureMinutes.getTxt()));
                    option = 3;
                    selectionHeure = 0;
                    initialisation();
                    return;
            }
        }

        if (e.getSource() == valider) {
            switch (option) {
                case 4:
                    b.setTemperature(Float.parseFloat(ecriture.getTxt().substring(0, ecriture.getTxt().indexOf("°C"))));
                    option = 3;
                    break;
                case 5:
                    h.setTemperature(Float.parseFloat(ecriture.getTxt().substring(0, ecriture.getTxt().indexOf("°C"))));
                    option = 3;
                    break;
                case 6:
                    lumInt.setLuminosite(Integer.parseInt(ecriture.getTxt().substring(0, ecriture.getTxt().indexOf("%"))));
                    option = 3;
                    break;
                case 9:
                    v.ouvrir();
                    option = 3;
                    break;
                case 11:
                    r.setFrequence(Float.parseFloat(ecriture.getTxt().substring(0, ecriture.getTxt().indexOf("MHz"))));
                    option = 3;
                    break;
                case 17:
                    option = 15;
                    break;
                case 19:
                    c.setSucre(true);
                    option = 3;
                    break;
            }
            initialisation();
            return;
        }

        if (e.getSource() == annuler) {
            switch (option) {
                case 4:
                case 5:
                case 6:
                case 11:
                    option = 3;
                    break;
                case 9:
                    v.fermer();
                    option=3;
                    break;
                case 17:
                    option = 15;
                    break;
                case 19:
                    c.setSucre(false);
                    option = 3;
                    break;
            }
            initialisation();
            return;
        }

        if (e.getSource() == plus) {
            switch (option) {
                case 4:
                    if (Float.parseFloat(ecriture.getTxt().substring(0, ecriture.getTxt().indexOf("°C"))) <= 39.5) {
                        ecriture.setTxt((Float.parseFloat(ecriture.getTxt().substring(0, ecriture.getTxt().indexOf("°C"))) + 0.5) + "°C");
                        ecriture.repaint();
                    }
                    break;
                case 5:
                    if (Float.parseFloat(ecriture.getTxt().substring(0, ecriture.getTxt().indexOf("°C"))) <= 24.5) {
                        ecriture.setTxt((Float.parseFloat(ecriture.getTxt().substring(0, ecriture.getTxt().indexOf("°C"))) + 0.5) + "°C");
                        ecriture.repaint();
                    }
                    break;
                case 6:
                    if (Integer.parseInt(ecriture.getTxt().substring(0, ecriture.getTxt().indexOf("%"))) <= 90) {
                        ecriture.setTxt((Integer.parseInt(ecriture.getTxt().substring(0, ecriture.getTxt().indexOf("%"))) + 10) + "%");
                        ecriture.repaint();
                    }
                    break;
                case 11:
                    if (Float.parseFloat(ecriture.getTxt().substring(0, ecriture.getTxt().indexOf("MHz"))) <= 107.5) {
                        ecriture.setTxt((Float.parseFloat(ecriture.getTxt().substring(0, ecriture.getTxt().indexOf("MHz"))) + 0.5) + "MHz");
                        ecriture.repaint();
                    }
                    break;
            }
            return;
        }
        if (e.getSource() == moins) {
            switch (option) {
                case 4:
                    if (Float.parseFloat(ecriture.getTxt().substring(0, ecriture.getTxt().indexOf("°C"))) >= 30.5) {
                        ecriture.setTxt((Float.parseFloat(ecriture.getTxt().substring(0, ecriture.getTxt().indexOf("°C"))) - 0.5) + "°C");
                        ecriture.repaint();
                    }
                    break;
                case 5:
                    if (Float.parseFloat(ecriture.getTxt().substring(0, ecriture.getTxt().indexOf("°C"))) >= 14.5) {
                        ecriture.setTxt((Float.parseFloat(ecriture.getTxt().substring(0, ecriture.getTxt().indexOf("°C"))) - 0.5) + "°C");
                        ecriture.repaint();
                    }
                    break;
                case 6:
                    if (Integer.parseInt(ecriture.getTxt().substring(0, ecriture.getTxt().indexOf("%"))) >= 10) {
                        ecriture.setTxt((Integer.parseInt(ecriture.getTxt().substring(0, ecriture.getTxt().indexOf("%"))) - 10) + "%");
                        ecriture.repaint();
                    }
                    break;
                case 11:
                    if (Float.parseFloat(ecriture.getTxt().substring(0, ecriture.getTxt().indexOf("MHz"))) >= 87.5) {
                        ecriture.setTxt((Float.parseFloat(ecriture.getTxt().substring(0, ecriture.getTxt().indexOf("MHz"))) - 0.5) + "MHz");
                        ecriture.repaint();
                    }
                    break;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public void changementHeure() {
        Date tmp = new Date();
        int heures = tmp.getHours();
        int minutes = tmp.getMinutes();
        affichageHeure.setTxt((heures == 0 ? "00" : (heures < 10 ? "0" + heures : heures)) + " : " + (minutes == 0 ? "00" : (minutes < 10 ? "0" + minutes : minutes)));
        affichageHeure.repaint();
    }
}
