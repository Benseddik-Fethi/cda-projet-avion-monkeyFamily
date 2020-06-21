package com.cda.model;

import com.cda.program.Program;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PanelScore extends JPanel {
    private final ImageIcon icoBandeFond;
    private final Image imgBandeFond;
    private ImageIcon icoBoutonQuit = new ImageIcon(getClass().getResource(Constantes.BOUTON_QUITTER));
    private Image imgBoutonQuit = icoBoutonQuit.getImage();
    private ImageIcon icoBoutonRejouer = new ImageIcon(getClass().getResource(Constantes.BOUTON_REJOUER));
    private Image imgBoutonRejouer = icoBoutonRejouer.getImage();
    private int decallageScore = 0;
    private Color color = new Color(243, 255, 188);

    public PanelScore(final MaFenetre cdaFenetre) {
        this.setLayout(null);
        Font font = new Font("impact", Font.BOLD, 30);
        setSize(cdaFenetre.getWidth(), cdaFenetre.getHeight());
        this.icoBandeFond = new ImageIcon(getClass().getResource(Constantes.IMAGE_FOND_SCORE));
        this.imgBandeFond = this.icoBandeFond.getImage();

        JPanel boutonQuitter = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imgBoutonQuit, 0, 0, 200, 50, null);
            }
        };
        JPanel boutonRejouer = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imgBoutonRejouer, 0, 0, 200, 50, null);
            }
        };
        boutonQuitter.setBounds(50, 750, 200, 50);
        boutonRejouer.setBounds(350, 750, 200, 50);
        boutonQuitter.setOpaque(false);
        boutonRejouer.setOpaque(false);
        this.add(boutonQuitter);
        this.add(boutonRejouer);
        boutonQuitter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.exit(0);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                icoBoutonQuit = new ImageIcon(getClass().getResource(Constantes.BOUTON_QUITTER_HOVER));
                imgBoutonQuit = icoBoutonQuit.getImage();
                boutonQuitter.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                icoBoutonQuit = new ImageIcon(getClass().getResource(Constantes.BOUTON_QUITTER));
                imgBoutonQuit = icoBoutonQuit.getImage();
                boutonQuitter.repaint();

            }
        });
        boutonRejouer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Program.vMaFenetre.rejouer();
                GestionCollision.scoreReinit();
                MaFenetre.vBackgroundWindow.repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                icoBoutonRejouer = new ImageIcon(getClass().getResource(Constantes.BOUTON_REJOUER_HOVER));
                imgBoutonRejouer = icoBoutonRejouer.getImage();
                boutonRejouer.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                icoBoutonRejouer = new ImageIcon(getClass().getResource(Constantes.BOUTON_REJOUER));
                imgBoutonRejouer = icoBoutonRejouer.getImage();
                boutonRejouer.repaint();

            }
        });
        FichierSauvegarde.recupererScore();
        Set set2 = FichierSauvegarde.tableauScore.entrySet();
        Iterator iterator2 = set2.iterator();
        for (int i = 0; i < 10 || i>set2.size(); i++) {
                Map.Entry me2 = (Map.Entry) iterator2.next();
                String result = me2.getKey() + " " + me2.getValue();
            JTextArea area = new JTextArea(result);

            area.setBounds(150, 195 + decallageScore, 450, 50);
            area.setOpaque(false);
            area.setFont(font);
            area.setForeground(color);
            this.add(area);
            decallageScore += 50;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imgBandeFond, this.getX(), this.getY(), null);
    }
}
