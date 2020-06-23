package com.cda.model;

import com.cda.program.Program;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class PanelScore extends JPanel {
    private final ImageIcon icoBandeFond;
    private final Image imgBandeFond;
    private ImageIcon icoBoutonQuit = new ImageIcon(this.getClass().getResource("/images/bout-quitter.png"));
    private Image imgBoutonQuit;
    private ImageIcon icoBoutonRejouer;
    private Image imgBoutonRejouer;
    private int decallageScore;
    private Color color;

    public PanelScore(MaFenetre cdaFenetre) {
        this.imgBoutonQuit = this.icoBoutonQuit.getImage();
        this.icoBoutonRejouer = new ImageIcon(this.getClass().getResource("/images/bout-rejouer.png"));
        this.imgBoutonRejouer = this.icoBoutonRejouer.getImage();
        this.decallageScore = 0;
        this.color = new Color(243, 255, 188);
        this.setLayout((LayoutManager) null);
        Font font = new Font("impact", 1, 30);
        this.setSize(cdaFenetre.getWidth(), cdaFenetre.getHeight());
        this.icoBandeFond = new ImageIcon(this.getClass().getResource("/images/fond-scores.png"));
        this.imgBandeFond = this.icoBandeFond.getImage();
        final JPanel boutonQuitter = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(PanelScore.this.imgBoutonQuit, 0, 0, 200, 50, (ImageObserver) null);
            }
        };
        final JPanel boutonRejouer = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(PanelScore.this.imgBoutonRejouer, 0, 0, 200, 50, (ImageObserver) null);
            }
        };
        boutonQuitter.setBounds(50, 750, 200, 50);
        boutonRejouer.setBounds(350, 750, 200, 50);
        boutonQuitter.setOpaque(false);
        boutonRejouer.setOpaque(false);
        this.add(boutonQuitter);
        this.add(boutonRejouer);
        boutonQuitter.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.exit(0);
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                PanelScore.this.icoBoutonQuit = new ImageIcon(this.getClass().getResource("/images/bout-quitter-survol.png"));
                PanelScore.this.imgBoutonQuit = PanelScore.this.icoBoutonQuit.getImage();
                boutonQuitter.repaint();
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                PanelScore.this.icoBoutonQuit = new ImageIcon(this.getClass().getResource("/images/bout-quitter.png"));
                PanelScore.this.imgBoutonQuit = PanelScore.this.icoBoutonQuit.getImage();
                boutonQuitter.repaint();
            }
        });
        boutonRejouer.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Program.vMaFenetre.rejouer();
                GestionCollision.scoreReinit();
                MaFenetre.vBackgroundWindow.repaint();
            }

            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                PanelScore.this.icoBoutonRejouer = new ImageIcon(this.getClass().getResource("/images/bout-rejouer-survol.png"));
                PanelScore.this.imgBoutonRejouer = PanelScore.this.icoBoutonRejouer.getImage();
                boutonRejouer.repaint();
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                PanelScore.this.icoBoutonRejouer = new ImageIcon(this.getClass().getResource("/images/bout-rejouer.png"));
                PanelScore.this.imgBoutonRejouer = PanelScore.this.icoBoutonRejouer.getImage();
                boutonRejouer.repaint();
            }
        });
        FichierSauvegarde.recupererScore();
        Set set2 = FichierSauvegarde.tableauScore.entrySet();
        Iterator iterator2 = set2.iterator();

        for (int i = 0; i < 10 && i < set2.size(); ++i) {
            Entry me2 = (Entry) iterator2.next();
            String result = me2.getKey() + " " + me2.getValue();
            JTextArea area = new JTextArea(result);
            area.setBounds(150, 195 + this.decallageScore, 450, 50);
            area.setOpaque(false);
            area.setFont(font);
            area.setForeground(this.color);
            this.add(area);
            this.decallageScore += 50;
        }

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.imgBandeFond, this.getX(), this.getY(), (ImageObserver) null);
    }
}
